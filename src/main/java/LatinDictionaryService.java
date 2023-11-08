import java.util.Map;

public class LatinDictionaryService implements DictionaryService {
    private final LatinDictionaryRepository dictionaryRepository;

    public LatinDictionaryService(LatinDictionaryRepository dictionaryRepository) {
        this.dictionaryRepository = new LatinDictionaryRepository(dictionaryRepository.getDictionary());
    }

    @Override
    public void add(String key, String value) {
        dictionaryRepository.addEntry(key, value);
    }

    @Override
    public void delete(String key) {
        dictionaryRepository.deleteEntry(key);
    }
    public String viewDictionaryContents() {
        String dictionaryContents = "Содержимое словаря 1 \n";

        for (Map.Entry<String, String> entry : dictionaryRepository.getDictionary().entrySet()) {
            dictionaryContents += entry.getKey() + ": " + entry.getValue() + "\n";
        }
        return dictionaryContents;
    }

    @Override
    public Map<String, String> getDictionary() {
        return dictionaryRepository.getDictionary();
    }
}