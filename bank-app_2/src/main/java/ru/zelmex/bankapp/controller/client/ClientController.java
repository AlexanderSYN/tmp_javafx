package ru.zelmex.bankapp.controller.client;

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
import java.util.Optional;

import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import ru.zelmex.bankapp.BankApp;
import ru.zelmex.bankapp.controller.client.AddEditClientDialog;
import ru.zelmex.bankapp.controller.client.ClientTableItem;
import ru.zelmex.bankapp.model.Client;
import ru.zelmex.bankapp.repository.ClientDao;
import ru.zelmex.bankapp.services.ClientService;

public class ClientController {
    private List<Client> clients;
    private ObservableList<ClientTableItem> creditsObservable;
    @FXML
    private TableColumn<?, ?> addressColumn;
    @FXML
    private TableColumn<?, ?> emailColumn;
    @FXML
    private TableColumn<?, ?> kindPropertyColumn;
    @FXML
    private TableColumn<?, ?> phoneColumn;
    @FXML
    private TableView<ClientTableItem> clientsTable;
    @FXML
    private TableColumn<Client, String> nameColumn;
    private final ClientDao clientDao = new ClientDao();
    public void initialize() {
        phoneColumn.setCellValueFactory(new PropertyValueFactory<>("phone"));
        addressColumn.setCellValueFactory(new PropertyValueFactory<>("address"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        kindPropertyColumn.setCellValueFactory(new PropertyValueFactory<>("kindProperty"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        updateList();
    }
    @FXML
    private Label welcomeText;
    @FXML
    void btnCreditsOnAction(ActionEvent event) {
    }
    @FXML
    void btnKindCreditOnAction(ActionEvent event) {
        BankApp.primaryStage.setScene(BankApp.kindCredits);
    }
    @FXML
    void btnAddClient(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(BankApp.class.getResource("add-edit-client-dialog.fxml"));
            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(BankApp.primaryStage);
            dialogStage.setMinWidth(400);
            dialogStage.setScene(new Scene(loader.load()));
            dialogStage.setTitle("Добавить клиента");
            AddEditClientDialog controller = loader.getController();
            controller.setAddDialogStage(dialogStage);
            dialogStage.showAndWait();
            updateList();
        } catch (IOException e) {
            System.out.println("Ошибка открытия окна: " + e.getMessage());
        }
    }
    private void updateList() {
        clients = new ClientService().findAll();
        creditsObservable = FXCollections.observableArrayList();
        for (Client client : clients) {
            creditsObservable.add(new ClientTableItem(client));
        }
        clientsTable.setItems(creditsObservable);
    }
    @FXML
    void btnDeleteClient(ActionEvent event) {
        ClientTableItem currentItem = clientsTable.getSelectionModel().getSelectedItem();
        int currentItemId = clientsTable.getSelectionModel().getSelectedIndex();
        if (currentItemId != -1) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Подтверждение удаления");
            alert.setHeaderText("Удаление записи");
            alert.setContentText("Вы действительно хотите удалить \"" + currentItem.getName() + "\"?");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                new ClientService().delete(currentItem.getClient());
                clientsTable.getItems().remove(currentItemId);
            }
        }else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Предупреждение");
            alert.setContentText("Выберите запись в таблице для удаления");
            alert.showAndWait();
        }
    }
    @FXML
    void btnEditClient(ActionEvent event) {
        ClientTableItem currentItem = clientsTable.getSelectionModel().getSelectedItem();
        int currentItemId = clientsTable.getSelectionModel().getSelectedIndex();
        if (currentItemId != -1) {
            try {
                FXMLLoader loader = new FXMLLoader(BankApp.class.getResource("add-edit-client-dialog.fxml"));
                Stage dialogStage = new Stage();
                dialogStage.initModality(Modality.WINDOW_MODAL);
                dialogStage.initOwner(BankApp.primaryStage);
                dialogStage.setMinWidth(400);
                dialogStage.setScene(new Scene(loader.load()));
                dialogStage.setTitle("Редактировать клиента");
                AddEditClientDialog controller = loader.getController();
                controller.setEditDialogStage(dialogStage, currentItem.getClient());
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
    void btnOffOnAction(ActionEvent event) {
        BankApp.primaryStage.close();
    }
    @FXML
    void btnUpdateClients(ActionEvent event) {
        updateList();
    }

} 