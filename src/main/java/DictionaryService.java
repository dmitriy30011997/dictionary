import java.util.Map;

public class DictionaryService {
    public static void main(String[] args) {
        DictionaryFileReader dictionaryFileReader = new DictionaryFileReader();
        Dictionary dictionary = new Dictionary();
        EntryDeleter entryDeleter = new EntryDeleter();
        EntryFinder entryFinder = new EntryFinder();
        EntryAdder entryAdder = new EntryAdder();

        Map<String, String> initialData = dictionaryFileReader.readFromFile("src/main/dictionary.txt");
        dictionary.setDictionary(initialData);

        dictionary.addEntry("apple", "яблоко");
        dictionary.addEntry("book", "книга");

        entryDeleter.deleteEntry(dictionary, "book");

        boolean added1 = entryAdder.addEntryIfValid(dictionary, "apple", "яблоко", "src/main/dictionary.txt");
        boolean added2 = entryAdder.addEntryIfValid(dictionary, "toolargeword", "оченьдлинноезначение", "src/main/dictionary.txt");

        if (added1) {
            System.out.println("Запись 'apple' успешно добавлена.");
        } else {
            System.out.println("Запись 'apple' не соответствует требованиям.");
        }

        if (added2) {
            System.out.println("Запись 'оченьдлиноеслово' успешно добавлена.");
        } else {
            System.out.println("Запись 'оченьдлиноеслово' не соответствует требованиям.");
        }

        String translation = entryFinder.findEntry(dictionary, "apple");
        if (translation != null) {
            System.out.println("Перевод слова 'apple': " + translation);
        } else {
            System.out.println("Слово 'apple' не найдено в словаре.");
        }
    }
}
