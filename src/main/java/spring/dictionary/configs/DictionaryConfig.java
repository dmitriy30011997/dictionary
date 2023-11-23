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

@Configuration
@ComponentScan("spring.dictionary")
public class DictionaryConfig implements IConfig {
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
    public IDictionaryService latinDictionaryServiceImpl(){
        return new LatinDictionaryServiceImpl(latinDictionaryRepository());
    }
    @Bean
    public IDictionaryService digitDictionaryServiceImpl(){
        return new DigitDictionaryServiceImpl(digitDictionaryRepository());
    }
    @Bean
    public ConsoleMenu consoleMenu(List<IDictionaryService> servicesList) {
        return new ConsoleMenu(servicesList);
    }
}
