package by.zavadskiy.facade.validation.validators.annotations;

import by.zavadskiy.facade.validation.validators.UsernameValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UsernameValidator.class)
public @interface UsernameUnique {
    String message() default "{user.username.notUnique}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
