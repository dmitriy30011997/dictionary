import java.util.Map;
public class DigitDictionaryService implements DictionaryService {
    private DictionaryRepository dictionaryRepository;

    public DigitDictionaryService(DictionaryRepository dictionaryRepository) {
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

    public String viewDictionaryContents() {
        String dictionaryContents = "Содержимое словаря: ";

        for (Map.Entry<String, String> entry : dictionaryRepository.getDictionary().entrySet()) {
            dictionaryContents += entry.getKey() + ": " + entry.getValue() + "\n";
        }
        return dictionaryContents;
    }
}