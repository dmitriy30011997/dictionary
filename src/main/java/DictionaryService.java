import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class DictionaryService {
    public boolean addEntryIfValid(Dictionary dictionary, String key, String value, String filePath) {
        if (isValidEntry(key, value)) {
            dictionary.addEntry(key, value);
            writeToFile(dictionary, filePath);
            return true;
        } else {
            return false;
        }
    }

    public boolean isValidEntry(String key, String value) {
        return key.length() <= 10 && value.length() <= 10;
    }

    private void writeToFile(Dictionary dictionary, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Map.Entry<String, String> entry : dictionary.getDictionary().entrySet()) {
                writer.write(entry.getKey() + ": " + entry.getValue());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    public void deleteEntry(Dictionary dictionary, String key) {
            dictionary.deleteEntry(key);

    public String findEntry(Dictionary dictionary, String key) {
                return dictionary.findEntry(key);
            }
//    public static void main(String[] args) {
//        DictionaryFileReader dictionaryFileReader = new DictionaryFileReader();
//        Dictionary dictionary = new Dictionary();
//        EntryDeleter entryDeleter = new EntryDeleter();
//        EntryFinder entryFinder = new EntryFinder();
//        EntryAdder entryAdder = new EntryAdder();
//
//        Map<String, String> initialData = dictionaryFileReader.readFromFile("src/main/dictionary.txt");
//        dictionary.setDictionary(initialData);
//
//        dictionary.addEntry("apple", "яблоко");
//        dictionary.addEntry("book", "книга");
//
//        entryDeleter.deleteEntry(dictionary, "book");
//
//        boolean added1 = entryAdder.addEntryIfValid(dictionary, "apple", "яблоко", "src/main/dictionary.txt");
//        boolean added2 = entryAdder.addEntryIfValid(dictionary, "toolargeword", "оченьдлинноезначение", "src/main/dictionary.txt");
//
//        if (added1) {
//            System.out.println("Запись 'apple' успешно добавлена.");
//        } else {
//            System.out.println("Запись 'apple' не соответствует требованиям.");
//        }
//
//        if (added2) {
//            System.out.println("Запись 'оченьдлиноеслово' успешно добавлена.");
//        } else {
//            System.out.println("Запись 'оченьдлиноеслово' не соответствует требованиям.");
//        }
//
//        String translation = entryFinder.findEntry(dictionary, "apple");
//        if (translation != null) {
//            System.out.println("Перевод слова 'apple': " + translation);
//        } else {
//            System.out.println("Слово 'apple' не найдено в словаре.");
//        }
    }
}
