import java.util.Map;
public class DigitDictionaryService implements DictionaryService {
    private final DigitDictionaryRepository dictionaryRepository;

    public DigitDictionaryService(DigitDictionaryRepository dictionaryRepository) {
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

    public String viewDictionaryContents() {
        String dictionaryContents = "Содержимое словаря 2 ";

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