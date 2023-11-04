import java.util.Map;

public class DictionaryService {
    private DictionaryRepository dictionaryRepository;
    private int activeDictionaryLanguage;

    public DictionaryService(DictionaryRepository dictionaryRepository) {
        this.dictionaryRepository = dictionaryRepository;
        this.activeDictionaryLanguage = 1;
    }

    public void setActiveDictionary(DictionaryRepository dictionaryRepository) {
        this.dictionaryRepository = dictionaryRepository;
    }

    public int getActiveDictionaryLanguage() {
        return activeDictionaryLanguage;
    }

    public DictionaryRepository getDictionary1() {
        DictionaryRepository dictionaryRepository1 = new DictionaryRepository();
        dictionaryRepository1.setDictionary1(dictionaryRepository.getDictionary1());
        return dictionaryRepository1;
    }

    public DictionaryRepository getDictionary2() {
        DictionaryRepository dictionaryRepository2 = new DictionaryRepository();
        dictionaryRepository2.setDictionary2(dictionaryRepository.getDictionary2());
        return dictionaryRepository2;
    }

    public void add(String key, String value, int language) {
        activeDictionaryLanguage = language;
        dictionaryRepository.addEntry(key, value, language);
    }

    public void delete(String key, int language) {
        activeDictionaryLanguage = language;
        dictionaryRepository.deleteEntry(key, language);
    }

    public String find(String key, int language) {
        activeDictionaryLanguage = language;
        return dictionaryRepository.findEntry(key, language);
    }

    public String viewDictionaryContents() {
        String dictionary1Contents = "Содержимое словаря 1:\n";
        String dictionary2Contents = "Содержимое словаря 2:\n";

        for (Map.Entry<String, String> entry : dictionaryRepository.getDictionary1().entrySet()) {
            dictionary1Contents += entry.getKey() + ": " + entry.getValue() + "\n";
        }

        for (Map.Entry<String, String> entry : dictionaryRepository.getDictionary2().entrySet()) {
            dictionary2Contents += entry.getKey() + ": " + entry.getValue() + "\n";
        }

        return dictionary1Contents + "\n" + dictionary2Contents;
    }
}