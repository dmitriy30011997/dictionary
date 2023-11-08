package repository;

import service.FileService;

import java.util.Map;

public class DigitDictionaryRepository implements DictionaryRepository {
    private final Map<String, String> digitDictionary;
    private final FileService digitFileService;

    public DigitDictionaryRepository() {
        this.digitFileService = new FileService("src/main/latinDictionary.txt");
        this.digitDictionary = digitFileService.readFromFile();
    }

    @Override
    public void addEntry(String key, String value) {
        if (key.matches("^\\d{5}$") && value.matches("^\\d{5}$")) {
            digitDictionary.put(key, value);
        } else {
            System.out.println("Неверный формат слова для второго словаря.");
        }
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
    public void save(){
        digitFileService.writeToFile(digitDictionary);
    }
}
