package spring.dictionary.dictionaries.validation;

import java.util.List;

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