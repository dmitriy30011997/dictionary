import java.util.HashMap;
import java.util.Map;

public class Dictionary {
    private Map<String, String> dictionary;

    public Dictionary() {
        this.dictionary = new HashMap<>();
    }

    public void addEntry(String key, String value) {
        dictionary.put(key, value);
    }

    public void deleteEntry(String key) {
        dictionary.remove(key);
    }

    public String findEntry(String key) {
        return dictionary.get(key);
    }

    public void setDictionary(Map<String, String> dictionary) {
        this.dictionary = dictionary;
    }

    public Map<String, String> getDictionary() {
        return dictionary;

    }
}