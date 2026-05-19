package ru.zelmex.bankapp.controller.kindCredit;

import ru.zelmex.bankapp.model.KindCredit;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import ru.zelmex.bankapp.services.KindCreditService;

public class AddEditKindCreditDialog {
    @FXML
    private TextField conditionField;
    @FXML
    private Label errorLabel;
    @FXML
    private TextField nameField;
    @FXML
    private Button okButton;
    @FXML
    private TextField rateField;
    @FXML
    private TextField termField;
    private Stage dialogStage;
    private KindCredit kindCredit;

    void add() {
        try {
            KindCredit kindCredit = new KindCredit();
            kindCredit.setName(nameField.getText());
            kindCredit.setConditions(conditionField.getText());
            kindCredit.setRate(rateField.getText());
            kindCredit.setTerm(termField.getText());
            KindCreditTableItem kindCreditTableItem = new KindCreditTableItem(kindCredit);
            new KindCreditService().save(kindCredit);
            dialogStage.close();
        } catch (IllegalArgumentException e) {
            errorLabel.setText(e.getMessage());
        }
    }

    public void setAddDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
        okButton.setOnAction((www) -> add());
    }

    void edit() {
        try {
            kindCredit.setName(nameField.getText());
            kindCredit.setConditions(conditionField.getText());
            kindCredit.setRate(rateField.getText());
            kindCredit.setTerm(termField.getText());
            new KindCreditService().update(kindCredit);
            dialogStage.close();
        } catch (IllegalArgumentException e) {
            errorLabel.setText(e.getMessage());
        }
    }

    public void setEditDialogStage(Stage dialogStage, KindCredit kindCredit) {
        this.kindCredit = kindCredit;
        this.dialogStage = dialogStage;
        nameField.setText(kindCredit.getName());
        conditionField.setText(kindCredit.getConditions());
        rateField.setText(String.valueOf(kindCredit.getRate()));
        termField.setText(String.valueOf(kindCredit.getTerm()));
        okButton.setOnAction((www) -> edit());
    }
}