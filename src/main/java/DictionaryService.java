import java.util.Map;

public interface DictionaryService {
    void add(String key, String value);
    void delete(String key);
    String viewDictionaryContents();
    Map<String, String> getDictionary();
    void save();
}
