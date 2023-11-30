package spring.dictionary.dictionaries.validation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ValidationResolver {
    private final Map<String, List<IValidationRule>> validationRules;

    public ValidationResolver() {
        this.validationRules = new HashMap<>();
        initializeRules();
    }

    private void initializeRules() {
        List<IValidationRule> latinRules = new ArrayList<>();
        latinRules.add(new LatinCharactersValidationRule());

        List<IValidationRule> digitRules = new ArrayList<>();
        digitRules.add(new OnlyDigitsValidationRule());

        validationRules.put("latin", latinRules);
        validationRules.put("digit", digitRules);
    }

    public List<IValidationRule> getRulesForDictionary(String dictionaryType) {
        return validationRules.getOrDefault(dictionaryType, new ArrayList<>());
    }
}
