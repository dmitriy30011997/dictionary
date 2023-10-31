import java.util.Map;
import java.io.*;
import java.util.HashMap;

public class Application {
    public static void main(String[] args) {
        FileService fileService = new FileService("src/main/dictionary1.txt", "src/main/dictionary2.txt");

        Map<String, String> initialData1 = fileService.readFromFileForFirstDictionary();
        Map<String, String> initialData2 = fileService.readFromFileForSecondDictionary();

        Dictionary dictionary = new Dictionary();
        dictionary.getDictionary1().putAll(initialData1);
        dictionary.getDictionary2().putAll(initialData2);

        DictionaryService dictionaryService = new DictionaryService(dictionary);
        ConsoleMenu consoleMenu = new ConsoleMenu(dictionaryService, fileService);

        consoleMenu.run();

        fileService.writeToFileForFirstDictionary(dictionary.getDictionary1());
        fileService.writeToFileForSecondDictionary(dictionary.getDictionary2());

        consoleMenu.close();
    }
}