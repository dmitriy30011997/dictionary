package spring.dictionary.dictionaries.services;

import spring.dictionary.converters.Converter;
import spring.dictionary.dictionaries.repositories.IDictionaryRepository;
import spring.dictionary.dictionaries.validation.DigitValidation;
import spring.dictionary.entities.DigitEntity;
import spring.dictionary.entities.IConvertible;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class DigitDictionaryServiceImpl implements IDictionaryService {

    public void setConverter(Converter converter) {
        this.converter = converter;
    }

    private final IDictionaryRepository<DigitEntity> dictionaryRepository;
    private Converter converter;


    public DigitDictionaryServiceImpl(IDictionaryRepository<DigitEntity> dictionaryRepository) {
        this.dictionaryRepository = dictionaryRepository;
    }

    @Override
    public void add(@DigitValidation String key, @DigitValidation String value) {
            dictionaryRepository.addEntry(key, value);
    }

    @Override
    public void delete(String key) {
        dictionaryRepository.deleteEntry(key);
    }

    public String viewDictionaryContents() {
        StringBuilder dictionaryContents = new StringBuilder("Содержимое словаря 2 \n");

        List<IConvertible[]> listFromDictionary = dictionaryRepository.getDictionary();
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
