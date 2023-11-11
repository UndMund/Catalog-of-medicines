package by.zavadskiy.api.rest.controllers;

import by.zavadskiy.facade.dto.user.UserDtoCreateRequest;
import by.zavadskiy.facade.dto.user.UserDtoResponse;
import by.zavadskiy.facade.interfaces.IUserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static by.zavadskiy.api.rest.utils.UrlPath.API;

@RestController
@RequestMapping(API + "/users")
@RequiredArgsConstructor
public class UserRestController {
    private final IUserFacade userFacade;

    @PostMapping
    public ResponseEntity<UserDtoResponse> registration(
            @Validated @RequestBody UserDtoCreateRequest userDto) {
        return new ResponseEntity<>(
                userFacade.create(userDto),
                HttpStatus.CREATED
        );
    }


}
