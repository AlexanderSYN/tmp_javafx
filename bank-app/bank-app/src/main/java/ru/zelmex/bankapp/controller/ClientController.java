package ru.zelmex.bankapp.controller;
import jakarta.validation.constraints.Null;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import java.util.List;
import javafx.scene.control.cell.PropertyValueFactory;
import ru.zelmex.bankapp.model.Client;
import ru.zelmex.bankapp.repository.ClientDao;
import java.net.URL;
import java.util.ResourceBundle;
public class ClientController implements Initializable {
    @FXML
    private Label welcomeText;
    @FXML
    private TableColumn<?, ?> addressColumn;
    @FXML
    private TableColumn<?, ?> emailColumn;
    @FXML
    private TableColumn<?, ?> kindPropertyColumn;
    @FXML
    private TableColumn<?, ?> phoneColumn;
    @FXML
    private TableView<Client> clientsTable;
    @FXML
    private TableColumn<Client, String> nameColumn;
    private final ClientDao clientDao = new ClientDao();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initController();
    }
    public void initController() {
        setCellValueFactories();
        List<Client> clients = clientDao.findAll();
        clientsTable.getItems().clear();
        for (Client client : clients) {
            clientsTable.getItems().add(client);
        }
        clientsTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    }
    private void setCellValueFactories() {
        phoneColumn.setCellValueFactory(new PropertyValueFactory<>("phone"));
        addressColumn.setCellValueFactory(new PropertyValueFactory<>("address"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("contact"));
        kindPropertyColumn.setCellValueFactory(new
                PropertyValueFactory<>("kindProperty"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
    }
}