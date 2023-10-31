import java.util.Map;

public class Application {
    public static void main(String[] args) {
        FileService fileService = new FileService("src/main/dictionary1.txt", "src/main/dictionary2.txt");

        Map<String, String> initialData1 = fileService.readFromFileForDictionary1();
        Map<String, String> initialData2 = fileService.readFromFileForDictionary2();

        Dictionary dictionary1 = new Dictionary(initialData1);
        Dictionary dictionary2 = new Dictionary(initialData2);

        DictionaryService dictionaryService = new DictionaryService(dictionary1, dictionary2);
        ConsoleMenu consoleMenu = new ConsoleMenu(dictionaryService, fileService);

        consoleMenu.run();

        fileService.writeToFileForDictionary1(dictionary1.getDictionary());
        fileService.writeToFileForDictionary2(dictionary2.getDictionary());

        consoleMenu.close();
    }
}
