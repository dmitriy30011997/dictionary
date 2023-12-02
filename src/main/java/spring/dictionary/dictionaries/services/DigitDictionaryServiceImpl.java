package spring.dictionary.dictionaries.services;

import spring.dictionary.converters.Converter;
import spring.dictionary.dictionaries.repositories.IDictionaryRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class DigitDictionaryServiceImpl implements IDictionaryService {

    public void setConverter(Converter converter) {
        this.converter = converter;
    }

    private final IDictionaryRepository dictionaryRepository;
    private Converter converter;


    public DigitDictionaryServiceImpl(IDictionaryRepository dictionaryRepository) {
        this.dictionaryRepository = dictionaryRepository;
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

        List<Object[]> listFromDictionary = dictionaryRepository.getDictionary();
        Map<String,String> results = converter.convert(listFromDictionary);

        for (Map.Entry<String, String> entry : results.entrySet()) {
            dictionaryContents.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
        }
        return dictionaryContents.toString();
    }

    @Override
    public Optional<String> findEntry(String key) {
        return dictionaryRepository.findEntry(key);
    }

    @Override
    public int getType() {
        return 2;
    }

}
