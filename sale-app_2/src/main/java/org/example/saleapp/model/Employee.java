package org.example.saleapp.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "fam", length = 50, nullable = false)
    private String fam;
    @Column(name = "salary")
    private double salary;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getFam() {
        return fam;
    }
    public void setFam(String fam) {
        this.fam = fam;
    }
    public double getSumma() {
        return salary;
    }
    public void setSumma(double summa) {
        this.salary = summa;
    }
    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", fam='" + fam + '\'' +
                ", summa=" + salary +
                '}';
    }
}
