package spring.dictionary.synonyms.repositories;

import org.springframework.stereotype.Repository;
import spring.dictionary.entities.DigitSynonymEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class DigitSynonymRepositoryImpl implements ISynonymRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public void addSynonym(String word, String synonym) {
        DigitSynonymEntity synonymEntity = new DigitSynonymEntity();
        synonymEntity.setWord(word);
        synonymEntity.setSynonym(synonym);
        entityManager.persist(synonymEntity);
    }

    @Override
    @Transactional
    public void deleteSynonym(String synonym) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaDelete<DigitSynonymEntity> query = builder.createCriteriaDelete(DigitSynonymEntity.class);

        Root<DigitSynonymEntity> root = query.from(DigitSynonymEntity.class);
        query.where(builder.equal(root.get("synonym"), synonym));

        entityManager.createQuery(query).executeUpdate();
    }


    @Override
    @Transactional
    public List<String> getSynonyms(String word) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<String> query = builder.createQuery(String.class);

        Root<DigitSynonymEntity> root = query.from(DigitSynonymEntity.class);
        query.select(root.get("synonym"));

        Predicate predicate = builder.equal(root.get("word"), word);
        query.where(predicate);

        List<String> synonyms = entityManager.createQuery(query).getResultList();
        return synonyms;
    }
}


