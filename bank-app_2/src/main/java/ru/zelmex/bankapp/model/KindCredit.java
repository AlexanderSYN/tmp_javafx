package ru.zelmex.bankapp.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
@Entity
@Table(name = "kind_credit")
public class KindCredit {
    @Id
    @Column(name = "kind_credit_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer kindCreditId;
    @Column(name = "name")
    private String name;
    @Column(name = "conditions")
    private String conditions;
    @Column(name = "rate")
    private BigDecimal rate;
    @Column(name = "term")
    private Integer term;

    // Геттеры и сеттеры
    public Integer getKindCreditId() {
        return kindCreditId;
    }

    public void setKindCreditId(Integer kindCreditId) {
        this.kindCreditId = kindCreditId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (!name.isEmpty()) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Имя не должно быть пустым");
        }
    }

    public String getConditions() {
        return conditions;
    }

    public void setConditions(String conditions) {
        if (!conditions.isEmpty()) {
            this.conditions = conditions;
        } else {
            throw new IllegalArgumentException("Условие не должно быть пустым");
        }
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(String rateText) {
        if (!rateText.isEmpty() && rateText.matches("^[0-9]+([.,][0-9]+)?$")) {
            BigDecimal rate = BigDecimal.valueOf(Double.parseDouble(rateText.replace(",", ".")));
            if (rate.compareTo(BigDecimal.valueOf(0)) == 1 && rate.compareTo(BigDecimal.valueOf(99)) == -1) {
                this.rate = rate;
            } else {
                throw new IllegalArgumentException("Ставка должна быть в диапозоне от 0 до 99!");
            }
        } else {
            throw new IllegalArgumentException("Ставка должна быть числом!");
        }
    }

    public Integer getTerm() {
        return term;
    }

    public void setTerm(String termText) {
        if (!termText.isEmpty() && termText.matches("-?\\d+")) {
            int term = Integer.parseInt(termText);
            this.term = term;
        } else {
            throw new IllegalArgumentException("Срок должен быть целым числом!");
        }
    }

    @Override
    public String toString() {
        return name;
    }
}