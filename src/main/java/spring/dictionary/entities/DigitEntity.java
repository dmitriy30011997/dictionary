package spring.dictionary.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "digit_dictionary")
public class DigitEntity {

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
}
