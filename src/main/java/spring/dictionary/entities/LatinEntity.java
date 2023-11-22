package spring.dictionary.entities;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "latin_dictionary")
public class LatinEntity implements Serializable {

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

    public void setId(Long id) {
        this.id = id;
    }

    public void setLatinKey(String latinKey) {
        this.latinKey = latinKey;
    }

    public void setLatinValue(String latinValue) {
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
