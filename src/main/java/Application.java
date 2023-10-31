import java.util.Map;

public class Application {
    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary();
        DictionaryFileReader fileReader = new DictionaryFileReader();

        // Загрузка данных из файла при запуске
        Map<String, String> initialData = fileReader.readFromFile("src/main/dictionary.txt");
        dictionary.setDictionary(initialData);

        DictionaryService dictionaryService = new DictionaryService(dictionary);
        ConsoleMenu consoleMenu = new ConsoleMenu(dictionaryService, fileReader);

        consoleMenu.run();

        // Сохранение данных в файл перед завершением
        fileReader.writeToFile(dictionary.getDictionary(), "src/main/dictionary.txt");

        consoleMenu.close();
    }
}