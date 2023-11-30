package spring.dictionary.dictionaries.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.dictionary.converters.Converter;
import spring.dictionary.dictionaries.repositories.IDictionaryRepository;
import spring.dictionary.dictionaries.validation.ValidationResolver;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class DigitDictionaryServiceImpl implements IDictionaryService {
    @Autowired
    public void setConverter(Converter converter) {
        this.converter = converter;
    }

    private final IDictionaryRepository dictionaryRepository;
    private final ValidationResolver validationService;
    private Converter converter;

    @Autowired
    public DigitDictionaryServiceImpl(IDictionaryRepository dictionaryRepository, ValidationResolver validationService) {
        this.dictionaryRepository = dictionaryRepository;
        this.validationService = validationService;
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
    public Optional findEntry(String key) {
        return dictionaryRepository.findEntry(key);
    }

    @Override
    public int getType() {
        return 2;
    }

}