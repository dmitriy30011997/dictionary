package spring.dictionary.converters;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Converter {

    public Map<String, String> convert(List<Object[]> results) {
        Map<String, String> dictionaryMap = new HashMap<>();
        for (Object[] result : results) {
            dictionaryMap.put((String) result[0], (String) result[1]);
        }
        return dictionaryMap;
    }
}