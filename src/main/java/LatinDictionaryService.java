public class LatinDictionaryService implements Service {
    private DictionaryRepository dictionaryRepository;

    public LatinDictionaryService(DictionaryRepository dictionaryRepository) {
        this.dictionaryRepository = dictionaryRepository;
    }

    @Override
    public void add(String key, String value) {
        dictionaryRepository.addEntry(key, value, 1);
    }

    @Override
    public void delete(String key, int language) {
        dictionaryRepository.deleteEntry(key, 1);
    }
}

    public String viewDictionaryContents() {
        String dictionary1Contents = "Содержимое словаря 1:\n";
        String dictionary2Contents = "Содержимое словаря 2:\n";

        for (Map.Entry<String, String> entry : dictionaryRepository.getDictionary1().entrySet()) {
            dictionary1Contents += entry.getKey() + ": " + entry.getValue() + "\n";
        }

        for (Map.Entry<String, String> entry : dictionaryRepository.getDictionary2().entrySet()) {
            dictionary2Contents += entry.getKey() + ": " + entry.getValue() + "\n";
        }

        return dictionary1Contents + "\n" + dictionary2Contents;
    }
}