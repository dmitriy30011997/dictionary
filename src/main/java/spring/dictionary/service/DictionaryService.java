package spring.dictionary.service;

public interface DictionaryService {
    void add(String key, String value);
    void delete(String key);
    String viewDictionaryContents();
    String findEntry(String key);
    void saveDictionary();
    public int getType();
}
