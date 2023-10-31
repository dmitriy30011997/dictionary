import java.util.Map;

public class Application {
    public static void main(String[] args) {
        FileService fileService = new FileService("src/main/dictionary1.txt", "src/main/dictionary2.txt");

        Dictionary dictionary1 = new Dictionary();
        Dictionary dictionary2 = new Dictionary();

        DictionaryService dictionaryService = new DictionaryService(dictionary1, dictionary2);
        ConsoleMenu consoleMenu = new ConsoleMenu(dictionaryService, fileService);

        consoleMenu.run();

        fileService.writeToFileForDictionary1(dictionary1.getDictionary1());
        fileService.writeToFileForDictionary2(dictionary2.getDictionary2());

        consoleMenu.close();
    }
}
