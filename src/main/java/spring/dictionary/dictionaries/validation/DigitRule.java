package spring.dictionary.dictionaries.validation;

import org.springframework.stereotype.Component;

@Component("digitRule")
public class DigitRule implements IRule {
    @Override
    public boolean validate(String input) {
        return input.matches("[0-9]+");
    }
}
