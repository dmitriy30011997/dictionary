package spring.dictionary.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import spring.dictionary.ConsoleMenu;
import spring.dictionary.dictionaries.services.IDictionaryService;
import spring.dictionary.synonyms.repositories.DigitSynonymRepositoryImpl;
import spring.dictionary.synonyms.repositories.ISynonymRepository;
import spring.dictionary.synonyms.repositories.LatinSynonymRepositoryImpl;
import spring.dictionary.synonyms.services.DigitSynonymService;
import spring.dictionary.synonyms.services.ISynonymService;
import spring.dictionary.synonyms.services.LatinSynonymService;

import java.util.List;

@Configuration
@ComponentScan("spring.dictionary")
public class SynonymConfig {
    @Bean
    @Primary
    public ISynonymRepository latinSynonymRepository(){
        return new LatinSynonymRepositoryImpl();
    }
    @Bean
    public ISynonymRepository digitSynonymRepository(){
        return new DigitSynonymRepositoryImpl();
    }
    @Bean
    public ISynonymService latinSynonymService() {
        return new LatinSynonymService(latinSynonymRepository());
    }

    @Bean
    public ISynonymService digitSynonymService() {
        return new DigitSynonymService(digitSynonymRepository());
    }
    @Bean
    public ConsoleMenu consoleMenu(List<IDictionaryService> servicesList, List<ISynonymService> synonymServicesList) {
        return new ConsoleMenu(servicesList, synonymServicesList);
    }
}
