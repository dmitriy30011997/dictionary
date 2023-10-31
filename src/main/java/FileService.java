import java.util.Map;
import java.io.*;
import java.util.HashMap;
public class FileService {
    private String firstDictionaryFileName;
    private String secondDictionaryFileName;

    public FileService(String firstDictionaryFileName, String secondDictionaryFileName) {
        this.firstDictionaryFileName = firstDictionaryFileName;
        this.secondDictionaryFileName = secondDictionaryFileName;
    }

    public void writeToFile(Map<String, String> dictionary, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Map.Entry<String, String> entry : dictionary.entrySet()) {
                writer.write(entry.getKey() + ": " + entry.getValue());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeToFileForFirstDictionary(Map<String, String> dictionary) {
        writeToFile(dictionary, firstDictionaryFileName);
    }

    public void writeToFileForSecondDictionary(Map<String, String> dictionary) {
        writeToFile(dictionary, secondDictionaryFileName);
    }

    public Map<String, String> readFromFile(String fileName) {
        Map<String, String> dictionary = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length == 2) {
                    String key = parts[0].trim();
                    String value = parts[1].trim();
                    dictionary.put(key, value);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dictionary;
    }

    public Map<String, String> readFromFileForFirstDictionary() {
        return readFromFile(firstDictionaryFileName);
    }

    public Map<String, String> readFromFileForSecondDictionary() {
        return readFromFile(secondDictionaryFileName);
    }
}