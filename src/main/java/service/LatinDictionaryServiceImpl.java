package service;

import repository.LatinDictionaryRepositoryImpl;

import java.util.Map;

public class LatinDictionaryServiceImpl implements DictionaryService {
    private final LatinDictionaryRepositoryImpl dictionaryRepository;

    public LatinDictionaryServiceImpl() {
        this.dictionaryRepository = new LatinDictionaryRepositoryImpl();
    }

    @Override
    public void add(String key, String value) {
        if (key.matches("^[a-zA-Z]{4}$") && value.matches("^[a-zA-Z]{4}$")) {
            dictionaryRepository.addEntry(key, value);
        } else {
            System.out.println("Неверный формат слова для первого словаря.");
        }
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