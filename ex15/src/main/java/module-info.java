module ru.name.ex15 {
    requires javafx.controls;
    requires javafx.fxml;


    opens ru.name.ex15 to javafx.fxml;
    exports ru.name.ex15;
    exports ru.name.ex15.controllers;
    opens ru.name.ex15.controllers to javafx.fxml;
}