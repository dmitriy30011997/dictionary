package spring.dictionary.annotations;

import spring.dictionary.annotations.validationrules.LatinValidationRule;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = LatinValidationRule.class)
public @interface LatinValidation {
    String message() default "Строка должна содержать только латинские символы";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
