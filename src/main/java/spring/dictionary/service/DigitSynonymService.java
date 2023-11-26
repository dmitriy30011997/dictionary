package spring.dictionary.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.dictionary.repository.DigitSynonymRepositoryImpl;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class DigitSynonymService {

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
    public void deleteSynonym(String word, String synonym) {
        digitSynonymRepository.deleteSynonym(word, synonym);
    }

    @Transactional(readOnly = true)
    public List<String> getSynonyms(String word) {
        return digitSynonymRepository.getSynonyms(word);
    }
}

