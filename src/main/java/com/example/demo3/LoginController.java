package com.example.demo3;

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

/**
 * FXML Controller class
 *
 * @author Makklays
 */
public class LoginController {
    @FXML
    private Label alertText;
    @FXML
    private TextField Login;
    @FXML
    private PasswordField Password;
    @FXML
    private Button RegistrationButton;
    @FXML
    private Button LoginButton;

    @FXML
    protected void onRegistrationButtonClick() throws IOException, SQLException {
        alertText.setTextFill(Color.RED);
        alertText.setText("Need registration");

        //AnchorPane apane = new AnchorPane();
        //apane.getChildren().add(new Label("My Text !"));
        //Registration.getScene().setRoot(apane);

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("registration-view.fxml"));
        Scene scene1 = new Scene(fxmlLoader.load(), 800, 500);
        //stage.setTitle("AI BOT for SEO");
        Stage primaryStage = (Stage) RegistrationButton.getScene().getWindow();
        //Registration.getScene().setRoot(scene1.getRoot());
        //primaryStage.getScene().setRoot(scene1.getRoot());
        primaryStage.setScene(scene1);

        //Stage primaryStage;
        //primaryStage.getScene().setRoot(LoginController.registrationScene());
    }

    @FXML
    protected void onEnterButtonClick() throws IOException, SQLException {
        try {
            alertText.setTextFill(Color.BLACK);
            alertText.setText(Login.getText() + " " + Password.getText());

            // opening database connection to MySQL server
            Connection con = DriverManager.getConnection("jdbc:mysql://89.184.93.8:3306/javafx_aibot","u_javafx_aib","Ul1SwXimEQ9W");

            String sql = "SELECT * FROM my_users WHERE login=? AND password=? ";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, Login.getText());
            stmt.setString(2, Password.getText());

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                alertText.setTextFill(Color.GREEN);
                alertText.setText("Authorized");
                System.out.println("User exist in the database");

                // new scene 'layout-view.fxml'
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("layout-view.fxml"));
                Scene scene1 = new Scene(fxmlLoader.load(), 1100, 800);
                Stage primaryStage = (Stage) LoginButton.getScene().getWindow();
                primaryStage.setScene(scene1);

            } else {
                alertText.setTextFill(Color.RED);
                alertText.setText("User didn't found");
                System.out.println("User not exist in the database");
            }

            rs.close();
            stmt.close();
            con.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

