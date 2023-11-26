package spring.dictionary.synonyms.services;

import java.util.List;

public interface ISynonymService {
    void addSynonym(String word, String synonym);
    void deleteSynonym(String synonym);
    List<String> getSynonyms(String word);
    int getType();
}
