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
    public void delete(String key) {
        dictionaryRepository.deleteEntry(key);
    }

    // может сделать отдельную логику для собирания всех словарей?
    public String viewDictionaryContents() {
        String dictionaryContents = "Содержимое словаря \n";

        for (Map.Entry<String, String> entry : dictionaryRepository.getDictionary().entrySet()) {
            dictionaryContents += entry.getKey() + ": " + entry.getValue() + "\n";
        }
        return dictionaryContents;
    }
}