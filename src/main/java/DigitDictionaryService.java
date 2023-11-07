import java.util.Map;
public class DigitDictionaryService implements DictionaryService {
    private DigitDictionaryRepository dictionaryRepository;

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
        String dictionaryContents = "Содержимое словаря: ";

        for (Map.Entry<String, String> entry : dictionaryRepository.getDictionary().entrySet()) {
            dictionaryContents += entry.getKey() + ": " + entry.getValue() + "\n";
        }
        return dictionaryContents;

    }
}