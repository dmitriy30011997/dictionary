package spring.dictionary.entities;

import javax.persistence.*;

@Entity
@Table(name = "latin_synonym")
public class LatinSynonymEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "word")
    private String word;

    @Column(name = "synonym")
    private String synonym;

    @ManyToOne
    @JoinColumn(name = "latin_entity_id")
    private LatinEntity latinEntity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public LatinEntity getLatinEntity() {
        return latinEntity;
    }

    public void setLatinEntity(LatinEntity latinEntity) {
        this.latinEntity = latinEntity;
    }
}
