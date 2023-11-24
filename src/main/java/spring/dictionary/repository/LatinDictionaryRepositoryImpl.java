package spring.dictionary.repository;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Repository;
import spring.dictionary.entities.LatinEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@Transactional
public class LatinDictionaryRepositoryImpl implements IDictionaryRepository {
    @PersistenceContext
    private final EntityManager entityManager;

    public LatinDictionaryRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

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
        LatinEntity digitEntity = entityManager.find(LatinEntity.class, key);
        if (digitEntity != null) {
            entityManager.remove(digitEntity);
        }
    }

    @Override
    @Transactional
    public String findEntry(String key) {
        LatinEntity latinEntity = entityManager.find(LatinEntity.class, key);
        if (latinEntity != null) {
            return latinEntity.getLatinValue();
        } else {
            return null;
        }
    }
    @Transactional(readOnly = true)
    public Map<String, String> getDictionary() {
        Session session = entityManager.unwrap(Session.class);
        Query query = session.createQuery("SELECT le.latinKey, le.latinValue FROM LatinEntity le");

        List<Object[]> results = query.list();

        Map<String, String> dictionaryMap = new HashMap<>();
        for (Object[] result : results) {
            dictionaryMap.put((String) result[0], (String) result[1]);
        }

        return dictionaryMap;
    }
}

