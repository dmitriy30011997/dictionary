package service;

import repository.LatinDictionaryRepository;

import java.util.Map;

public class LatinDictionaryService implements DictionaryService {
    private final LatinDictionaryRepository dictionaryRepository;

    public LatinDictionaryService() {
        this.dictionaryRepository = new LatinDictionaryRepository();
    }

    @Override
    public void add(String key, String value) {
        dictionaryRepository.addEntry(key, value);
    }

    @Override
    public void delete(String key) {
        dictionaryRepository.deleteEntry(key);
    }
    public String viewDictionaryContents() {
        StringBuilder dictionaryContents = new StringBuilder("Содержимое словаря 1 \n");

        for (Map.Entry<String, String> entry : dictionaryRepository.getDictionary().entrySet()) {
            dictionaryContents.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
        }
        return dictionaryContents.toString();
    }

    @Override
    public String findEntry(String key) {
        return dictionaryRepository.findEntry(key);
    }

    @Override
    public void saveDictionary() {
        dictionaryRepository.save();
    }
}