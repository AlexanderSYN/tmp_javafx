package org.example.session_bilet_3.Controllers;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.example.session_bilet_3.model.Accounting;
import org.example.session_bilet_3.util.Manager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Optional;

import static org.example.session_bilet_3.util.Manager.dataList;
import static org.example.session_bilet_3.util.Manager.*;


public class HelloController {

    @FXML
    private Button btnDel;

    @FXML
    private Button btnFind;

    @FXML
    private Button btnLoadData;

    @FXML
    private Button btnLoadDataAction;

    @FXML
    private TableColumn<Accounting, Number> colNumPP;

    @FXML
    private TableColumn<Accounting, String> colFIO;

    @FXML
    private TableColumn<Accounting, String> colTableNumber;

    @FXML
    private TableColumn<Accounting, Number> colSizeSalary;

    @FXML
    private TableView<Accounting> tableViewAccounting;

    @FXML
    void btnActionDel(ActionEvent event) {
        dataList.removeIf(i -> i.service_number().startsWith("A"));

        tableViewAccounting.getItems().setAll(dataList);

    }

    @FXML
    void btnFindAction(ActionEvent event) {
        tableViewAccounting.getItems().clear();
        dataList.stream().filter(i -> i.size_salary() >= 600.00)
                .forEach(i -> tableViewAccounting.getItems().add(i));

    }

    private void setValueInTable() {
        colNumPP.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().num_pp()));
        colFIO.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().fio()));
        colTableNumber.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().service_number()));
        colSizeSalary.setCellValueFactory(cellData -> new SimpleDoubleProperty(cellData.getValue().size_salary()));
    }

    @FXML
    void btnLoadDataAction(ActionEvent event) {
        loadTextToDataList();

        for (Accounting actng : dataList)
            tableViewAccounting.getItems().setAll(dataList);

        setValueInTable();
    }

    @FXML
    void delActionSelected(ActionEvent event) {
        Accounting accounting = tableViewAccounting.getSelectionModel().getSelectedItem();
        Optional<ButtonType> chooice = showConfirmationPopup(accounting.fio());
        if (accounting == null) return;
        if (chooice.get() == ButtonType.OK) {
            dataList.remove(accounting);
            tableViewAccounting.getItems().setAll(dataList);
        }
    }

    private void loadTextToDataList() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("3.txt"));
            String ln;

            while ((ln = br.readLine()) != null) {
                String[] word = ln.split(";", 0);
                dataList.add(new Accounting(Integer.parseInt(word[0]), word[1], word[2],
                        Double.parseDouble(word[3].replace(",", "."))));
            }

        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("CRITICAL ERROR!");
            alert.setHeaderText("ERROR LOAD TEXT!");
            alert.setContentText(String.format("More: %s", e.getMessage()));
            alert.show();
        }
    }

}
