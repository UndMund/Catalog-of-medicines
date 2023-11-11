package by.zavadskiy.facade.mappers;

import by.zavadskiy.database.entity.User;
import by.zavadskiy.facade.dto.user.UserDtoCreateRequest;
import by.zavadskiy.facade.dto.user.UserDtoResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public abstract class UserMapper {
    @Autowired
    private PasswordMapper passwordMapper;

    @Mapping(target = "password",
            source = "userDto")
    public abstract User toEntity(UserDtoCreateRequest userDto);

    public abstract UserDtoResponse toDto(User user);

    String mapPassword(UserDtoCreateRequest userDto) {
        return passwordMapper.encodePassword(userDto.getPassword());
    }

}
