package spring.dictionary.repository;

import spring.dictionary.entities.LatinEntity;

import java.util.List;

public interface IDictionaryRepository {
    void addEntry(String key, String value);

    void deleteEntry(String key);

    String findEntry(String key);

    List<LatinEntity> getDictionary();

    void saveAll();
}

