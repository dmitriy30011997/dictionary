package spring.dictionary.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "digit_dictionary")
public class DigitEntity implements Serializable {
    @OneToMany(mappedBy = "word", cascade = CascadeType.ALL)
    private List<SynonymEntity> synonyms = new ArrayList<>();

    public List<SynonymEntity> getSynonyms() {
        return synonyms;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "digit_key")
    private String digitKey;

    @Column(name = "digit_value")
    private String digitValue;

    public DigitEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDigitKey() {
        return digitKey;
    }

    public void setDigitKey(String digitKey) {
        this.digitKey = digitKey;
    }

    public String getDigitValue() {
        return digitValue;
    }

    public void setDigitValue(String digitValue) {
        this.digitValue = digitValue;
    }

    public DigitEntity(Long id, String digitKey, String digitValue) {
        this.id = id;
        this.digitKey = digitKey;
        this.digitValue = digitValue;
    }

    @Override
    public String toString() {
        return "DigitEntity{" +
                "id=" + id +
                ", digitKey='" + digitKey + '\'' +
                ", digitValue='" + digitValue + '\'' +
                '}';
    }
}
