package spring.dictionary.synonyms.services;

import spring.dictionary.synonyms.repositories.ISynonymRepository;

import java.util.List;


public class DigitSynonymService implements ISynonymService {

    private final ISynonymRepository digitSynonymRepository;


    public DigitSynonymService(ISynonymRepository digitSynonymRepository) {
        this.digitSynonymRepository = digitSynonymRepository;
    }


    public void addSynonym(String word, String synonym) {
        digitSynonymRepository.addSynonym(word, synonym);
    }


    public void deleteSynonym(String synonym) {
        digitSynonymRepository.deleteSynonym(synonym);
    }


    public List<String> getSynonyms(String word) {
        return digitSynonymRepository.getSynonyms(word);
    }

    @Override
    public int getType() {
        return 2;
    }
}

