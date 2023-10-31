import java.util.Map;

public class DictionaryService {
    private Dictionary dictionary1;
    private Dictionary dictionary2;
    private Dictionary activeDictionary;

    public DictionaryService(Dictionary dictionary1, Dictionary dictionary2) {
        this.dictionary1 = dictionary1;
        this.dictionary2 = dictionary2;
        this.activeDictionary = dictionary1; // Начально активный словарь
    }

    public void setActiveDictionary(Dictionary dictionary) {
        this.activeDictionary = dictionary;
    }

    public void add(String key, String value, int language) {
        activeDictionary.addEntry(key, value, language);
    }

    public void delete(String key, int language) {
        activeDictionary.deleteEntry(key, language);
    }

    public String find(String key, int language) {
        return activeDictionary.findEntry(key, language);
    }

    public Dictionary getDictionary1() {
        return dictionary1;
    }

    public Dictionary getDictionary2() {
        return dictionary2;
    }

    public String viewDictionaryContents() {
        String dictionary1Contents = "Содержимое словаря 1:\n";
        String dictionary2Contents = "Содержимое словаря 2:\n";

        for (Map.Entry<String, String> entry : dictionary1.getDictionary1().entrySet()) {
            dictionary1Contents += entry.getKey() + ": " + entry.getValue() + "\n";
        }

        for (Map.Entry<String, String> entry : dictionary2.getDictionary2().entrySet()) {
            dictionary2Contents += entry.getKey() + ": " + entry.getValue() + "\n";
        }

        return dictionary1Contents + "\n" + dictionary2Contents;
    }
}
