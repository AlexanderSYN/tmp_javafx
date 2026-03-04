package ru.katin.repair.controller;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import ru.katin.repair.model.Painting;
import ru.katin.repair.model.Plumbing;
import ru.katin.repair.model.Renovation;

import java.net.URL;
import java.util.ResourceBundle;


import ru.katin.repair.model.Flooring;

import static ru.katin.repair.util.Mgr.dataList;


public class MainController implements Initializable {

    @FXML
    private TableColumn<Renovation, String> addressColumn;

    @FXML
    private TableColumn<Renovation, Number> costColumn;

    @FXML
    private TableView<Renovation> tableView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        createData();
        loadData();
        setCellValueFactories();
    }

    private void setCellValueFactories() {
        addressColumn.setCellValueFactory(cellData -> new SimpleStringProperty("Адрес: " + cellData.getValue().getAddress()));
        costColumn.setCellValueFactory(cellData -> new SimpleDoubleProperty(cellData.getValue().calculateCost()));
    }

    private void loadData() {
        tableView.getItems().clear();
        for (Renovation r : dataList) {
            tableView.getItems().add(r);
        }
    }

    private void createData() {
        Renovation f;
        Renovation pa;
        Renovation pl;
        for (int i = 1; i <= 10; i++) {
            f = new Flooring("ул. Ленина", 100);
            pa = new Painting("ул. Карла-Маркса", 200);
            pl = new Plumbing("ул. Энгельса", 300);
            dataList.add(f);
            dataList.add(pa);
            dataList.add(pl);
        }
    }
}
