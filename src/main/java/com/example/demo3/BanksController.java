package com.example.demo3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class BanksController {
    @FXML
    private Button CreditCardButton;
    @FXML
    private Button BanksButton;
    @FXML
    private Button ExitButton;

    public void CreditCardButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("credit-card-view.fxml"));
        Scene scene1 = new Scene(fxmlLoader.load(), 1100, 800);
        Stage primaryStage = (Stage) CreditCardButton.getScene().getWindow();
        primaryStage.setScene(scene1);
    }

    public void BanksButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("banks-view.fxml"));
        Scene scene1 = new Scene(fxmlLoader.load(), 1100, 800);
        Stage primaryStage = (Stage) BanksButton.getScene().getWindow();
        primaryStage.setScene(scene1);
    }

    public void SchemesButton(ActionEvent actionEvent) {
    }

    public void ChannelsButton(ActionEvent actionEvent) {
    }

    public void CompaniesButton(ActionEvent actionEvent) {
    }

    public void SettingButton(ActionEvent actionEvent) {
    }

    public void StatisticsButton(ActionEvent actionEvent) {
    }

    public void InfoButton(ActionEvent actionEvent) {
    }

    public void ExitButton(ActionEvent actionEvent) {
        Stage primaryStage = (Stage) ExitButton.getScene().getWindow();
        primaryStage.close();
    }
    //
}
