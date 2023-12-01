package spring.dictionary.dictionaries.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import spring.dictionary.entities.DigitEntity;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional(rollbackFor = {Exception.class})
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
    @Transactional(readOnly = true, rollbackFor = {NoResultException.class})
    public Optional<String> findEntry(String key) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<String> query = builder.createQuery(String.class);

        Root<DigitEntity> root = query.from(DigitEntity.class);
        query.select(root.get("digitValue"));

        Predicate predicate = builder.equal(root.get("digitKey"), key);
        query.where(predicate);

        try {
            String result = entityManager.createQuery(query).getSingleResult();
            return Optional.ofNullable(result);
        } catch (NoResultException | NonUniqueResultException e) {
            return Optional.empty();
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<DigitEntity> getDictionary() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<DigitEntity> query = builder.createQuery(DigitEntity.class);

        Root<DigitEntity> root = query.from(DigitEntity.class);
        query.multiselect(root.get("digitKey"), root.get("digitValue"));

        return entityManager.createQuery(query).getResultList();
    }
}