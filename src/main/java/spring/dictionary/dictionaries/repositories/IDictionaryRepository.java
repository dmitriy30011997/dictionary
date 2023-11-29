package spring.dictionary.dictionaries.repositories;
import java.util.List;

public interface IDictionaryRepository {
    void addEntry(String key, String value);

    void deleteEntry(String key);

    String findEntry(String key);

    List<Object[]> getDictionary();
}

