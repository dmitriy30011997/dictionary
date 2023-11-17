package spring.dictionary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class MenuRunner implements ApplicationListener<ContextRefreshedEvent> {

    private final ConsoleMenu consoleMenu;

    @Autowired
    public MenuRunner(ConsoleMenu consoleMenu) {
        this.consoleMenu = consoleMenu;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        consoleMenu.run();
    }
}
