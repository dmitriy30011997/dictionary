package spring.dictionary.repository;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Repository;
import spring.dictionary.entities.LatinEntity;
import spring.dictionary.entities.SynonymEntity;

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
    public void addSynonym(String word, String synonym) {
        LatinEntity latinEntity = entityManager.find(LatinEntity.class, word);
        if (latinEntity != null) {
            SynonymEntity synonymEntity = new SynonymEntity();
            synonymEntity.setWord(word);
            synonymEntity.setSynonym(synonym);
            synonymEntity.setLatinEntity(latinEntity);
            entityManager.persist(synonymEntity);
        }
    }

    @Override
    @Transactional
    public List<String> getSynonyms(String word) {
        LatinEntity latinEntity = entityManager.find(LatinEntity.class, word);
        if (latinEntity != null) {
            List<String> synonyms = new ArrayList<>();
            for (SynonymEntity synonymEntity : latinEntity.getSynonyms()) {
                synonyms.add(synonymEntity.getSynonym());
            }
            return synonyms;
        }
        return Collections.emptyList();
    }
}

