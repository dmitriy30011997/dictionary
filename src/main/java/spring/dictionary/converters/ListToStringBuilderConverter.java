package spring.dictionary.converters;

import spring.dictionary.entities.IConvertible;

import java.util.List;


public class ListToStringBuilderConverter {


    public StringBuilder convert(List<IConvertible> results) {
        StringBuilder dictionaryContents = new StringBuilder();

        for (IConvertible result : results) {
            dictionaryContents.append(result.getKey()).append(": ").append(result.getValue()).append("\n");
        }

        return dictionaryContents;
    }
}