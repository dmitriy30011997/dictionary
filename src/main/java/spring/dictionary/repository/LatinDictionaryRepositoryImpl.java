package spring.dictionary.repository;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import spring.dictionary.entities.LatinEntity;

import java.util.List;


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
    public List getDictionary() {
        return entityManager.createQuery("FROM LatinEntity")
                .getResultList();
    }

    @Override
    public void saveAll () {
        entityManager.getTransaction().commit();
    }
}

