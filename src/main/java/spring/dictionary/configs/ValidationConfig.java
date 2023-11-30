package spring.dictionary.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.dictionary.dictionaries.validation.ValidationResolver;

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