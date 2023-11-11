package by.zavadskiy.facade.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public abstract class BaseException extends RuntimeException {
    ApiError apiError;
    HttpStatus httpStatus;

    public BaseException(ApiError apiError, HttpStatus httpStatus) {
        super(apiError.getDescription());
        this.apiError = apiError;
        this.httpStatus = httpStatus;
    }
}
