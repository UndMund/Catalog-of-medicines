package by.zavadskiy.facade.interfaces;

import by.zavadskiy.facade.dto.user.UserDtoCreateRequest;
import by.zavadskiy.facade.dto.user.UserDtoResponse;

public interface IUserFacade {
    UserDtoResponse create(UserDtoCreateRequest userDtoCreateRequest);
}
