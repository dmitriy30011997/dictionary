package spring.dictionary.repository;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Repository;
import spring.dictionary.entities.DigitEntity;
import spring.dictionary.entities.DigitSynonymEntity;
import spring.dictionary.entities.LatinEntity;
import spring.dictionary.entities.LatinSynonymEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.*;
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
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaDelete<LatinEntity> deleteQuery = builder.createCriteriaDelete(LatinEntity.class);

        Root<LatinEntity> root = deleteQuery.from(LatinEntity.class);
        deleteQuery.where(builder.equal(root.get("latinKey"), key));

        entityManager.createQuery(deleteQuery).executeUpdate();
    }

    @Override
    @Transactional(readOnly = true)
    public String findEntry(String key) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<String> query = builder.createQuery(String.class);

        Root<LatinEntity> root = query.from(LatinEntity.class);
        query.select(root.get("latinValue"));

        Predicate predicate = builder.equal(root.get("latinKey"), key);
        query.where(predicate);

        return entityManager.createQuery(query).getSingleResult();
    }

    @Override
    @Transactional(readOnly = true)
    public Map<String, String> getDictionary() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Object[]> query = builder.createQuery(Object[].class);

        Root<LatinEntity> root = query.from(LatinEntity.class);
        query.multiselect(root.get("latinKey"), root.get("latinValue"));

        List<Object[]> results = entityManager.createQuery(query).getResultList();

        Map<String, String> dictionaryMap = new HashMap<>();
        for (Object[] result : results) {
            dictionaryMap.put((String) result[0], (String) result[1]);
        }

        return dictionaryMap;
    }

    @Override
    @Transactional
    public void addSynonym(String key, String synonym) {
        LatinSynonymEntity synonymEntity = new LatinSynonymEntity();
        synonymEntity.setWord(key);
        synonymEntity.setSynonym(synonym);

        entityManager.persist(synonymEntity);
    }

    @Override
    @Transactional(readOnly = true)
    public List<String> getSynonyms(String word) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<String> query = builder.createQuery(String.class);

        Root<LatinSynonymEntity> root = query.from(LatinSynonymEntity.class);
        query.select(root.get("synonym"));

        Predicate predicate = builder.equal(root.get("word"), word);
        query.where(predicate);

        List<String> synonyms = entityManager.createQuery(query).getResultList();
        return synonyms != null ? synonyms : Collections.emptyList();
    }
}

