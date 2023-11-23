package spring.dictionary.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Repository;
import spring.dictionary.entities.LatinEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@Transactional
public class LatinDictionaryRepositoryImpl implements IDictionaryRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addEntry(String key, String value) {
        LatinEntity latinEntity = new LatinEntity();
        latinEntity.setLatinKey(key);
        latinEntity.setLatinValue(value);
        entityManager.persist(latinEntity);
    }

    @Override
    public void deleteEntry(String key) {
        LatinEntity digitEntity = entityManager.find(LatinEntity.class, key);
        if (digitEntity != null) {
            entityManager.remove(digitEntity);
        }
    }

    @Override
    public String findEntry(String key) {
        LatinEntity latinEntity = entityManager.find(LatinEntity.class, key);
        if (latinEntity != null) {
            return latinEntity.getLatinValue();
        } else {
            return null;
        }
    }
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

    @Override
    public void saveAll () {
        entityManager.getTransaction().commit();
    }
}

