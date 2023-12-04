package spring.dictionary.converters;

import org.springframework.stereotype.Component;
import spring.dictionary.entities.IConvertible;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Component
public class Converter {

    public Map<String, String> convert(List<IConvertible[]> results) {
        Map<String, String> dictionaryMap = new HashMap<>();
        for (IConvertible[] result : results) {
            dictionaryMap.put(result[0].toString(), result[1].toString());
        }
        return dictionaryMap;
    }
}