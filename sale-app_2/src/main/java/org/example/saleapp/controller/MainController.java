package org.example.saleapp.controller;

import jakarta.validation.constraints.Null;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import java.io.IOException;
import java.util.List;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.example.saleapp.SaleApp;
import org.example.saleapp.model.Employee;
import org.example.saleapp.repository.EmployeeDao;
import org.example.saleapp.service.EmployeeService;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    private List<Employee> employees;
    private ObservableList<EmployeeTableItem> employeesObservable;
    @FXML
    private TableView<EmployeeTableItem> saleTable;
    @FXML
    private TableColumn<Employee, String> nameColumn;
    @FXML
    private TableColumn<Employee, Number> saleColumn;
    private final EmployeeDao employeeDao = new EmployeeDao();
    @FXML
    void addEmployee(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(SaleApp.class.getResource("add-edit-employee-dialog.fxml"));
            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(SaleApp.primaryStage);
            dialogStage.setMinWidth(400);
            dialogStage.setScene(new Scene(loader.load()));
            dialogStage.setTitle("Добавить работника");
            AddEditEmployeeDialog controller = loader.getController();
            controller.setAddDialogStage(dialogStage);
            dialogStage.showAndWait();
            updateList();
        } catch (IOException e) {
            System.out.println("Ошибка открытия окна: " + e.getMessage());
        }
    }
    @FXML
    void deleteEmployee(ActionEvent event) {
        EmployeeTableItem currentItem = saleTable.getSelectionModel().getSelectedItem();
        int currentItemId = saleTable.getSelectionModel().getSelectedIndex();
        if (currentItemId != -1) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Подтверждение удаления");
            alert.setHeaderText("Удаление записи");
            alert.setContentText("Вы действительно хотите удалить \"" + currentItem.getFam() + "\"?");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                new EmployeeService().delete(currentItem.getEmployee());
                saleTable.getItems().remove(currentItemId);
            }
        }else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Предупреждение");
            alert.setHeaderText("Ошибка удаление");
            alert.setContentText("Выберите запись в таблице для удаления");
            alert.showAndWait();
        }
    }
    @FXML
    void editEmployee(ActionEvent event) {
        EmployeeTableItem currentItem = saleTable.getSelectionModel().getSelectedItem();
        int currentItemId = saleTable.getSelectionModel().getSelectedIndex();
        if (currentItemId != -1) {
            try {
                FXMLLoader loader = new FXMLLoader(SaleApp.class.getResource("add-edit-employee-dialog.fxml"));
                Stage dialogStage = new Stage();
                dialogStage.initModality(Modality.WINDOW_MODAL);
                dialogStage.initOwner(SaleApp.primaryStage);
                dialogStage.setMinWidth(400);
                dialogStage.setScene(new Scene(loader.load()));
                dialogStage.setTitle("Редактировать работника");
                AddEditEmployeeDialog controller = loader.getController();
                controller.setEditDialogStage(dialogStage, currentItem.getEmployee());
                dialogStage.showAndWait();
                updateList();
            } catch (IOException e) {
                System.out.println("Ошибка открытия окна: " + e.getMessage());
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Предупреждение");
            alert.setContentText("Выберите запись в таблице для редактирования");
            alert.showAndWait();
        }
    }
    @FXML
    void powerOff(ActionEvent event) {
        SaleApp.primaryStage.close();
    }
    @FXML
    void updateEmployee(ActionEvent event) {
        updateList();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("fam"));
        saleColumn.setCellValueFactory(new PropertyValueFactory<>("summa"));
        updateList();
    }
    public void updateList() {
        employees = new EmployeeService().findAll();
        employeesObservable = FXCollections.observableArrayList();
        for (Employee emp : employees) {
            employeesObservable.add(new EmployeeTableItem(emp));
        }
        saleTable.setItems(employeesObservable);
    }
    private void setCellValueFactories() {
        nameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getFam().toString()));
        saleColumn.setCellValueFactory(cellData -> new SimpleDoubleProperty(cellData.getValue().getSumma()));
    }
}