package ru.zelmex.bankapp.controller.kindCredit;

import ru.zelmex.bankapp.model.KindCredit;
import javafx.beans.property.SimpleStringProperty;
public class KindCreditTableItem {
    private SimpleStringProperty name;
    private SimpleStringProperty condition;
    private SimpleStringProperty rate;
    private SimpleStringProperty term;
    private KindCredit kindCredit;

    public KindCreditTableItem(KindCredit kindCredit) {
        this.name = new SimpleStringProperty(kindCredit.getName());
        this.condition = new SimpleStringProperty(kindCredit.getConditions());
        this.rate = new SimpleStringProperty(kindCredit.getRate().toString());
        this.term = new SimpleStringProperty(kindCredit.getTerm().toString());
        this.kindCredit = kindCredit;
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getCondition() {
        return condition.get();
    }

    public SimpleStringProperty conditionProperty() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition.set(condition);
    }

    public String getRate() {
        return rate.get();
    }

    public SimpleStringProperty rateProperty() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate.set(rate);
    }

    public String getTerm() {
        return term.get();
    }

    public SimpleStringProperty termProperty() {
        return term;
    }

    public void setTerm(String term) {
        this.term.set(term);
    }

    public KindCredit getKindCredit() {
        return kindCredit;
    }

    public void setKindCredit(KindCredit kindCredit) {
        this.kindCredit = kindCredit;
    }
}