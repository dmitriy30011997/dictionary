package spring.dictionary.dictionaries.repositories;
import java.util.List;
import java.util.Optional;

public interface IDictionaryRepository<T> {
    void addEntry(String key, String value);

    void deleteEntry(String key);

    Optional<String> findEntry(String key);

    List<T> getDictionary();
}

