package org.example.session_bilet_3.util;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import org.example.session_bilet_3.model.Accounting;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Manager {
    public static final List<Accounting> dataList = new ArrayList<>();

    public static Optional<ButtonType> showConfirmationPopup(String text) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Удаление!");
        alert.setHeaderText(String.format("вы уверены, что хотите удалить '%s'?", text));
        return alert.showAndWait();
    }
}
