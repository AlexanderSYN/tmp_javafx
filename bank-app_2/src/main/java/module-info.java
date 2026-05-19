module ru.zelmex.bankapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires jakarta.persistence;
    requires org.hibernate.orm.core;
    requires java.naming;
    requires java.desktop;
    opens ru.zelmex.bankapp to javafx.fxml;
    opens ru.zelmex.bankapp.model to org.hibernate.orm.core;
    exports ru.zelmex.bankapp;
    exports ru.zelmex.bankapp.controller.client;
    opens ru.zelmex.bankapp.controller.client to javafx.fxml;
    exports ru.zelmex.bankapp.controller.kindCredit;
    opens ru.zelmex.bankapp.controller.kindCredit to javafx.fxml;
    exports ru.zelmex.bankapp.controllercredit;
    opens ru.zelmex.bankapp.controller.credit to javafx.fxml;
}