package spring.dictionary.synonyms.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.dictionary.synonyms.repositories.LatinSynonymRepositoryImpl;

import javax.transaction.Transactional;
import java.util.List;


@Service
public class LatinSynonymService implements ISynonymService {

    private final LatinSynonymRepositoryImpl latinSynonymRepository;

    @Autowired
    public LatinSynonymService(LatinSynonymRepositoryImpl latinSynonymRepository) {
        this.latinSynonymRepository = latinSynonymRepository;
    }

    @Transactional
    public void addSynonym(String word, String synonym) {
        latinSynonymRepository.addSynonym(word, synonym);
    }

    @Transactional
    public void deleteSynonym(String synonym) {
        latinSynonymRepository.deleteSynonym(synonym);
    }

    @Transactional
    public List<String> getSynonyms(String word) {
        return latinSynonymRepository.getSynonyms(word);
    }

    @Override
    public int getType() {
        return 1;
    }
}

