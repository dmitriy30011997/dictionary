package spring.dictionary.synonyms.repositories;

import org.springframework.stereotype.Repository;
import spring.dictionary.entities.LatinSynonymEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

@Repository
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
    public void deleteSynonym(String synonym) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaDelete<LatinSynonymEntity> query = builder.createCriteriaDelete(LatinSynonymEntity.class);

        Root<LatinSynonymEntity> root = query.from(LatinSynonymEntity.class);
        query.where(builder.equal(root.get("synonym"), synonym));

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

        return entityManager.createQuery(query).setFirstResult(0)
                .setMaxResults(10).getResultList();
    }
}