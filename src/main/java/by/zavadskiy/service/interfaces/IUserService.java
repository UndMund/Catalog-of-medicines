package by.zavadskiy.service.interfaces;

import by.zavadskiy.database.entity.User;

import java.util.Optional;

public interface IUserService {
    User save(User user);

    Optional<User> getByUsername(String username);
}
