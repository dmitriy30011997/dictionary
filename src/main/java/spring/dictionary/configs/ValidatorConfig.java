package spring.dictionary.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.dictionary.dictionaries.validation.DigitRule;
import spring.dictionary.dictionaries.validation.DigitValidation;
import spring.dictionary.dictionaries.validation.DigitValidator;
import spring.dictionary.dictionaries.validation.IRule;
import spring.dictionary.dictionaries.validation.IValidator;
import spring.dictionary.dictionaries.validation.LatinRule;
import spring.dictionary.dictionaries.validation.LatinValidation;
import spring.dictionary.dictionaries.validation.LatinValidator;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class ValidatorConfig {

    @Bean
    public IValidator latinValidator(@LatinValidation List<IRule> latinRules) {
        return new LatinValidator(latinRules);
    }

    @Bean
    public IValidator digitValidator(@DigitValidation List<IRule> digitRules) {
        return new DigitValidator(digitRules);
    }

    @Bean
    @LatinValidation
    public List<IRule> latinRules() {
        List<IRule> rules = new ArrayList<>();
        rules.add(new LatinRule());
        return rules;
    }

    @Bean
    @DigitValidation
    public List<IRule> digitRules() {
        List<IRule> rules = new ArrayList<>();
        rules.add(new DigitRule());
        return rules;
    }
}

