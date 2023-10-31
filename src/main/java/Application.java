import java.util.Map;

public class Application {
    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary();
        FileService fileService = new FileService();

        Map<String, String> initialData = fileService.readFromFile();
        dictionary.setDictionary(initialData);

        DictionaryService dictionaryService = new DictionaryService(dictionary);
        ConsoleMenu consoleMenu = new ConsoleMenu(dictionaryService, fileService);

        consoleMenu.run();

        fileService.writeToFile(dictionary.getDictionary(), "src/main/dictionary.txt");

        consoleMenu.close();
    }
}
