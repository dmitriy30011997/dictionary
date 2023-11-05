import java.util.Map;

public class Application {
    public static void main(String[] args) {
        FileService fileService = new FileService("src/main/dictionary1.txt");
        FileService fileService1 = new FileService("src/main/dictionary2.txt");


        Map<String, String> initialData1 = fileService.readFromFileForDictionary("src/main/dictionary1.txt");
        Map<String, String> initialData2 = fileService.readFromFileForDictionary("src/main/dictionary2.txt");

        DictionaryRepository dictionaryRepository = new DictionaryRepository();
        dictionaryRepository.getDictionary1().putAll(initialData1);
        dictionaryRepository.getDictionary2().putAll(initialData2);

        DictionaryService dictionaryService = new DictionaryService(dictionaryRepository);
        ConsoleMenu consoleMenu = new ConsoleMenu(dictionaryService, fileService);

        consoleMenu.run();

        consoleMenu.close();
    }
}