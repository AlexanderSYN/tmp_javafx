package org.example.saleapp.controller;

import org.example.saleapp.model.Employee;
import org.example.saleapp.service.EmployeeService;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ResourceBundle;
public class AddEditEmployeeDialog implements Initializable {
    @FXML
    private TextField famField;
    @FXML
    private TextField saleField;
    @FXML
    private Label errorLabel;
    @FXML
    private Button okButton;
    private Stage dialogStage;
    private Employee employee;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
    private void add() {
        try {
            Employee employee = new Employee();
            employee.setFam(famField.getText());
            employee.setSumma(Double.parseDouble(saleField.getText()));
            EmployeeTableItem employeeTableItem = new EmployeeTableItem(employee);
            new EmployeeService().save(employee);
            dialogStage.close();
        }catch (IllegalArgumentException e){
            errorLabel.setText(e.getMessage());
        }
    }
    void edit() {
        try {
            employee.setFam(famField.getText());
            employee.setSumma(Double.parseDouble(saleField.getText()));
            new EmployeeService().update(employee);
            dialogStage.close();
        }catch (IllegalArgumentException e){
            errorLabel.setText(e.getMessage());
        }
    }
    public void setAddDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
        okButton.setOnAction((www) -> add());
    }
    public void setEditDialogStage(Stage dialogStage, Employee employee) {
        this.employee = employee;
        this.dialogStage = dialogStage;
        famField.setText(employee.getFam());
        saleField.setText(Double.toString(employee.getSumma()));
        okButton.setOnAction((www) -> edit());
    }
}
