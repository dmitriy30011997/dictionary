public class DictionaryService {
    private Dictionary dictionary1;
    private Dictionary dictionary2;
    private Dictionary activeDictionary;

    public DictionaryService(Dictionary dictionary1, Dictionary dictionary2) {
        this.dictionary1 = dictionary1;
        this.dictionary2 = dictionary2;
        this.activeDictionary = dictionary1;
    }

    public void setActiveDictionary(Dictionary dictionary) {
        this.activeDictionary = dictionary;
    }

    public Dictionary getDictionary1() {
        return dictionary1;
    }

    public Dictionary getDictionary2() {
        return dictionary2;
    }

    public void add(String key, String value) {
        activeDictionary.addEntry(key, value);
    }

    public void delete(String key) {
        activeDictionary.deleteEntry(key);
    }

    public String find(String key) {
        return activeDictionary.findEntry(key);
    }
}