package spring.dictionary.dictionaries.validation;

import org.springframework.stereotype.Component;

@Component
@DigitValidation
public class DigitRule implements IRule {
    @Override
    public boolean validate(String input) {
        return input.matches("[0-9]+");
    }
}
