package spring.dictionary.dictionaries.validation;

import org.springframework.stereotype.Component;

import java.util.List;

@Component("digitValidator")
public class DigitValidator implements IValidator {
    private final List<IRule> rules;

    public DigitValidator(List<IRule> rules) {
        this.rules = rules;
    }

    @Override
    public boolean validate(String input) {
        for (IRule rule : rules) {
            if (!rule.validate(input)) {
                return false;
            }
        }
        return true;
    }
}