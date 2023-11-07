import java.util.Map;

public class DigitDictionary implements IDictionary{
    private Map<String, String> digitDictionary;
    private FileService fileService;

    DigitDictionary(){
        Map<String, String> initialData = fileService.
                readFromFileForDictionary("src/main/latinDictionary.txt");
        DictionaryRepository dictionaryRepository = new DictionaryRepository(initialData);
        dictionaryRepository.getDictionary().putAll(initialData);
    }
    //конструктор с инициализацией словарей
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
}
