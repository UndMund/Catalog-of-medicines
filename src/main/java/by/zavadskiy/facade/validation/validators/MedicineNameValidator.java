package by.zavadskiy.facade.validation.validators;

import by.zavadskiy.facade.interfaces.IMedicineValidationFacade;
import by.zavadskiy.facade.validation.validators.annotations.MedicineNameUnique;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class MedicineNameValidator
        implements ConstraintValidator<MedicineNameUnique, String> {
    @Autowired
    private IMedicineValidationFacade medicineValidationFacade;

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return medicineValidationFacade.isValidName(s);
    }
}
