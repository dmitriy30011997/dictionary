package spring.dictionary.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import spring.dictionary.ConsoleMenu;
import spring.dictionary.converters.ListToStringBuilderConverter;
import spring.dictionary.dictionaries.repositories.DigitDictionaryRepositoryImpl;
import spring.dictionary.dictionaries.repositories.IDictionaryRepository;
import spring.dictionary.dictionaries.repositories.LatinDictionaryRepositoryImpl;
import spring.dictionary.dictionaries.services.DigitDictionaryServiceImpl;
import spring.dictionary.dictionaries.services.IDictionaryService;
import spring.dictionary.dictionaries.services.LatinDictionaryServiceImpl;
import spring.dictionary.dictionaries.validation.IValidator;
import spring.dictionary.synonyms.services.ISynonymService;

import java.util.List;

@Configuration
@ComponentScan("spring.dictionary")
@EnableTransactionManagement
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
    public IDictionaryService latinDictionaryService(IValidator latinValidator) {
        IDictionaryService iDictionaryService = new LatinDictionaryServiceImpl(latinDictionaryRepository(), latinValidator);
        iDictionaryService.setConverter(converter());
        return iDictionaryService;
    }

    @Bean
    public ListToStringBuilderConverter converter(){
        return new ListToStringBuilderConverter();
    }

    @Bean
    public IDictionaryService digitDictionaryService(IValidator digitValidator) {
        IDictionaryService iDictionaryService = new DigitDictionaryServiceImpl(digitDictionaryRepository(), digitValidator);
        iDictionaryService.setConverter(converter());
        return iDictionaryService;
    }
    @Bean
    public ConsoleMenu consoleMenu(List<IDictionaryService> servicesList, List<ISynonymService> synonymServicesList) {
        return new ConsoleMenu(servicesList, synonymServicesList);
    }
}
