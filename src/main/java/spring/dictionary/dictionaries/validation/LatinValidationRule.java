package spring.dictionary.dictionaries.validation;

import org.springframework.stereotype.Component;

@Component
public class LatinValidationRule implements IValidationRule {
    @Override
    public boolean validate(String input) {
        return input.matches("[a-zA-Z]+");
    }
}
