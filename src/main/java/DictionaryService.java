import java.util.Map;

public class DictionaryService {
    private Dictionary dictionary;
    private int activeDictionaryLanguage;

    public DictionaryService(Dictionary dictionary) {
        this.dictionary = dictionary;
        this.activeDictionaryLanguage = 1;
    }

    public void setActiveDictionary(Dictionary dictionary) {
        this.dictionary = dictionary;
    }

    public int getActiveDictionaryLanguage() {
        return activeDictionaryLanguage;
    }

    public Dictionary getDictionary1() {
        Dictionary dictionary1 = new Dictionary();
        dictionary1.setDictionary1(dictionary.getDictionary1());
        return dictionary1;
    }

    public Dictionary getDictionary2() {
        Dictionary dictionary2 = new Dictionary();
        dictionary2.setDictionary2(dictionary.getDictionary2());
        return dictionary2;
    }

    public void add(String key, String value, int language) {
        activeDictionaryLanguage = language;
        dictionary.addEntry(key, value, language);
    }

    public void delete(String key, int language) {
        activeDictionaryLanguage = language;
        dictionary.deleteEntry(key, language);
    }

    public String find(String key, int language) {
        activeDictionaryLanguage = language;
        return dictionary.findEntry(key, language);
    }

    public String viewDictionaryContents() {
        String dictionary1Contents = "Содержимое словаря 1:\n";
        String dictionary2Contents = "Содержимое словаря 2:\n";

        for (Map.Entry<String, String> entry : dictionary.getDictionary1().entrySet()) {
            dictionary1Contents += entry.getKey() + ": " + entry.getValue() + "\n";
        }

        for (Map.Entry<String, String> entry : dictionary.getDictionary2().entrySet()) {
            dictionary2Contents += entry.getKey() + ": " + entry.getValue() + "\n";
        }

        return dictionary1Contents + "\n" + dictionary2Contents;
    }
}