module ru.zelmex.saleapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires jakarta.persistence;
    requires org.hibernate.orm.core;
    requires java.naming;
    requires java.desktop;
    requires org.hibernate.validator;
    requires org.postgresql.jdbc;
    requires jakarta.validation;
    opens org.example.saleapp to javafx.fxml;
    opens org.example.saleapp.model to org.hibernate.orm.core, javafx.base;
    exports org.example.saleapp;
    exports org.example.saleapp.controller;
    opens org.example.saleapp.controller to javafx.fxml;
    opens org.example.saleapp.util to org.hibernate.orm.core;
}