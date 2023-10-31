public class DictionaryService {
    private Dictionary dictionary;

    public DictionaryService(Dictionary dictionary) {
        this.dictionary = dictionary;
    }

    public void add(String key, String value) {
        dictionary.addEntry(key, value);
    }

    public void delete(String key) {
        dictionary.deleteEntry(key);
    }

    public String find(String key) {
        return dictionary.findEntry(key);
    }
}
