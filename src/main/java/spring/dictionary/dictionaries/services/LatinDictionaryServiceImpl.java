package spring.dictionary.dictionaries.services;

import spring.dictionary.converters.ListToStringBuilderConverter;
import spring.dictionary.dictionaries.repositories.IDictionaryRepository;
import spring.dictionary.entities.IConvertible;
import spring.dictionary.entities.LatinEntity;

import java.util.List;
import java.util.Optional;


public class LatinDictionaryServiceImpl implements IDictionaryService {

    private final IDictionaryRepository<LatinEntity> dictionaryRepository;
    private ListToStringBuilderConverter converter;


    public void setConverter(ListToStringBuilderConverter listToStringBuilderConverter) {
        this.converter = listToStringBuilderConverter;
    }

    public LatinDictionaryServiceImpl(IDictionaryRepository<LatinEntity> dictionaryRepository) {
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
        System.out.println("Содержимое латинского словаря: ");
        List<IConvertible> listFromDictionary = dictionaryRepository.getDictionary();
        StringBuilder dictionaryContents = converter.convert(listFromDictionary);

        return dictionaryContents.toString();
    }


    @Override
    public Optional<String> findEntry(String key) {
        return dictionaryRepository.findEntry(key);
    }


    @Override
    public int getType() {
        return 1;
    }

}