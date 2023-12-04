package spring.dictionary.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.dictionary.dictionaries.validation.*;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class ValidatorConfig {

    @Bean
    public IValidator latinValidator(List<IRule> latinRules) {
        return new LatinValidator(latinRules);
    }

    @Bean
    public IValidator digitValidator(List<IRule> digitRules) {
        return new DigitValidator(digitRules);
    }

    @Bean
    public List<IRule> latinRules() {
        List<IRule> rules = new ArrayList<>();
        rules.add(new LatinRule());
        return rules;
    }

    @Bean
    public List<IRule> digitRules() {
        List<IRule> rules = new ArrayList<>();
        rules.add(new DigitRule());
        return rules;
    }
}

