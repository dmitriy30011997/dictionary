package spring.dictionary.service;

import spring.dictionary.repository.IDictionaryRepository;

import java.util.Map;
public class DigitDictionaryServiceImpl implements IDictionaryService {
    private final IDictionaryRepository dictionaryRepository;
    public DigitDictionaryServiceImpl(IDictionaryRepository dictionaryRepository) {
        this.dictionaryRepository = dictionaryRepository;
    }

    @Override
    public void add(String key, String value) {
        if (key.matches("^\\d{5}$") && value.matches("^\\d{5}$")) {
            dictionaryRepository.addEntry(key, value);
        } else {
            System.out.println("Неверный формат слова для второго словаря.");
        }
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
        dictionaryRepository.saveAll();
    }

    @Override
    public int getType() {
        return 2;
    }
}
