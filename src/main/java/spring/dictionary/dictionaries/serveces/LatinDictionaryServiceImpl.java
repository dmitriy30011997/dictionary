package spring.dictionary.dictionaries.serveces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.dictionary.dictionaries.repositories.IDictionaryRepository;
import spring.dictionary.dictionaries.validation.ValidationService;
import spring.dictionary.dictionaries.validation.IValidationRule;

import java.util.Map;

@Service
public class LatinDictionaryServiceImpl implements IDictionaryService {

    private final IDictionaryRepository dictionaryRepository;
    private final ValidationService validationService;

    @Autowired
    public LatinDictionaryServiceImpl(IDictionaryRepository dictionaryRepository, ValidationService validationService) {
        this.dictionaryRepository = dictionaryRepository;
        this.validationService = validationService;
    }

    @Override
    public void add(String key, String value) {
        IValidationRule rule = validationService.getRule("latin");
        if (rule != null && rule.validate(value)) {
            dictionaryRepository.addEntry(key, value);
        } else {
            System.out.println("Неправильный формат для латинского словаря.");
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
    public int getType() {
        return 1;
    }

}