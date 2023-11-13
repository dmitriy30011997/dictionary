package spring_dictionary.service;

import java.io.*;
import java.util.Map;
import java.util.HashMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class FileService {
    private final String fileName;
    private static final Logger logger = LoggerFactory.getLogger(FileService.class);
    @Autowired
    public FileService(@Value("${fileService.fileName}") String fileName) {
        this.fileName = fileName;
    }

    public void writeToFile(Map<String, String> dictionary, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Map.Entry<String, String> entry : dictionary.entrySet()) {
                writer.write(entry.getKey() + ": " + entry.getValue());
                writer.newLine();
            }
        } catch (IOException e) {
            logger.error("Something went wrong in method write to file ", e);
        }
    }

    public void writeToFile(Map<String, String> dictionary) {
        writeToFile(dictionary, fileName);
    }

    public Map<String, String> readFromFile() {
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
            logger.error("Something went wrong in method read to file ", e);
        }
        return dictionary;
    }
}