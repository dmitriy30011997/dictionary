package spring.dictionary.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "latin_dictionary")
public class LatinEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "latin_entity_id")
    private Long id;

    @Column(name = "latin_key")
    private String latinKey;

    @Column(name = "latin_value")
    private String latinValue;

    @OneToMany(mappedBy = "latinEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LatinSynonymEntity> synonyms = new ArrayList<>();


    public LatinEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLatinKey() {
        return latinKey;
    }

    public void setLatinKey(String latinKey) {
        this.latinKey = latinKey;
    }

    public String getLatinValue() {
        return latinValue;
    }

    public void setLatinValue(String latinValue) {
        this.latinValue = latinValue;
    }

    public List<LatinSynonymEntity> getSynonyms() {
        return synonyms;
    }

    public void setSynonyms(List<LatinSynonymEntity> synonyms) {
        this.synonyms = synonyms;
    }
}
