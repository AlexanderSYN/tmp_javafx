package org.example.saleapp.controller;

import javafx.beans.property.SimpleDoubleProperty;
import org.example.saleapp.model.Employee;
import javafx.beans.property.SimpleStringProperty;

public class EmployeeTableItem {
    private SimpleStringProperty fam;
    private SimpleDoubleProperty summa;
    private Employee employee;
    public EmployeeTableItem(Employee employee) {
        this.fam = new SimpleStringProperty(employee.getFam());
        this.summa = new SimpleDoubleProperty(employee.getSumma());
        this.employee = employee;
    }
    public String getFam() {
        return fam.get();
    }
    public SimpleStringProperty famProperty() {
        return fam;
    }
    public void setFam(String fam) {
        this.fam.set(fam);
    }
    public double getSumma() {
        return summa.get();
    }
    public SimpleDoubleProperty summaProperty() {
        return summa;
    }
    public void setSumma(double summa) {
        this.summa.set(summa);
    }
    public Employee getEmployee() {
        return employee;
    }
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}