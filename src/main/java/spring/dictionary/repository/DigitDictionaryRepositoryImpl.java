package spring.dictionary.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import spring.dictionary.entities.DigitEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@Transactional
public class DigitDictionaryRepositoryImpl implements IDictionaryRepository {
    @PersistenceContext
    private final EntityManager entityManager;

    public DigitDictionaryRepositoryImpl(EntityManager entityManager) {

        this.entityManager = entityManager;
    }

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
        DigitEntity digitEntity = entityManager.find(DigitEntity.class, key);
        if (digitEntity != null) {
            entityManager.remove(digitEntity);
        }
    }

    @Override
    @Transactional
    public String findEntry(String key) {
        DigitEntity digitEntity = entityManager.find(DigitEntity.class, key);
        if (digitEntity != null) {
            return digitEntity.getDigitValue();
        } else {
            return null;
        }
    }

    @Transactional
    public Map<String, String> getDictionary() {
        Query query = entityManager.createQuery("SELECT de.digitKey, de.digitValue FROM DigitEntity de");

        List<Object[]> results = query.getResultList();

        Map<String, String> dictionaryMap = new HashMap<>();
        for (Object[] result : results) {
            dictionaryMap.put((String) result[0], (String) result[1]);
        }

        return dictionaryMap;
    }
}

