package spring.dictionary.repository;

import org.springframework.stereotype.Repository;
import spring.dictionary.entities.LatinSynonymEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;

@Repository
@Transactional
public class LatinSynonymRepositoryImpl implements ISynonymRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public void addSynonym(String word, String synonym) {
        LatinSynonymEntity synonymEntity = new LatinSynonymEntity();
        synonymEntity.setWord(word);
        synonymEntity.setSynonym(synonym);
        entityManager.persist(synonymEntity);
    }

    @Override
    @Transactional
    public void deleteSynonym(String word, String synonym) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaDelete<LatinSynonymEntity> query = builder.createCriteriaDelete(LatinSynonymEntity.class);

        Root<LatinSynonymEntity> root = query.from(LatinSynonymEntity.class);
        Predicate predicate = builder.and(
                builder.equal(root.get("word"), word),
                builder.equal(root.get("synonym"), synonym)
        );
        query.where(predicate);

        entityManager.createQuery(query).executeUpdate();
    }

    @Override
    @Transactional
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