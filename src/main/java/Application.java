import java.util.Map;

public class Application {
    public static void main(String[] args) {
        FileService fileService = new FileService("src/main/dictionary1.txt", "src/main/dictionary2.txt");

        Map<String, String> initialData1 = fileService.readFromFileForFirstDictionary();
        Map<String, String> initialData2 = fileService.readFromFileForSecondDictionary();

        DictionaryRepository dictionaryRepository = new DictionaryRepository();
        dictionaryRepository.getDictionary1().putAll(initialData1);
        dictionaryRepository.getDictionary2().putAll(initialData2);

        DictionaryService dictionaryService = new DictionaryService(dictionaryRepository);
        ConsoleMenu consoleMenu = new ConsoleMenu(dictionaryService, fileService);

        consoleMenu.run();

        consoleMenu.close();
    }
}