package spring.dictionary.repository;
import spring.dictionary.service.FileService;

import java.util.Map;
public class DigitDictionaryRepositoryImpl implements IDictionaryRepository {
    private final Map<String, String> digitDictionary;
    private final FileService digitFileService;

    public DigitDictionaryRepositoryImpl(FileService digitFileService) {
        this.digitFileService = digitFileService;
        this.digitDictionary = digitFileService.readFromFile();
    }
    @Override
    public void addEntry(String key, String value) {
        digitDictionary.put(key, value);
    }

    @Override
    public void deleteEntry(String key) {
        digitDictionary.remove(key);
    }

    @Override
    public String findEntry(String key) {
        return digitDictionary.get(key);
    }

    @Override
    public Map<String, String> getDictionary() {
        return digitDictionary;
    }

    @Override
    public void saveAll() {
        digitFileService.writeToFile(digitDictionary);
    }
}
