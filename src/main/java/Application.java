import java.util.Map;

public class Application {
    public static void main(String[] args) {
        FileService fileService = new FileService("src/main/latinDictionary.txt");
        FileService fileService1 = new FileService("src/main/digitDictionary.txt");

        DictionaryRepository dictionaryRepository = new DictionaryRepository();

        DictionaryService dictionaryService = new DictionaryService(dictionaryRepository);
        ConsoleMenu consoleMenu = new ConsoleMenu(dictionaryService, fileService);

        consoleMenu.run();

        consoleMenu.close();
    }
}