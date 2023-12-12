package com.example.demo3;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class RegistrationController {
    //@FXML
    //private Label alertText;
    @FXML
    private TextField Login;
    @FXML
    private PasswordField Password;
    @FXML
    private Button buttonLogin;

    @FXML
    protected void onLoginButtonClick() throws IOException {
        //alertText.setTextFill(Color.RED);
        //alertText.setText("Need login");

        //AnchorPane apane = new AnchorPane();
        //apane.getChildren().add(new Label("My Text !"));
        //Registration.getScene().setRoot(apane);

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login-view.fxml"));
        Scene scene1 = new Scene(fxmlLoader.load(), 800, 500);
        //stage.setTitle("AI BOT for SEO");
        Stage primaryStage = (Stage) buttonLogin.getScene().getWindow();
        //Registration.getScene().setRoot(scene1.getRoot());
        //primaryStage.getScene().setRoot(scene1.getRoot());
        primaryStage.setScene(scene1);

        //Stage primaryStage;
        //primaryStage.getScene().setRoot(LoginController.registrationScene());
    }
}
