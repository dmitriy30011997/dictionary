package spring.dictionary.annotations.validationrules;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import spring.dictionary.annotations.LatinValidation;

public class LatinValidationRule implements ConstraintValidator<LatinValidation, String> {

    @Override
    public void initialize(LatinValidation constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value.matches("[a-zA-Z]+");
    }
}
