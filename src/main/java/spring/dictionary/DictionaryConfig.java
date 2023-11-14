package spring.dictionary;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import spring.dictionary.service.FileService;

@Configuration
@ComponentScan("spring/dictionary")
public class DictionaryConfig {
    @Bean(name = "digitFileService")
    public FileService digitFileService() {
        return new FileService("src/main/digitDictionary.txt");
    }

    @Bean(name = "latinFileService")
    public FileService latinFileService() {
        return new FileService("src/main/latinDictionary.txt");
    }
}
