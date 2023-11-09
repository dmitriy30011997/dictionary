package service;

import repository.DigitDictionaryRepositoryImpl;

import java.util.Map;
public class DigitDictionaryServiceImpl implements DictionaryService {
    private final DigitDictionaryRepositoryImpl dictionaryRepository;

    public DigitDictionaryServiceImpl() {
        this.dictionaryRepository = new DigitDictionaryRepositoryImpl();
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
        StringBuilder dictionaryContents = new StringBuilder("Содержимое словаря 2 \n");

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