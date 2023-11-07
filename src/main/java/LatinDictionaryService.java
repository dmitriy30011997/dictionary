import java.util.Map;

public class LatinDictionaryService implements DictionaryService {
    private DictionaryRepository dictionaryRepository;

    public LatinDictionaryService(DictionaryRepository dictionaryRepository) {
        this.dictionaryRepository = dictionaryRepository;
    }

    @Override
    public void add(String key, String value) {
        dictionaryRepository.addEntry(key, value);
    }

    @Override
    public void delete(String key, int language) {
        dictionaryRepository.deleteEntry(key);
    }

    // может сделать отдельную логику для собирания всех словарей?
    public String viewDictionaryContents() {
        String dictionary1Contents = "Содержимое словаря 1:\n";
        String dictionary2Contents = "Содержимое словаря 2:\n";

        for (Map.Entry<String, String> entry : dictionaryRepository.getDictionary().entrySet()) {
            dictionary1Contents += entry.getKey() + ": " + entry.getValue() + "\n";
        }
        return dictionary1Contents + "\n" + dictionary2Contents;
    }
}