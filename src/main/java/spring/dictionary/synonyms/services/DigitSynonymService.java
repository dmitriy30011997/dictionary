package spring.dictionary.synonyms.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.dictionary.synonyms.repositories.DigitSynonymRepositoryImpl;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class DigitSynonymService implements ISynonymService {

    private final DigitSynonymRepositoryImpl digitSynonymRepository;

    @Autowired
    public DigitSynonymService(DigitSynonymRepositoryImpl digitSynonymRepository) {
        this.digitSynonymRepository = digitSynonymRepository;
    }

    @Transactional
    public void addSynonym(String word, String synonym) {
        digitSynonymRepository.addSynonym(word, synonym);
    }

    @Transactional
    public void deleteSynonym(String synonym) {
        digitSynonymRepository.deleteSynonym(synonym);
    }

    @Transactional
    public List<String> getSynonyms(String word) {
        return digitSynonymRepository.getSynonyms(word);
    }

    @Override
    public int getType() {
        return 2;
    }
}

