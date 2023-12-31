package spring.dictionary.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "latin_dictionary")
public class LatinEntity implements Serializable, IConvertible {

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

    public LatinEntity(String latinKey, String latinValue) {
        this.latinKey = latinKey;
        this.latinValue = latinValue;
    }
    public LatinEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKey() {
        return latinKey;
    }

    public void setLatinKey(String latinKey) {
        this.latinKey = latinKey;
    }

    public String getValue() {
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
