import java.util.Map;

public class DigitDictionaryRepository implements DictionaryRepository {
    private Map<String, String> digitDictionary;
    private FileService fileService;
    private FileService digitFileService;

    DigitDictionaryRepository(Map<String, String> stringStringMap){
        Map<String, String> initialData = fileService.
                readFromFile("src/main/latinDictionary.txt");

        DigitDictionaryRepository dictionaryRepository = new DigitDictionaryRepository(digitFileService.readFromFile("src/main/digitDictionary.txt"));
        digitDictionary.putAll(initialData);
    }
    @Override
    public void addEntry(String key, String value) {
        if (key.matches("^\\d{5}$") && value.matches("^\\d{5}$")) {
            digitDictionary.put(key, value);
        } else {
            System.out.println("Неверный формат слова для второго словаря.");
        }
    }

    @Override
    public void deleteEntry(String key) {
        digitDictionary.remove(key);
    }

    @Override
    public String findEntry(String key) {
        return digitDictionary.get(key);
    }

    @Override
    public Map<String, String> getDictionary() {
        return digitDictionary;
    }
}
