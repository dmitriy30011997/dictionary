public interface DictionaryRepository {
    void addEntry(String key, String value);

    void deleteEntry(String key);

    String findEntry(String key);

}
