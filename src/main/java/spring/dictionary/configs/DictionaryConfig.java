package spring.dictionary.configs;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import spring.dictionary.ConsoleMenu;
import spring.dictionary.repository.IDictionaryRepository;
import spring.dictionary.repository.DigitDictionaryRepositoryImpl;
import spring.dictionary.repository.LatinDictionaryRepositoryImpl;
import spring.dictionary.service.IDictionaryService;
import spring.dictionary.service.DigitDictionaryServiceImpl;
import spring.dictionary.service.LatinDictionaryServiceImpl;

import javax.persistence.EntityManager;

@Configuration
@ComponentScan("spring.dictionary")
public class DictionaryConfig implements IConfig {
    @Bean
    @Primary
    public IDictionaryRepository latinDictionaryRepository(EntityManager entityManager){
        return new LatinDictionaryRepositoryImpl(entityManager);
    }
    @Bean
    public IDictionaryRepository digitDictionaryRepository(EntityManager entityManager){
        return new DigitDictionaryRepositoryImpl(entityManager);
    }

    @Bean
    public IDictionaryService latinDictionaryServiceImpl(EntityManager entityManager){
        return new LatinDictionaryServiceImpl(latinDictionaryRepository(entityManager));
    }
    @Bean
    public IDictionaryService digitDictionaryServiceImpl(EntityManager entityManager){
        return new DigitDictionaryServiceImpl(digitDictionaryRepository(entityManager));
    }
    @Bean
    public ConsoleMenu consoleMenu(List<IDictionaryService> servicesList) {
        return new ConsoleMenu(servicesList);
    }
}
