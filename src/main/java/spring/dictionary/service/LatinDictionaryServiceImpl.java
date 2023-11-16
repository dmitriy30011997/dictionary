package spring.dictionary.service;
import spring.dictionary.repository.DictionaryRepository;

import java.util.Map;

public class LatinDictionaryServiceImpl implements DictionaryService {
    private final DictionaryRepository dictionaryRepository;

    public LatinDictionaryServiceImpl(DictionaryRepository dictionaryRepository) {
        this.dictionaryRepository = dictionaryRepository;
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
        dictionaryRepository.saveAll();
    }

    @Override
    public int getType() {
        return 1;
    }
}