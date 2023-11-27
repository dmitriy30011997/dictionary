package spring.dictionary.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import spring.dictionary.ConsoleMenu;
import spring.dictionary.dictionaries.repositories.DigitDictionaryRepositoryImpl;
import spring.dictionary.dictionaries.repositories.IDictionaryRepository;
import spring.dictionary.dictionaries.repositories.LatinDictionaryRepositoryImpl;
import spring.dictionary.dictionaries.serveces.DigitDictionaryServiceImpl;
import spring.dictionary.dictionaries.serveces.IDictionaryService;
import spring.dictionary.dictionaries.serveces.LatinDictionaryServiceImpl;
import spring.dictionary.dictionaries.validation.*;
import spring.dictionary.synonyms.services.ISynonymService;

import java.util.List;

@Configuration
@ComponentScan("spring.dictionary")
public class DictionaryConfig {
    @Bean
    @Primary
    public IDictionaryRepository latinDictionaryRepository(){
        return new LatinDictionaryRepositoryImpl();
    }
    @Bean
    public IDictionaryRepository digitDictionaryRepository(){
        return new DigitDictionaryRepositoryImpl();
    }
    @Bean
    public IDictionaryService latinDictionaryService(ValidationService validationService) {
        return new LatinDictionaryServiceImpl(latinDictionaryRepository(), validationService);
    }

    @Bean
    public IDictionaryService digitDictionaryService(ValidationService validationService) {
        return new DigitDictionaryServiceImpl(digitDictionaryRepository(), validationService);
    }
    @Bean
    public ConsoleMenu consoleMenu(List<IDictionaryService> servicesList, List<ISynonymService> synonymServicesList) {
        return new ConsoleMenu(servicesList, synonymServicesList);
    }
}
