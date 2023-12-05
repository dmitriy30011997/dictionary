package spring.dictionary.synonyms.repositories;

import java.util.List;

public interface ISynonymRepository {
    void addSynonym(String word, String synonym);
    List<String> getSynonyms(String word);
    void deleteSynonym(String synonym);
}
