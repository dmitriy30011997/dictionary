import java.util.HashMap;
import java.util.Map;

public class DictionaryRepository {
    private Map<String, String> dictionary1;
    private Map<String, String> dictionary2;

    public DictionaryRepository() {
        this.dictionary1 = new HashMap<>();
        this.dictionary2 = new HashMap<>();
    }

    public void addEntry(String key, String value, int language) {
        if (language == 1) {
            if (key.matches("^[a-zA-Z]{4}$") && value.matches("^[a-zA-Z]{4}$")) {
                dictionary1.put(key, value);
            } else {
                System.out.println("Неверный формат слова для первого словаря.");
            }
        } else if (language == 2) {
            if (key.matches("^\\d{5}$") && value.matches("^\\d{5}$")) {
                dictionary2.put(key, value);
            } else {
                System.out.println("Неверный формат слова для второго словаря.");
            }
        } else {
            System.out.println("Неверный выбор языка.");
        }
    }

    public void deleteEntry(String key, int language) {
        if (language == 1) {
            dictionary1.remove(key);
        } else if (language == 2) {
            dictionary2.remove(key);
        } else {
            System.out.println("Неверный выбор языка.");
        }
    }

    public String findEntry(String key, int language) {
        if (language == 1) {
            return dictionary1.get(key);
        } else if (language == 2) {
            return dictionary2.get(key);
        } else {
            System.out.println("Неверный выбор языка.");
            return null;
        }
    }

    public void setDictionary1(Map<String, String> dictionary1) {
        this.dictionary1 = dictionary1;
    }

    public void setDictionary2(Map<String, String> dictionary2) {
        this.dictionary2 = dictionary2;
    }

    public Map<String, String> getDictionary1() {
        return dictionary1;
    }

    public Map<String, String> getDictionary2() {
        return dictionary2;
    }
}
