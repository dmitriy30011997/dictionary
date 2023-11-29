package spring.dictionary.dictionaries.validation;

import java.util.HashMap;
import java.util.Map;


public class ValidationResolver {
    private final Map<String, IValidationRule> validationRules;

    public ValidationResolver() {
        this.validationRules = new HashMap<>();
        initializeRules();
    }

    private void initializeRules() {
        validationRules.put("latin", new LatinValidationRule());
        validationRules.put("digit", new DigitValidationRule());
    }

    public IValidationRule getRule(String dictionaryType) {
        return validationRules.get(dictionaryType);
    }
}