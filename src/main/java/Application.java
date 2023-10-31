import java.util.Map;

public class Application {
    public static void main(String[] args) {
        FileService fileService = new FileService();

        Map<String, String> initialData = fileService.readFromFile();
        Dictionary dictionary = new Dictionary(initialData);

        DictionaryService dictionaryService = new DictionaryService(dictionary);
        ConsoleMenu consoleMenu = new ConsoleMenu(dictionaryService, fileService);

        consoleMenu.run();

        fileService.writeToFile(dictionary.getDictionary(), "src/main/dictionary.txt");

        consoleMenu.close();
    }
}
