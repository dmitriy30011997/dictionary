package spring.dictionary.repository;
import spring.dictionary.service.FileService;

import java.util.Map;
public class LatinDictionaryRepositoryImpl implements DictionaryRepository {
    private final Map<String, String> latinDictionary;
    private final FileService latinFileService;


    public LatinDictionaryRepositoryImpl(FileService latinFileService) {
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
