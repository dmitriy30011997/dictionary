package spring.dictionary.repository;
import java.util.List;
import java.util.Map;

public interface IDictionaryRepository {
    void addEntry(String key, String value);

    void deleteEntry(String key);

    String findEntry(String key);

    Map<String, String> getDictionary();
}

