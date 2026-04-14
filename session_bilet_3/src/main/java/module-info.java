module org.example.session_bilet_3 {
    requires javafx.controls;
    requires javafx.fxml;

    opens org.example.session_bilet_3.Controllers to javafx.fxml;
    opens org.example.session_bilet_3 to javafx.fxml;
    exports org.example.session_bilet_3;
}