package spring.dictionary.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import spring.dictionary.service.FileService;

import java.util.Map;
@Repository
public class LatinDictionaryRepositoryImpl implements DictionaryRepository {
    private final Map<String, String> latinDictionary;
    private final FileService latinFileService;


    @Autowired
    public LatinDictionaryRepositoryImpl(@Qualifier("latinFileService") FileService latinFileService) {
        this.latinFileService = latinFileService;
        latinDictionary = latinFileService.readFromFile();
    }

    @Override
    public void addEntry(String key, String value) {
            latinDictionary.put(key, value);
    }
    @Override
    public void saveAll(){
        latinFileService.writeToFile(latinDictionary);
    }

    @Override
    public void deleteEntry(String key) {
        latinDictionary.remove(key);
    }

    @Override
    public String findEntry(String key) {
        return latinDictionary.get(key);
    }

    @Override
    public Map<String, String> getDictionary() {
        return latinDictionary;
    }
}
