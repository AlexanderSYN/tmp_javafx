package ru.katin.katinbilet.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import ru.katin.katinbilet.model.Colledge;

public class HelloController {

    @FXML
    private Button btnDel;

    @FXML
    private Button btnFind;

    @FXML
    private Button btnLoadData;

    @FXML
    private TableColumn<Colledge, Number> colBirthdMonth;

    @FXML
    private TableColumn<Colledge, Number> colBirthdNum;

    @FXML
    private TableColumn<Colledge, Number> colBirthdYear;

    @FXML
    private TableColumn<Colledge, String> colCiphr;

    @FXML
    private TableColumn<Colledge, String> colFullName;

    @FXML
    private TableColumn<Colledge, Number> colNumPP;

    @FXML
    public void initilize() {

    }

    @FXML
    void btnDel(ActionEvent event) {

    }

    @FXML
    void btnFindAction(ActionEvent event) {

    }

    @FXML
    void btnLoadDataAction(ActionEvent event) {

    }

}
