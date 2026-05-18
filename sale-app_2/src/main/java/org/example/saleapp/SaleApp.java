package org.example.saleapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SaleApp extends Application {
    public static Stage primaryStage;
    public static Scene employees;
    @Override
    public void start(Stage stage) throws IOException {
        primaryStage = stage;
        employees = createScene("main-view.fxml");
        primaryStage.setMinWidth(1200);
        primaryStage.setMinHeight(675);
        primaryStage.setTitle("Зарплаты работников");
        employees.getStylesheets().add("base-styles.css");
        primaryStage.setScene(employees);
        primaryStage.show();
    }
    private Scene createScene(String name) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(SaleApp.class.getResource(name));
        return new Scene(fxmlLoader.load());
    }
    public static void main(String[] args) {
        launch();
    }
}