package spring.dictionary.configs;

import java.util.List;

import org.hibernate.SessionFactory;
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

@Configuration
@ComponentScan("spring.dictionary")
public class DictionaryConfig implements IConfig {
    @Bean
    @Primary
    public IDictionaryRepository latinDictionaryRepository(SessionFactory sessionFactory){
        return new LatinDictionaryRepositoryImpl(sessionFactory);
    }
    @Bean
    public IDictionaryRepository digitDictionaryRepository(SessionFactory sessionFactory){
        return new DigitDictionaryRepositoryImpl(sessionFactory);
    }
    @Bean
    public IDictionaryService latinDictionaryServiceImpl(SessionFactory sessionFactory){
        return new LatinDictionaryServiceImpl(latinDictionaryRepository(sessionFactory));
    }
    @Bean
    public IDictionaryService digitDictionaryServiceImpl(SessionFactory sessionFactory){
        return new DigitDictionaryServiceImpl(digitDictionaryRepository(sessionFactory));
    }
    @Bean
    public ConsoleMenu consoleMenu(List<IDictionaryService> servicesList) {
        return new ConsoleMenu(servicesList);
    }
}
