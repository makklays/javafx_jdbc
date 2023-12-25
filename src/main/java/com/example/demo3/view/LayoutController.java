package com.example.demo3.view;

import com.example.demo3.HelloApplication;
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
    private Button StatisticsButton;
    @FXML
    private Button InfoButton;
    @FXML
    private Button ChannelButton;
    @FXML
    private Button CompaniesButton;
    @FXML
    private Button ExitButton;

    @FXML
    protected void onCreditCardButtonClick() throws IOException, SQLException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("credit-card-view.fxml"));
        Scene scene1 = new Scene(fxmlLoader.load(), 1100, 800);
        Stage primaryStage = (Stage) CreditCardButton.getScene().getWindow();
        primaryStage.setScene(scene1);
    }

    @FXML
    protected void onChannelsButtonClick()  throws IOException, SQLException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("channel-view.fxml"));
        Scene scene1 = new Scene(fxmlLoader.load(), 1100, 800);
        Stage primaryStage = (Stage) ChannelButton.getScene().getWindow();
        primaryStage.setScene(scene1);
    }

    @FXML
    protected void onCompaniesButtonClick() throws IOException, SQLException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("company-view.fxml"));
        Scene scene1 = new Scene(fxmlLoader.load(), 1100, 800);
        Stage primaryStage = (Stage) CompaniesButton.getScene().getWindow();
        primaryStage.setScene(scene1);
    }

    @FXML
    protected void onStatisticsButtonClick() throws IOException, SQLException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("statistics-view.fxml"));
        Scene scene1 = new Scene(fxmlLoader.load(), 1100, 800);
        Stage primaryStage = (Stage) StatisticsButton.getScene().getWindow();
        primaryStage.setScene(scene1);
    }

    @FXML
    protected void onInfoButtonClick() throws IOException, SQLException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("info-view.fxml"));
        Scene scene1 = new Scene(fxmlLoader.load(), 1100, 800);
        Stage primaryStage = (Stage) InfoButton.getScene().getWindow();
        primaryStage.setScene(scene1);
    }

    @FXML
    protected void onExitButtonClick() throws IOException, SQLException {
        Stage primaryStage = (Stage) ExitButton.getScene().getWindow();
        primaryStage.close();
    }
}

