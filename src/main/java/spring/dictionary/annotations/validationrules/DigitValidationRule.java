package spring.dictionary.annotations.validationrules;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import spring.dictionary.annotations.DigitValidation;

public class DigitValidationRule implements ConstraintValidator<DigitValidation, String> {

    @Override
    public void initialize(DigitValidation constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value.matches("\\d+");
    }
}
