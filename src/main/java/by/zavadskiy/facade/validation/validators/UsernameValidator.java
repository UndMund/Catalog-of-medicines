package by.zavadskiy.facade.validation.validators;

import by.zavadskiy.facade.interfaces.IUserValidationFacade;
import by.zavadskiy.facade.validation.validators.annotations.UsernameUnique;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class UsernameValidator
        implements ConstraintValidator<UsernameUnique, String> {
    @Autowired
    private IUserValidationFacade userValidationFacade;

    @Override
    public boolean isValid(String s,
                           ConstraintValidatorContext constraintValidatorContext) {
        return userValidationFacade.isValidUsername(s);
    }
}
