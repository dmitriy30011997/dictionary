package spring.dictionary.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import spring.dictionary.entities.DigitEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@Transactional
public class DigitDictionaryRepositoryImpl implements IDictionaryRepository {
    private final SessionFactory sessionFactory;

    public DigitDictionaryRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addEntry(String key, String value) {
        Session session = sessionFactory.getCurrentSession();
        DigitEntity digitEntity = new DigitEntity();
        digitEntity.setDigitKey(key);
        digitEntity.setDigitValue(value);
        session.persist(digitEntity);
    }

    @Override
    public void deleteEntry(String key) {
//        DigitEntity digitEntity = session.find(DigitEntity.class, key);
//        if (digitEntity != null) {
//            entityManager.remove(digitEntity);
//        }
    }

    @Override
    public String findEntry(String key) {
//        DigitEntity digitEntity = entityManager.find(DigitEntity.class, key);
//        if (digitEntity != null) {
//            return digitEntity.getDigitValue();
//        } else {
            return null;
//        }
    }

    public Map<String,String> getDictionary() {
//        Session session = entityManager.unwrap(Session.class);
//        Query query = session.createQuery("SELECT de.digitKey, de.digitValue FROM DigitEntity de");
//
//        List<Object[]> results = query.list();
//
//        Map<String, String> dictionaryMap = new HashMap<>();
//        for (Object[] result : results) {
//            dictionaryMap.put((String) result[0], (String) result[1]);
//        }
//
//        return dictionaryMap;
        return null;
    }

        @Override
        public void saveAll () {
//            entityManager.getTransaction().commit();
        }
    }

