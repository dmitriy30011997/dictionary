package spring.dictionary.repository;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Repository;
import spring.dictionary.entities.DigitEntity;
import spring.dictionary.entities.DigitSynonymEntity;
import spring.dictionary.entities.LatinEntity;
import spring.dictionary.entities.LatinSynonymEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.*;

@Repository
@Transactional
public class LatinDictionaryRepositoryImpl implements IDictionaryRepository {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public void addEntry(String key, String value) {
        LatinEntity latinEntity = new LatinEntity();
        latinEntity.setLatinKey(key);
        latinEntity.setLatinValue(value);
        entityManager.persist(latinEntity);
    }

    @Override
    @Transactional
    public void deleteEntry(String key) {
        Query query = entityManager.createQuery("DELETE FROM LatinEntity le WHERE le.latinKey = :key");
        query.setParameter("key", key);
        query.executeUpdate();
    }

    @Override
    @Transactional(readOnly = true)
    public String findEntry(String key) {
        Query query = entityManager.createQuery("SELECT le.latinValue FROM LatinEntity le WHERE le.latinKey = :key");
        query.setParameter("key", key);
        return (String) query.getSingleResult();

    }

    @Transactional(readOnly = true)
    public Map<String, String> getDictionary() {
        Query query = entityManager.createQuery("SELECT le.latinKey, le.latinValue FROM LatinEntity le");

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
        LatinEntity latinEntity = entityManager.find(LatinEntity.class, key);

        if (latinEntity != null) {
            LatinSynonymEntity synonymEntity = new LatinSynonymEntity();
            synonymEntity.setWord(key);
            synonymEntity.setSynonym(synonym);
            synonymEntity.setLatinEntity(latinEntity);

            entityManager.persist(synonymEntity);
        } else {
            throw new RuntimeException("Слово не найдено в словаре");
        }
    }

    @Override
    @Transactional
    public List<String> getLatinSynonyms(String word) {
        Query query = entityManager.createQuery(
                "SELECT s.synonym FROM LatinSynonymEntity s WHERE s.latinEntity.word = :word"
        );
        query.setParameter("word", word);

        List<String> synonyms = query.getResultList();
        return synonyms != null ? synonyms : Collections.emptyList();
    }
}

