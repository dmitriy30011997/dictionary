package spring.dictionary.converters;

import org.springframework.stereotype.Component;
import spring.dictionary.entities.IConvertible;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class Converter {

    public StringBuilder convert(List<IConvertible> results) {
        StringBuilder dictionaryContents = new StringBuilder();
        Map<String, String> dictionaryMap = new HashMap<>();

        for (IConvertible result : results) {
            dictionaryMap.put(result.getKey(), result.getValue());
            dictionaryContents.append(result.getKey()).append(": ").append(result.getValue()).append("\n");
        }

        return dictionaryContents;
    }

}