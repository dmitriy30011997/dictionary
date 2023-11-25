package spring.dictionary.service;

import java.util.List;

public interface IDictionaryService {
    void add(String key, String value);
    void delete(String key);
    String viewDictionaryContents();
    String findEntry(String key);
    int getType();
    void addSynonym(String word, String synonym);
    List<String> getSynonyms(String word);
}
