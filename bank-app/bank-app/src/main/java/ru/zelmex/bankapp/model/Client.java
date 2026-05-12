package ru.zelmex.bankapp.model;
import jakarta.persistence.*;
@Entity
@Table(name = "clients")
public class Client {
    @Id
    @Column(name = "client_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer clientId;
    @Column(name = "name")
    private String name;
    @Column(name = "kind_property")
    private String kindProperty;
    @Column(name = "address")
    private String address;
    @Column(name = "phone")
    private String phone;
    @Column(name = "contact")
    private String contact;
    // Геттеры и сеттеры
    public Integer getClientId() {
        return clientId;
    }
    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        if (!name.isEmpty()) this.name = name;
        else throw new IllegalArgumentException("Имя не должно быть пустым!");
    }
    public String getKindProperty() {
        return kindProperty;
    }
    public void setKindProperty(String kindProperty) {
        if (!kindProperty.isEmpty()) this.kindProperty = kindProperty;
        else throw new IllegalArgumentException("Тип имущества не должен быть пуcтым!");
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        if (!address.isEmpty()) this.address = address;
        else throw new IllegalArgumentException("Адрес не может быть пустым!");
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        if (!phone.isEmpty() && phone.length() <= 20) this.phone = phone;
        else throw new IllegalArgumentException("Телефон не может быть пустым или содержать более 20 символов!");
    }
    public String getContact() {
        return contact;
    }
    public void setContact(String contact) {
        if (!contact.isEmpty()) this.contact = contact;
        else throw new IllegalArgumentException("Почта не может быть пустой!");
    }
    // @Override
// public String toString() {
// return "Client{" +
// "clientId=" + clientId +
// ", name='" + name + '\'' +
// ", kindProperty='" + kindProperty + '\'' +
// ", address='" + address + '\'' +
// ", phone='" + phone + '\'' +
// ", contact='" + contact + '\'' +
// '}';
// }
    @Override
    public String toString(){
        return name;
    }
}