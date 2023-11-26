package spring.dictionary.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import spring.dictionary.entities.DigitEntity;
import spring.dictionary.entities.DigitSynonymEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.*;
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
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaDelete<DigitEntity> deleteQuery = builder.createCriteriaDelete(DigitEntity.class);

        Root<DigitEntity> root = deleteQuery.from(DigitEntity.class);
        deleteQuery.where(builder.equal(root.get("digitKey"), key));

        entityManager.createQuery(deleteQuery).executeUpdate();
    }


    @Override
    @Transactional(readOnly = true)
    public String findEntry(String key) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<String> query = builder.createQuery(String.class);

        Root<DigitEntity> root = query.from(DigitEntity.class);
        query.select(root.get("digitValue"));

        Predicate predicate = builder.equal(root.get("digitKey"), key);
        query.where(predicate);

        return entityManager.createQuery(query).getSingleResult();
    }

    @Override
    @Transactional(readOnly = true)
    public Map<String, String> getDictionary() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Object[]> query = builder.createQuery(Object[].class);

        Root<DigitEntity> root = query.from(DigitEntity.class);
        query.multiselect(root.get("digitKey"), root.get("digitValue"));

        List<Object[]> results = entityManager.createQuery(query).getResultList();

        Map<String, String> dictionaryMap = new HashMap<>();
        for (Object[] result : results) {
            dictionaryMap.put((String) result[0], (String) result[1]);
        }

        return dictionaryMap;
    }
}


