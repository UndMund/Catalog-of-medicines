package by.zavadskiy.facade.impl;

import by.zavadskiy.facade.dto.user.UserDtoCreateRequest;
import by.zavadskiy.facade.dto.user.UserDtoResponse;
import by.zavadskiy.facade.interfaces.IUserFacade;
import by.zavadskiy.facade.interfaces.IUserValidationFacade;
import by.zavadskiy.facade.mappers.UserMapper;
import by.zavadskiy.service.interfaces.IUserService;
import by.zavadskiy.service.interfaces.IUserValidationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserFacade implements IUserFacade, IUserValidationFacade, UserDetailsService {
    private final IUserService userService;
    private final IUserValidationService userValidationService;
    private final UserMapper userMapper;

    @Override
    public UserDtoResponse create(UserDtoCreateRequest userDtoCreateRequest) {
        return Optional.of(userDtoCreateRequest)
                .map(userMapper::toEntity)
                .map(userService::save)
                .map(userMapper::toDto)
                .get();
    }

    @Override
    public boolean isValidUsername(String username) {
        return userValidationService.isValidUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userService.getByUsername(username)
                .map(user -> new org.springframework.security.core.userdetails.User(
                        user.getUsername(),
                        user.getPassword(),
                        List.of(new SimpleGrantedAuthority("user"))
                ))
                .orElseThrow(() -> new UsernameNotFoundException("Failed to retrieve user: " + username));
    }
}
