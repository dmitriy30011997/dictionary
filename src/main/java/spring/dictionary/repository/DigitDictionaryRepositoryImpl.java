package spring.dictionary.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import spring.dictionary.service.FileService;

import java.util.Map;
@Repository
public class DigitDictionaryRepositoryImpl implements DictionaryRepository {
    private final Map<String, String> digitDictionary;
    private final FileService digitFileService;

    @Autowired
    public DigitDictionaryRepositoryImpl(@Qualifier("digitFileService") FileService digitFileService) {
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
