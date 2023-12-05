package spring.dictionary.dictionaries.services;

import spring.dictionary.converters.ListToStringBuilderConverter;
import spring.dictionary.dictionaries.repositories.IDictionaryRepository;
import spring.dictionary.entities.DigitEntity;
import spring.dictionary.entities.IConvertible;

import java.util.List;
import java.util.Optional;


public class DigitDictionaryServiceImpl implements IDictionaryService {

    public void setConverter(ListToStringBuilderConverter listToStringBuilderConverter) {
        this.listToStringBuilderConverter = listToStringBuilderConverter;
    }

    private final IDictionaryRepository<DigitEntity> dictionaryRepository;

    private ListToStringBuilderConverter listToStringBuilderConverter;


    public DigitDictionaryServiceImpl(IDictionaryRepository<DigitEntity> dictionaryRepository) {
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
        System.out.println("Содержимое цифрового словаря: ");
        List<IConvertible> listFromDictionary = dictionaryRepository.getDictionary();
        StringBuilder dictionaryContents = listToStringBuilderConverter.convert(listFromDictionary);

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