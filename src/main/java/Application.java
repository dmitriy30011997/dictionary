import java.util.Map;

public class Application {
    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary();
        DictionaryFileReader fileReader = new DictionaryFileReader();
        DictionaryFileWriter fileWriter = new DictionaryFileWriter();

        Map<String, String> initialData = fileReader.readFromFile("src/main/dictionary.txt");
        dictionary.setDictionary(initialData);

        DictionaryService dictionaryService = new DictionaryService(dictionary);
        ConsoleMenu consoleMenu = new ConsoleMenu(dictionaryService, fileWriter);

        consoleMenu.run();

        fileWriter.writeToFile(dictionary.getDictionary(), "src/main/dictionary.txt");

        consoleMenu.close();
    }
}
