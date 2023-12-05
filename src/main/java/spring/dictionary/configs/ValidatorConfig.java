package spring.dictionary.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.dictionary.dictionaries.validation.*;

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
    public IRule latinRule() {
        return new LatinRule();
    }

    @Bean
    @DigitValidation
    public IRule digitRule() {
        return new DigitRule();
    }
}

