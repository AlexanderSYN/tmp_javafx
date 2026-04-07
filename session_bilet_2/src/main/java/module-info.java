module ru.katin.katinbilet {
    requires javafx.controls;
    requires javafx.fxml;


    opens ru.katin.katinbilet to javafx.fxml;
    exports ru.katin.katinbilet;
    exports ru.katin.katinbilet.Controllers;
    opens ru.katin.katinbilet.Controllers to javafx.fxml;
}