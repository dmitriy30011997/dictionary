import java.util.Map;

public class LatinDictionaryService<Service> {
    private DictionaryRepository dictionaryRepository;
    public DictionaryService(DictionaryRepository dictionaryRepository) {
        this.dictionaryRepository = dictionaryRepository;
    }

    public DictionaryRepository getDictionary1() {
        DictionaryRepository dictionaryRepository1 = new DictionaryRepository();
        dictionaryRepository1.setDictionary1(dictionaryRepository.getDictionary1());
        return dictionaryRepository1;
    }


    public void add(String key, String value, int language) {
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