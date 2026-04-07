package ru.katin.katinbilet.Controllers;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import ru.katin.katinbilet.model.Colledge;

import java.io.BufferedReader;
import java.io.FileReader;

import static ru.katin.katinbilet.util.Manager.dataList;


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
    private TableView<Colledge> tableViewColledge;

    @FXML
    void btnDel(ActionEvent event) {
        dataList.removeIf(i -> i.student_cipher().startsWith("BC") &&
                            Integer.parseInt(i.student_cipher().substring(2)) >= 1
                            && Integer.parseInt(i.student_cipher().substring(2)) <= 200);

        tableViewColledge.getItems().setAll(dataList);

    }

    @FXML
    void btnFindAction(ActionEvent event) {
        tableViewColledge.getItems().clear();
        dataList.stream().filter(i -> i.birthd_year() == 1999)
                .forEach(i -> tableViewColledge.getItems().add(i));

    }

    private void setValueInTable() {
        colNumPP.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().num_pp()));
        colCiphr.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().student_cipher()));
        colFullName.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().full_name()));
        colBirthdNum.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().birthd_day()));
        colBirthdMonth.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().birthd_month()));
        colBirthdYear.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().birthd_year()));
    }

    @FXML
    void btnLoadDataAction(ActionEvent event) {
        loadTextToDataList();
        tableViewColledge.getItems().clear();
        for (Colledge stud : dataList)
            tableViewColledge.getItems().add(stud);
        setValueInTable();
    }

    private void loadTextToDataList() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("2.txt"));
            String ln;

            while ((ln = br.readLine()) != null) {
                String[] word = ln.split(";", 0);
                dataList.add(new Colledge(Integer.parseInt(word[0]), word[1], word[2],
                        Integer.parseInt(word[3]), Integer.parseInt(word[4]), Integer.parseInt(word[5])));
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
