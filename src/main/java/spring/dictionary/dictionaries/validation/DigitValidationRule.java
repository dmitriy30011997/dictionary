package spring.dictionary.dictionaries.validation;

import org.springframework.stereotype.Component;

@Component
public class DigitValidationRule implements IValidationRule {
    @Override
    public boolean validate(String input) {
        return input.matches("^\\d+$");
    }
}