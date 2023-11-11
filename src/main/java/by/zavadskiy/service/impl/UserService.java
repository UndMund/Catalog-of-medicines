package by.zavadskiy.service.impl;

import by.zavadskiy.database.entity.User;
import by.zavadskiy.database.repository.UserRepository;
import by.zavadskiy.service.interfaces.IUserService;
import by.zavadskiy.service.interfaces.IUserValidationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService implements IUserService, IUserValidationService {
    private final UserRepository userRepository;

    @Override
    @Transactional
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<User> getByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public boolean isValidUsername(String username) {
        return userRepository.findByUsername(username)
                .isEmpty();
    }
}
