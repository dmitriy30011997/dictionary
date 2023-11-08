import java.util.Map;
public class DigitDictionaryService implements DictionaryService {
    private final DigitDictionaryRepository dictionaryRepository;

    public DigitDictionaryService() {
        this.dictionaryRepository = new DigitDictionaryRepository();
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
        StringBuilder dictionaryContents = new StringBuilder("Содержимое словаря 2 \n");

        for (Map.Entry<String, String> entry : dictionaryRepository.getDictionary().entrySet()) {
            dictionaryContents.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
        }
        return dictionaryContents.toString();
    }
    @Override
    public Map<String, String> getDictionary() {
        return dictionaryRepository.getDictionary();
    }

    @Override
    public void save() {
        dictionaryRepository.save();
    }
}