module ru.katin.repair {
    requires javafx.controls;
    requires javafx.fxml;


    opens ru.katin.repair to javafx.fxml;
    exports ru.katin.repair;
    exports ru.katin.repair.controller;
    opens ru.katin.repair.controller to javafx.fxml;
    exports ru.katin.repair.model;
    opens ru.katin.repair.model to javafx.fxml;
}