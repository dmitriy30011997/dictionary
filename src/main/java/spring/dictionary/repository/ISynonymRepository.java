package spring.dictionary.repository;

import javax.transaction.Transactional;
import java.util.List;

public interface ISynonymRepository {
    void addSynonym(String word, String synonym);
    List<String> getSynonyms(String word);
    void deleteSynonym(String word, String synonym);
}
