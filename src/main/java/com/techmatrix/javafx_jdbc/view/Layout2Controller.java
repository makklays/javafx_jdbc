package com.techmatrix.javafx_jdbc.view;

import com.techmatrix.javafx_jdbc.HelloApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.*;

public class Layout2Controller {
    @FXML
    private AnchorPane leftContentPane;
    @FXML
    private AnchorPane rightContentPane;

    @FXML
    private Button TasksButton;
    @FXML
    private Button StatisticsButton;
    @FXML
    private Button InfoButton;
    @FXML
    private Button ExitButton;

    @FXML
    private void initialize() {
        // Устанавливаем контейнер в Navigator
        Navigator.setContentPane(rightContentPane);

        // Загружаем стартовую страницу
        Navigator.load("tasks2.fxml");
    }

    @FXML
    protected void onTasksButton() throws IOException, SQLException {
        Navigator.load("tasks2.fxml");
    }

    @FXML
    protected void onStatisticsButton() throws IOException, SQLException {
        Navigator.load("statistics2.fxml");
    }

    @FXML
    protected void onInfoButton() throws IOException, SQLException {
        Navigator.load("info2.fxml");
    }

    @FXML
    protected void onExitButton() throws IOException, SQLException {
        Stage primaryStage = (Stage) ExitButton.getScene().getWindow();
        primaryStage.close();
    }
}

