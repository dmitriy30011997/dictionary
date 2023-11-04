import java.util.Map;

public class DictionaryService {
    private DictionaryRepisitory dictionaryRepisitory;
    private int activeDictionaryLanguage;

    public DictionaryService(DictionaryRepisitory dictionaryRepisitory) {
        this.dictionaryRepisitory = dictionaryRepisitory;
        this.activeDictionaryLanguage = 1;
    }

    public void setActiveDictionary(DictionaryRepisitory dictionaryRepisitory) {
        this.dictionaryRepisitory = dictionaryRepisitory;
    }

    public int getActiveDictionaryLanguage() {
        return activeDictionaryLanguage;
    }

    public DictionaryRepisitory getDictionary1() {
        DictionaryRepisitory dictionaryRepisitory1 = new DictionaryRepisitory();
        dictionaryRepisitory1.setDictionary1(dictionaryRepisitory.getDictionary1());
        return dictionaryRepisitory1;
    }

    public DictionaryRepisitory getDictionary2() {
        DictionaryRepisitory dictionaryRepisitory2 = new DictionaryRepisitory();
        dictionaryRepisitory2.setDictionary2(dictionaryRepisitory.getDictionary2());
        return dictionaryRepisitory2;
    }

    public void add(String key, String value, int language) {
        activeDictionaryLanguage = language;
        dictionaryRepisitory.addEntry(key, value, language);
    }

    public void delete(String key, int language) {
        activeDictionaryLanguage = language;
        dictionaryRepisitory.deleteEntry(key, language);
    }

    public String find(String key, int language) {
        activeDictionaryLanguage = language;
        return dictionaryRepisitory.findEntry(key, language);
    }

    public String viewDictionaryContents() {
        String dictionary1Contents = "Содержимое словаря 1:\n";
        String dictionary2Contents = "Содержимое словаря 2:\n";

        for (Map.Entry<String, String> entry : dictionaryRepisitory.getDictionary1().entrySet()) {
            dictionary1Contents += entry.getKey() + ": " + entry.getValue() + "\n";
        }

        for (Map.Entry<String, String> entry : dictionaryRepisitory.getDictionary2().entrySet()) {
            dictionary2Contents += entry.getKey() + ": " + entry.getValue() + "\n";
        }

        return dictionary1Contents + "\n" + dictionary2Contents;
    }
}