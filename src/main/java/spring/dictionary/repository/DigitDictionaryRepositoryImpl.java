package spring.dictionary.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import spring.dictionary.entities.DigitEntity;
import spring.dictionary.entities.DigitSynonymEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.*;

@Repository
@Transactional
public class DigitDictionaryRepositoryImpl implements IDictionaryRepository {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public void addEntry(String key, String value) {
        DigitEntity digitEntity = new DigitEntity();
        digitEntity.setDigitKey(key);
        digitEntity.setDigitValue(value);
        entityManager.persist(digitEntity);
    }

    @Override
    @Transactional
    public void deleteEntry(String key) {
        Query query = entityManager.createQuery("DELETE FROM DigitEntity le WHERE le.digitKey = :key");
        query.setParameter("key", key);
        query.executeUpdate();
    }

    @Override
    @Transactional
    public String findEntry(String key) {
        Query query = entityManager.createQuery("SELECT de.digitValue FROM DigitEntity de WHERE de.digitKey = :key");
        query.setParameter("key", key);
        return (String) query.getSingleResult();
    }

    @Transactional(readOnly = true)
    public Map<String, String> getDictionary() {
        Query query = entityManager.createQuery("SELECT de.digitKey, de.digitValue FROM DigitEntity de");

        List<Object[]> results = query.getResultList();

        Map<String, String> dictionaryMap = new HashMap<>();
        for (Object[] result : results) {
            dictionaryMap.put((String) result[0], (String) result[1]);
        }

        return dictionaryMap;
    }

    @Override
    @Transactional
    public void addSynonym(String key, String synonym) {
        DigitSynonymEntity synonymEntity = new DigitSynonymEntity();
        synonymEntity.setWord(key);
        synonymEntity.setSynonym(synonym);

        entityManager.persist(synonymEntity);
    }

    @Override
    @Transactional
    public List<String> getSynonyms(String word) {
        Query query = entityManager.createQuery(
                "SELECT s.synonym FROM DigitSynonymEntity s WHERE s.digitEntity.word = :word"
        );
        query.setParameter("word", word);

        List<String> synonyms = query.getResultList();
        return synonyms != null ? synonyms : Collections.emptyList();
    }
}


