package ru.name.ex15.controllers;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import ru.name.ex15.model.Metro;
import static ru.name.ex15.util.Manager.dataList;

import java.io.BufferedReader;
import java.io.FileReader;

public class HelloController {

    @FXML
    private Button btnDel;

    @FXML
    private Button btnFind;

    @FXML
    private Button btnLoad;

    @FXML
    private TableColumn<Metro, Number> colCodeMetro;

    @FXML
    private TableColumn<Metro, Number> colCountStation;

    @FXML
    private TableColumn<Metro, Number> colLengthLines;

    @FXML
    private TableColumn<Metro, String> colName;

    @FXML
    private TableView<Metro> tableViewMetro;

    @FXML
    void btnDelAction(ActionEvent event) {
        if (dataList.isEmpty()) return;

        int minStation = dataList.stream().
                mapToInt(Metro::count)
                .min()
                .orElse(Integer.MAX_VALUE);

        dataList.removeIf(metro -> metro.count() == minStation);
        tableViewMetro.setItems(FXCollections.observableArrayList(dataList));
    }

    @FXML
    void btnFindAction(ActionEvent event) {
        tableViewMetro.getItems().clear();
        dataList.stream()
                .filter(i -> i.name().equalsIgnoreCase("Кольцевая"))
                .forEach(i -> tableViewMetro.getItems().add(i));
    }

    private void setDataInTable() {
        colCodeMetro.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().codeMetro()));
        colName.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().name()));
        colCountStation.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().count()));
        colLengthLines.setCellValueFactory(cellData -> new SimpleDoubleProperty(cellData.getValue().length()));
    }

    @FXML
    void btnLoadAction(ActionEvent event) {

        loadText();
        tableViewMetro.getItems().clear();
        for (Metro metro : dataList)
            tableViewMetro.getItems().add(metro);


        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("INFO");
        alert.setHeaderText(String.format("Всего %d записей", tableViewMetro.getItems().size()));
        alert.show();

        setDataInTable();

    }

    private static void loadText() {
        dataList.clear();

        try (BufferedReader br = new BufferedReader(new FileReader("15.txt"))) {

            String ln;
            while ((ln = br.readLine()) != null) {
                String[] word = ln.split(";", 0);
                dataList.add(new Metro(Integer.parseInt(word[0]), word[1],
                        Integer.parseInt(word[2]), Double.parseDouble(word[3].replace(",", "."))));
            }

        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("CRITICAL ERROR");
            alert.setHeaderText("Error read text");
            alert.setContentText(String.format("ERROR: %s", e.getMessage()));
            alert.show();
        }
    }

}
