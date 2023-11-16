package spring.dictionary;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.dictionary.configs.DictionaryConfig;

public class Application {
    public static void main(String[] args) {

        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DictionaryConfig.class)) {
            ConsoleMenu consoleMenu = context.getBean(ConsoleMenu.class);
            consoleMenu.run();
            consoleMenu.close();
        }
    }
}
