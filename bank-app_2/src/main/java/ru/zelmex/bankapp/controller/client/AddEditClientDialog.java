package ru.zelmex.bankapp.controller.client;

import ru.zelmex.bankapp.model.Client;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import ru.zelmex.bankapp.services.ClientService;

import java.net.URL;
import java.util.ResourceBundle;
public class AddEditClientDialog implements Initializable {
    @FXML
    private TextField addressField;
    @FXML
    private TextField emailField;
    @FXML
    private Label errorLabel;
    @FXML
    private TextField kindPropertyField;
    @FXML
    private TextField nameField;
    @FXML
    private Button okButton;
    @FXML
    private TextField phoneField;
    private Stage dialogStage;
    private Client client;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    private void add() {
        try {
            Client client = new Client();
            client.setName(nameField.getText());
            client.setPhone(phoneField.getText());
            client.setAddress(addressField.getText());
            client.setContact(emailField.getText());
            client.setKindProperty(kindPropertyField.getText());
            ClientTableItem clientTableItem = new ClientTableItem(client);
            new ClientService().save(client);
            dialogStage.close();
        } catch (IllegalArgumentException e) {
            errorLabel.setText(e.getMessage());
        }
    }

    void edit() {
        try {
            client.setName(nameField.getText());
            client.setPhone(phoneField.getText());
            client.setAddress(addressField.getText());
            client.setContact(emailField.getText());
            client.setKindProperty(kindPropertyField.getText());
            new ClientService().update(client);
            dialogStage.close();
        } catch (IllegalArgumentException e) {
            errorLabel.setText(e.getMessage());
        }
    }

    public void setAddDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
        okButton.setOnAction((www) -> add());
    }

    public void setEditDialogStage(Stage dialogStage, Client client) {
        this.client = client;
        this.dialogStage = dialogStage;
        nameField.setText(client.getName());
        kindPropertyField.setText(client.getKindProperty());
        addressField.setText(client.getAddress());
        phoneField.setText(client.getPhone());
        emailField.setText(client.getContact());
        okButton.setOnAction((www) -> edit());
    }
}
