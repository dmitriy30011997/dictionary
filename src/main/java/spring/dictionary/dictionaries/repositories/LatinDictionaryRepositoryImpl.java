package spring.dictionary.dictionaries.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import spring.dictionary.entities.IConvertible;
import spring.dictionary.entities.LatinEntity;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional(rollbackFor = {Exception.class})
public class LatinDictionaryRepositoryImpl implements IDictionaryRepository<LatinEntity> {
    public static final String LATIN_KEY = "latinKey";
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
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaDelete<LatinEntity> deleteQuery = builder.createCriteriaDelete(LatinEntity.class);

        Root<LatinEntity> root = deleteQuery.from(LatinEntity.class);
        deleteQuery.where(builder.equal(root.get(LATIN_KEY), key));

        entityManager.createQuery(deleteQuery).executeUpdate();
    }

    @Override
    @Transactional(readOnly = true, rollbackFor = {NoResultException.class})
    public Optional<String> findEntry(String key) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<String> query = builder.createQuery(String.class);

        Root<LatinEntity> root = query.from(LatinEntity.class);
        query.select(root.get("latinValue"));

        Predicate predicate = builder.equal(root.get(LATIN_KEY), key);
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
    public List<IConvertible> getDictionary(int pageNumber, int pageSize) {
        pageNumber = pageNumber <= 0 ? 1 : pageNumber;
        pageSize = pageSize <= 0 ? 10 : pageSize;

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<? extends IConvertible> query = builder.createQuery(LatinEntity.class);

        Root<? extends IConvertible> root = query.from(LatinEntity.class);
        query.multiselect(root.get(LATIN_KEY), root.get("latinValue"));

        return (List<IConvertible>) entityManager.createQuery(query).setFirstResult(pageNumber)
                .setMaxResults(pageSize).getResultList();
    }
}

