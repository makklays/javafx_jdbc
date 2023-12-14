package com.example.demo3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class LayoutController {
    @FXML
    private Button CreditCardButton;
    @FXML
    private Button BanksButton;
    @FXML
    private Button ExitButton;

    @FXML
    protected void onCreditCardButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("credit-card-view.fxml"));
        Scene scene1 = new Scene(fxmlLoader.load(), 1100, 800);
        Stage primaryStage = (Stage) CreditCardButton.getScene().getWindow();
        primaryStage.setScene(scene1);
    }
    @FXML
    protected void onBanksButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("banks-view.fxml"));
        Scene scene1 = new Scene(fxmlLoader.load(), 1100, 800);
        Stage primaryStage = (Stage) BanksButton.getScene().getWindow();
        primaryStage.setScene(scene1);
    }

    @FXML
    protected void onSchemesButtonClick() throws IOException {
        /*FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("banks-view.fxml"));
        Scene scene1 = new Scene(fxmlLoader.load(), 1100, 800);
        Stage primaryStage = (Stage) BanksButton.getScene().getWindow();
        primaryStage.setScene(scene1);*/
    }

    @FXML
    protected void onChannelsButtonClick() throws IOException {
        /*FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("banks-view.fxml"));
        Scene scene1 = new Scene(fxmlLoader.load(), 1100, 800);
        Stage primaryStage = (Stage) BanksButton.getScene().getWindow();
        primaryStage.setScene(scene1);*/
    }

    @FXML
    protected void onCompaniesButtonClick() throws IOException {
        /*FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("banks-view.fxml"));
        Scene scene1 = new Scene(fxmlLoader.load(), 1100, 800);
        Stage primaryStage = (Stage) BanksButton.getScene().getWindow();
        primaryStage.setScene(scene1);*/
    }

    @FXML
    protected void onSettingButtonClick() throws IOException {
        /*FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("banks-view.fxml"));
        Scene scene1 = new Scene(fxmlLoader.load(), 1100, 800);
        Stage primaryStage = (Stage) BanksButton.getScene().getWindow();
        primaryStage.setScene(scene1);*/
    }

    @FXML
    protected void onStatisticsButtonClick() throws IOException {
        /*FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("banks-view.fxml"));
        Scene scene1 = new Scene(fxmlLoader.load(), 1100, 800);
        Stage primaryStage = (Stage) BanksButton.getScene().getWindow();
        primaryStage.setScene(scene1);*/
    }

    @FXML
    protected void onInfoButtonClick() throws IOException {
        /*FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("banks-view.fxml"));
        Scene scene1 = new Scene(fxmlLoader.load(), 1100, 800);
        Stage primaryStage = (Stage) BanksButton.getScene().getWindow();
        primaryStage.setScene(scene1);*/
    }

    @FXML
    protected void onExitButtonClick() throws IOException {
        Stage primaryStage = (Stage) ExitButton.getScene().getWindow();
        primaryStage.close();
    }
}
