package spring.dictionary.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import spring.dictionary.entities.DigitEntity;

import java.util.List;

@Repository
@Transactional
public class DigitDictionaryRepositoryImpl implements IDictionaryRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addEntry(String key, String value) {
        DigitEntity digitEntity = new DigitEntity();
        digitEntity.setDigitKey(key);
        digitEntity.setDigitValue(value);
        entityManager.persist(digitEntity);
    }

    @Override
    public void deleteEntry(String key) {
        DigitEntity digitEntity = entityManager.find(DigitEntity.class, key);
        if (digitEntity != null) {
            entityManager.remove(digitEntity);
        }
    }

    @Override
    public String findEntry(String key) {
        DigitEntity digitEntity = entityManager.find(DigitEntity.class, key);
        if (digitEntity != null) {
            return digitEntity.getDigitValue();
        } else {
            return null;
        }
    }

    public List getDictionary() {
        return entityManager.createQuery("FROM DigitEntity")
                .getResultList();
    }

        @Override
        public void saveAll () {
            entityManager.getTransaction().commit();
        }
    }

