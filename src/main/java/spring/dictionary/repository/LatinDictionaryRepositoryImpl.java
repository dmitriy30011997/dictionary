package spring.dictionary.repository;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Repository;
import spring.dictionary.entities.LatinEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
}

