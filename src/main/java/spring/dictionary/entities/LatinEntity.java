package spring.dictionary.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "latin_dictionary")
public class LatinEntity implements Serializable {
    @OneToMany(mappedBy = "word", cascade = CascadeType.ALL)
    private List<LatinSynonymEntity> synonyms = new ArrayList<>();

    public List<LatinSynonymEntity> getSynonyms() {
        return synonyms;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "latin_key")
    private String latinKey;

    @Column(name = "latin_value")
    private String latinValue;

    public LatinEntity() {
    }

    public Long getId() {
        return id;
    }

    public String getLatinKey() {
        return latinKey;
    }

    public String getLatinValue() {
        return latinValue;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setLatinKey(String latinKey) {
        this.latinKey = latinKey;
    }

    public void setLatinValue(String latinValue) {
        this.latinValue = latinValue;
    }

    public LatinEntity(Long id, String latinKey, String latinValue) {
        this.id = id;
        this.latinKey = latinKey;
        this.latinValue = latinValue;
    }

    @Override
    public String toString() {
        return "LatinEntity{" +
                "id=" + id +
                ", latinKey='" + latinKey + '\'' +
                ", latinValue='" + latinValue + '\'' +
                '}';
    }
}
