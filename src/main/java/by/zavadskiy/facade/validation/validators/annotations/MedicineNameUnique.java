package by.zavadskiy.facade.validation.validators.annotations;

import by.zavadskiy.facade.validation.validators.MedicineNameValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = MedicineNameValidator.class)
public @interface MedicineNameUnique {
    String message() default "{medicine.name.notUnique}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
