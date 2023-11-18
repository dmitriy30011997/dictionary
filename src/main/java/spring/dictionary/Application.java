package spring.dictionary;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.dictionary.configs.DictionaryConfig;

public class Application {
    public static void main(String[] args) {

        ApplicationContext context =
                     new AnnotationConfigApplicationContext(DictionaryConfig.class);
    }
}
