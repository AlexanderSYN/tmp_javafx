package ru.zelmex.bankapp.controller.client;

import javafx.beans.property.SimpleDoubleProperty;
import ru.zelmex.bankapp.model.Client;
import javafx.beans.property.SimpleStringProperty;

public class ClientTableItem {
    private SimpleStringProperty name;
    private SimpleStringProperty kindProperty;
    private SimpleStringProperty address;
    private SimpleStringProperty phone;
    private SimpleStringProperty email;
    private Client client;
    public ClientTableItem(Client client) {
        this.name = new SimpleStringProperty(client.getName());
        this.kindProperty = new SimpleStringProperty(client.getKindProperty());
        this.address = new SimpleStringProperty(client.getAddress());
        this.phone = new SimpleStringProperty(client.getPhone());
        this.email = new SimpleStringProperty(client.getContact());
        this.client = client;
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
    public String getKindProperty() {
        return kindProperty.get();
    }
    public SimpleStringProperty kindPropertyProperty() {
        return kindProperty;
    }
    public void setKindProperty(String kindProperty) {
        this.kindProperty.set(kindProperty);
    }
    public String getAddress() {
        return address.get();
    }
    public SimpleStringProperty addressProperty() {
        return address;
    }
    public void setAddress(String address) {
        this.address.set(address);
    }
    public String getPhone() {
        return phone.get();
    }
    public SimpleStringProperty phoneProperty() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone.set(phone);
    }
    public String getEmail() {
        return email.get();
    }
    public SimpleStringProperty emailProperty() {
        return email;
    }
    public void setEmail(String email) {
        this.email.set(email);
    }
    public Client getClient() {
        return client;
    }
    public void setClient(Client client) {
        this.client = client;
    }
}