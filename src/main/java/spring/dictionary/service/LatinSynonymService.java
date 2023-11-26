package spring.dictionary.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.dictionary.repository.LatinSynonymRepositoryImpl;

import javax.transaction.Transactional;
import java.util.List;


@Service
public class LatinSynonymService {

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
    public void deleteSynonym(String word, String synonym) {
        latinSynonymRepository.deleteSynonym(word, synonym);
    }

    @Transactional(readOnly = true)
    public List<String> getSynonyms(String word) {
        return latinSynonymRepository.getSynonyms(word);
    }
}

