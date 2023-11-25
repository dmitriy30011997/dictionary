package spring.dictionary.entities;

import javax.persistence.*;

@Entity
@Table(name = "synonym_table")
public class SynonymEntity {

    @ManyToOne
    @JoinColumn(name = "digit_entity_id")
    private DigitEntity digitEntity;

    @ManyToOne
    @JoinColumn(name = "latin_entity_id")
    private LatinEntity latinEntity;

    public DigitEntity getDigitEntity() {
        return digitEntity;
    }

    public void setDigitEntity(DigitEntity digitEntity) {
        this.digitEntity = digitEntity;
    }

    public LatinEntity getLatinEntity() {
        return latinEntity;
    }

    public void setLatinEntity(LatinEntity latinEntity) {
        this.latinEntity = latinEntity;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "word")
    private String word;

    @Column(name = "synonym")
    private String synonym;

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getSynonym() {
        return synonym;
    }

    public void setSynonym(String synonym) {
        this.synonym = synonym;
    }

    public Long getId() {
        return id;
    }
}
