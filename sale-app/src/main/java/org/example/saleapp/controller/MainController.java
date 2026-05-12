package org.example.saleapp.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import jakarta.validation.constraints.Null;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import java.util.List;
import org.example.saleapp.model.Employee;
import org.example.saleapp.repository.EmployeeDao;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    @FXML
    private Label welcomeText;
    @FXML
    private TableView<Employee> saleTable;
    @FXML
    private TableColumn<Employee, String> nameColumn;
    @FXML
    private TableColumn<Employee, Number> saleColumn;
    private final EmployeeDao employeeDao = new EmployeeDao();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initController();
    }
    public void initController() {
        setCellValueFactories();
        List<Employee> employees = employeeDao.findAll();
        saleTable.getItems().clear();
        for (Employee employee : employees) {
            saleTable.getItems().add(employee);
        }
        saleTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    }
    private void setCellValueFactories() {
        nameColumn.setCellValueFactory(cellData -> new
                SimpleStringProperty(cellData.getValue().getFam().toString()));
        saleColumn.setCellValueFactory(cellData -> new
                SimpleDoubleProperty(cellData.getValue().getSumma()));
    }
}