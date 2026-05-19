package ru.zelmex.bankapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ru.zelmex.bankapp.model.Client;
import java.io.IOException;
import java.util.List;
public class BankApp extends Application {
    public static Stage primaryStage;
    public static Scene clients;
    public static Scene kindCredits;

    @Override
    public void start(Stage stage) throws IOException {
        primaryStage = stage;
        clients = createScene("client-view.fxml");
        kindCredits = createScene("kind-credit-view.fxml");
        primaryStage.setMinWidth(1200);
        primaryStage.setMinHeight(675);
        primaryStage.setTitle("Клиенты");
        clients.getStylesheets().add("base-styles.css");
        kindCredits.getStylesheets().add("base-styles.css");
        primaryStage.setScene(clients);
        primaryStage.show();
    }

    private Scene createScene(String name) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(BankApp.class.getResource(name));
        return new Scene(fxmlLoader.load());
    }

    public static void main(String[] args) {
        launch();
    }
}