package spring.dictionary.dictionaries.validation;

import java.util.List;

public class LatinValidator implements IValidator {
    private final List<IRule> rules;

    public LatinValidator(@LatinValidation List<IRule> rules) {
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