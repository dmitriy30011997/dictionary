package repository;

import service.FileService;

import java.util.Map;

public class LatinDictionaryRepository implements DictionaryRepository {
    private final Map<String, String> latinDictionary;
    private final FileService latinFileService;


    public LatinDictionaryRepository() {
        this.latinFileService = new FileService("src/main/latinDictionary.txt");
        latinDictionary = latinFileService.readFromFile();
    }

    @Override
    public void addEntry(String key, String value) {
        if (key.matches("^[a-zA-Z]{4}$") && value.matches("^[a-zA-Z]{4}$")) {
            latinDictionary.put(key, value);
        } else {
            System.out.println("Неверный формат слова для первого словаря.");
        }
    }
    @Override
    public void save(){
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
