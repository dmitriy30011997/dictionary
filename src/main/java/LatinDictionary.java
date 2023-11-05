import java.util.Map;

public class LatinDictionary implements IDictionary{

    private Map<String, String> latinDictionary;
    private FileService fileService;

    //конструктор с инициализацией словарей
    LatinDictionary(){
        Map<String, String> initialData = fileService.
                readFromFileForDictionary("src/main/latinDictionary.txt");
        DictionaryRepository dictionaryRepository = new DictionaryRepository();
        dictionaryRepository.getDictionary().putAll(initialData);
    }
    @Override
    public void addEntry(String key, String value) {
        if (key.matches("^[a-zA-Z]{4}$") && value.matches("^[a-zA-Z]{4}$")) {
            latinDictionary.put(key, value);
        } else {
            System.out.println("Неверный формат слова для первого словаря.");
        }
    }

    @Override
    public void deleteEntry(String key) {
        latinDictionary.remove(key);
    }

    @Override
    public String findEntry(String key) {
        return null;
    }
}
