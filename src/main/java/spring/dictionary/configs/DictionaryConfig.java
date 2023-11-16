package spring.dictionary.configs;

import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.dictionary.ConsoleMenu;
import spring.dictionary.repository.DictionaryRepository;
import spring.dictionary.repository.DigitDictionaryRepositoryImpl;
import spring.dictionary.repository.LatinDictionaryRepositoryImpl;
import spring.dictionary.service.DictionaryService;
import spring.dictionary.service.DigitDictionaryServiceImpl;
import spring.dictionary.service.FileService;
import spring.dictionary.service.LatinDictionaryServiceImpl;

@Configuration
public class DictionaryConfig {
    @Bean
    public FileService digitFileService() {
        return new FileService("src/main/digitDictionary.txt");
    }

    @Bean
    public FileService latinFileService() {
        return new FileService("src/main/latinDictionary.txt");
    }
    @Bean
    public DictionaryRepository latinDictionaryRepository(){
        return new LatinDictionaryRepositoryImpl(latinFileService());
    }
    @Bean
    public DictionaryRepository digitDictionaryRepository(){
        return new DigitDictionaryRepositoryImpl(digitFileService());
    }
    @Bean
    public DictionaryService latinDictionaryServiceImpl(){
        return new LatinDictionaryServiceImpl(latinDictionaryRepository());
    }
    @Bean
    public DictionaryService digitDictionaryServiceImpl(){
        return new DigitDictionaryServiceImpl(digitDictionaryRepository());
    }
    @Bean
    public ConsoleMenu consoleMenu(List<DictionaryService> servicesList) {
        return new ConsoleMenu(servicesList);
    }
}
