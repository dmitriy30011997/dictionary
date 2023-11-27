package spring.dictionary.dictionaries.serveces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.dictionary.annotations.DigitValidation;
import spring.dictionary.annotations.LatinValidation;
import spring.dictionary.dictionaries.repositories.IDictionaryRepository;

import java.util.Map;

@Service
public class DigitDictionaryServiceImpl implements IDictionaryService {
    private final IDictionaryRepository dictionaryRepository;

    @Autowired
    public DigitDictionaryServiceImpl(IDictionaryRepository dictionaryRepository) {
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
        return 2;
    }

}
