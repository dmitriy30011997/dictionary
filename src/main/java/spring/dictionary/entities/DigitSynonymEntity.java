package spring.dictionary.entities;

import javax.persistence.*;

@Entity
@Table(name = "digit_synonym")
public class DigitSynonymEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "digit_synonym_id")
    private Long id;

    @Column(name = "word")
    private String word;

    @Column(name = "synonym")
    private String synonym;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "digit_entity_id")
    private DigitEntity digitEntity;


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

    public void setId(Long id) {
        this.id = id;
    }

    public DigitEntity getDigitEntity() {
        return digitEntity;
    }

    public void setDigitEntity(DigitEntity digitEntity) {
        this.digitEntity = digitEntity;
    }
}

