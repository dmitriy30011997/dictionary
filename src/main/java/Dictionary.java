import java.util.HashMap;
import java.util.Map;


public class Dictionary {
    private Map<String, String> dictionary;

    public Dictionary(Map<String, String> initialData) {
        this.dictionary = new HashMap<>(initialData);
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

    public Map<String, String> getDictionary() {
        return dictionary;
    }
}