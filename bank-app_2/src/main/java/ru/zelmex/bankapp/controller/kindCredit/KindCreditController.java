package ru.zelmex.bankapp.controller.kindCredit;

import ru.zelmex.bankapp.BankApp;
import ru.zelmex.bankapp.model.KindCredit;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import ru.zelmex.bankapp.services.KindCreditService;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
public class KindCreditController {
    private List<KindCredit> kindCredits;
    @FXML
    private Button btnClients;
    @FXML
    private TableColumn<?, ?> conditionColumn;
    @FXML
    private Button btnCredits;
    @FXML
    private TableView<KindCreditTableItem> kindCreditsTable;
    @FXML
    private Button btnKindCredit;
    @FXML
    private TableColumn<?, ?> nameColumn;
    @FXML
    private TableColumn<?, ?> rateColumn;
    @FXML
    private TableColumn<?, ?> termColumn;
    private ObservableList<KindCreditTableItem> creditsObservable;
    @FXML
    void btnAddKindCredit(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(BankApp.class.getResource("add-edit-kind-credit-dialog.fxml"));
            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(BankApp.primaryStage);
            dialogStage.setMinWidth(400);
            dialogStage.setScene(new Scene(loader.load()));
            dialogStage.setTitle("Добавить вид кредита");
            AddEditKindCreditDialog controller = loader.getController();
            controller.setAddDialogStage(dialogStage);
            dialogStage.showAndWait();
            updateList();
        } catch (IOException e) {
            System.out.println("Ошибка открытия окна: " + e.getMessage());
        }
    }
    @FXML
    void btnDeleteKindCredit(ActionEvent event) {
        KindCreditTableItem currentItem = kindCreditsTable.getSelectionModel().getSelectedItem();
        int currentItemId = kindCreditsTable.getSelectionModel().getSelectedIndex();
        if (currentItemId != -1) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Подтверждение удаления");
            alert.setHeaderText("Удаление записи");
            alert.setContentText("Вы действительно хотите удалить \"" + currentItem.getName() + "\"?");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                new KindCreditService().delete(currentItem.getKindCredit());
                kindCreditsTable.getItems().remove(currentItemId);
            }
        }
        else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Предупреждение");
            alert.setContentText("Выберите запись в таблице для удаления");
            alert.showAndWait();
        }
    }
    @FXML
    void btnEditKindCredit(ActionEvent event) {
        KindCreditTableItem currentItem = kindCreditsTable.getSelectionModel().getSelectedItem();
        int currentItemId = kindCreditsTable.getSelectionModel().getSelectedIndex();
        if (currentItemId != -1) {
            try {
                FXMLLoader loader = new FXMLLoader(BankApp.class.getResource("add-edit-kind-credit-dialog.fxml"));
                Stage dialogStage = new Stage();
                dialogStage.initModality(Modality.WINDOW_MODAL);
                dialogStage.initOwner(BankApp.primaryStage);
                dialogStage.setMinWidth(400);
                dialogStage.setScene(new Scene(loader.load()));
                dialogStage.setTitle("Редактировать вид кредита");
                AddEditKindCreditDialog controller = loader.getController();
                controller.setEditDialogStage(dialogStage, currentItem.getKindCredit());
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
    void btnOff(ActionEvent event) {
        BankApp.primaryStage.close();
    }
    @FXML
    void btnUpdateKindCredits(ActionEvent event) {
        updateList();
    }
    public void updateList() {
        kindCredits = new KindCreditService().findAll();
        creditsObservable = FXCollections.observableArrayList();
        for (KindCredit kindCredit : kindCredits) {
            creditsObservable.add(new KindCreditTableItem(kindCredit));
        }
        kindCreditsTable.setItems(creditsObservable);
    }
    public void initialize() {
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        conditionColumn.setCellValueFactory(new PropertyValueFactory<>("condition"));
        rateColumn.setCellValueFactory(new PropertyValueFactory<>("rate"));
        termColumn.setCellValueFactory(new PropertyValueFactory<>("term"));
        updateList();
    }
    public void btnClients(ActionEvent actionEvent) {
        BankApp.primaryStage.setScene(BankApp.clients);
    }
}