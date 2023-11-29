package spring.dictionary.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.dictionary.dictionaries.validation.ValidationResolver;
import spring.dictionary.dictionaries.validation.DigitValidationRule;
import spring.dictionary.dictionaries.validation.LatinValidationRule;

@Configuration
public class ValidationConfig {

    @Bean
    public LatinValidationRule latinValidationRule() {
        return new LatinValidationRule();
    }

    @Bean
    public DigitValidationRule digitValidationRule() {
        return new DigitValidationRule();
    }

    @Bean
    public ValidationResolver validationService(){
        return new ValidationResolver();
    }
}