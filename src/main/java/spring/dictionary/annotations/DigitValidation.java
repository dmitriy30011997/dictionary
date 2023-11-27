package spring.dictionary.annotations;

import spring.dictionary.annotations.validationrules.DigitValidationRule;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DigitValidationRule.class)
public @interface DigitValidation {
    String message() default "Строка должна содержать только цифры";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
