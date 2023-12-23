package com.example.demo3.view;

import com.example.demo3.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.SQLException;

public class BanksController {
    @FXML
    private Button CreditCardButton;
    @FXML
    private Button BanksButton;
    @FXML
    private Button SchemesButton;
    @FXML
    private Button ChannelsButton;
    @FXML
    private Button CompaniesButton;
    @FXML
    private Button SettingButton;
    @FXML
    private Button StatisticsButton;
    @FXML
    private Button InfoButton;
    @FXML
    private Button ExitButton;

    @FXML
    public void CreditCardButton(ActionEvent actionEvent) throws IOException, SQLException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("credit-card-view.fxml"));
        Scene scene1 = new Scene(fxmlLoader.load(), 1100, 800);
        Stage primaryStage = (Stage) CreditCardButton.getScene().getWindow();
        primaryStage.setScene(scene1);
    }

    @FXML
    public void BanksButton(ActionEvent actionEvent) throws IOException, SQLException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("banks-view.fxml"));
        Scene scene1 = new Scene(fxmlLoader.load(), 1100, 800);
        Stage primaryStage = (Stage) BanksButton.getScene().getWindow();
        primaryStage.setScene(scene1);
    }

    @FXML
    public void SchemesButton(ActionEvent actionEvent) throws IOException, SQLException {
    }

    @FXML
    public void ChannelsButton(ActionEvent actionEvent) throws IOException, SQLException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("channel-view.fxml"));
        Scene scene1 = new Scene(fxmlLoader.load(), 1100, 800);
        Stage primaryStage = (Stage) ChannelsButton.getScene().getWindow();
        primaryStage.setScene(scene1);
    }

    @FXML
    public void CompaniesButton(ActionEvent actionEvent) throws IOException, SQLException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("company-view.fxml"));
        Scene scene1 = new Scene(fxmlLoader.load(), 1100, 800);
        Stage primaryStage = (Stage) CompaniesButton.getScene().getWindow();
        primaryStage.setScene(scene1);
    }

    @FXML
    public void SettingButton(ActionEvent actionEvent) throws IOException, SQLException {
    }

    @FXML
    public void StatisticsButton(ActionEvent actionEvent) throws IOException, SQLException {
    }

    @FXML
    public void InfoButton(ActionEvent actionEvent) throws IOException, SQLException {
    }

    @FXML
    public void ExitButton(ActionEvent actionEvent) throws IOException, SQLException {
        Stage primaryStage = (Stage) ExitButton.getScene().getWindow();
        primaryStage.close();
    }
    //
}

