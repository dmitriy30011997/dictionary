package spring.dictionary.dictionaries.serveces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.dictionary.converters.Converter;
import spring.dictionary.dictionaries.repositories.IDictionaryRepository;
import spring.dictionary.dictionaries.validation.ValidationResolver;
import spring.dictionary.dictionaries.validation.IValidationRule;

import java.util.List;
import java.util.Map;

@Service
public class DigitDictionaryServiceImpl implements IDictionaryService {

    private final IDictionaryRepository dictionaryRepository;
    private final ValidationResolver validationService;

    @Autowired
    public DigitDictionaryServiceImpl(IDictionaryRepository dictionaryRepository, ValidationResolver validationService) {
        this.dictionaryRepository = dictionaryRepository;
        this.validationService = validationService;
    }

    @Override
    public void add(String key, String value) {
        IValidationRule rule = validationService.getRule("digit");
        if (rule != null && rule.validate(value)) {
            dictionaryRepository.addEntry(key, value);
        } else {
            System.out.println("Неправильный формат для словаря с цифрами.");
        }
    }

    @Override
    public void delete(String key) {
        dictionaryRepository.deleteEntry(key);
    }

    public String viewDictionaryContents() {
        StringBuilder dictionaryContents = new StringBuilder("Содержимое словаря 2 \n");
        Converter converter = new Converter();
        List<Object[]> listFromDictionary = dictionaryRepository.getDictionary();
        Map<String,String> results = converter.convert(listFromDictionary);

        for (Map.Entry<String, String> entry : results.entrySet()) {
            dictionaryContents.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
        }
        return dictionaryContents.toString();
    }

    @Override
    public String findEntry(String key) {
        return dictionaryRepository.findEntry(key);
    }

    @Override
    public int getType() {
        return 2;
    }

}
