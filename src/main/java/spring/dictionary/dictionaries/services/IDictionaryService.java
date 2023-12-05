package spring.dictionary.dictionaries.services;

import spring.dictionary.converters.ListToStringBuilderConverter;

import java.util.Optional;

public interface IDictionaryService {
    void add(String key, String value);
    void delete(String key);
    String viewDictionaryContents();
    Optional findEntry(String key);
    int getType();
    void setConverter(ListToStringBuilderConverter listToStringBuilderConverter);
}
