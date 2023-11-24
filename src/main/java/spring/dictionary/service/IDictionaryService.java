package spring.dictionary.service;

public interface IDictionaryService {
    void add(String key, String value);
    void delete(String key);
    String viewDictionaryContents();
    String findEntry(String key);
    int getType();
}
