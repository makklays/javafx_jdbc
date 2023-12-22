package com.example.demo3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class RegistrationController {
    @FXML
    private Label alertText;
    @FXML
    private TextField LoginText;
    @FXML
    private PasswordField PasswordText;
    @FXML
    private TextField FirstnameText;
    @FXML
    private TextField LastnameText;
    @FXML
    private TextField PhoneText;
    @FXML
    private TextField EmailText;
    @FXML
    private Group Group;
    @FXML
    private RadioButton GenderMan;
    @FXML
    private RadioButton GenderWoman;
    @FXML
    private TextField CreditCardText;
    @FXML
    private Button LoginButton;

    @FXML
    protected void onLoginButtonClick() throws IOException, SQLException {
        //AnchorPane apane = new AnchorPane();
        //apane.getChildren().add(new Label("My Text !"));
        //Registration.getScene().setRoot(apane);

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login-view.fxml"));
        Scene scene1 = new Scene(fxmlLoader.load(), 800, 500);
        //stage.setTitle("AI BOT for SEO");
        Stage primaryStage = (Stage) LoginButton.getScene().getWindow();
        //Registration.getScene().setRoot(scene1.getRoot());
        //primaryStage.getScene().setRoot(scene1.getRoot());
        primaryStage.setScene(scene1);

        //Stage primaryStage; // get scene
        //primaryStage.getScene().setRoot(LoginController.registrationScene());
    }

    @FXML
    public void onRegistrationButtonClick(ActionEvent actionEvent) throws IOException, SQLException {
        try {
            boolean connect = validate_form();
            if (connect) {
                String gender = "";
                if (GenderMan.isSelected()) {
                    gender = GenderMan.getText();
                }
                if (GenderWoman.isSelected()) {
                    gender = GenderWoman.getText();
                }

                // opening database connection to MySQL server
                //Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/makklaysdb", "admin", "admin");
                // or
                DbmsConnection dbmsconnection = DbmsConnection.getInstance();
                Connection con = dbmsconnection.getConnection();

                String sql = "SELECT * FROM users WHERE login=? ";
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setString(1, LoginText.getText());

                alertText.setTextFill(Color.BLACK);
                alertText.setText(LoginText.getText());

                ResultSet rs = stmt.executeQuery();

                if (rs.next()) {
                    alertText.setTextFill(Color.RED);
                    alertText.setText("User with this 'Login' exist, try other 'Login'");
                    System.out.println("User exist in the database");
                } else {
                    System.out.println("User not exist in the database. And can inserting in database.");

                    System.out.println("DATA: "+LoginText.getText()+" "+PasswordText.getText()+" "+FirstnameText.getText()+" "+LastnameText.getText()+" "+gender+" "+PhoneText.getText()+" "+EmailText.getText()+" "+CreditCardText.getText());

                    String sql1 = "INSERT INTO users (login, password, firstname, lastname, gender, phone, email, code) VALUES (?, ?, ?, ?, ?, ?, ?, ?) ";
                    PreparedStatement stmt1 = con.prepareStatement(sql1);
                    stmt1.setString(1, LoginText.getText());
                    stmt1.setString(2, PasswordText.getText());
                    stmt1.setString(3, FirstnameText.getText());
                    stmt1.setString(4, LastnameText.getText());
                    stmt1.setString(5, gender);
                    stmt1.setString(6, PhoneText.getText());
                    stmt1.setString(7, EmailText.getText());
                    stmt1.setString(8, CreditCardText.getText());

                    int i = stmt1.executeUpdate();
                    if (i > 0) {
                        alertText.setTextFill(Color.GREEN);
                        alertText.setText("You was successfully registered");

                        System.out.println("You was successfully registered");
                    } else {
                        alertText.setTextFill(Color.RED);
                        alertText.setText("Can't insert user in the database");

                        System.out.println("Can't insert user in the database");
                    }

                    // or
                    //String sql1 = "INSERT INTO users (login, password, firstname, lastname, gender, phone, email, code) VALUES ('makklays5', 'password', 'Alexander', 'Kuziv', 'man', '+380988705397', 'makklays@gmail.com', '1111222233334444')";
                    //Statement stmt1 = con.createStatement();
                    //ResultSet rs1 = stmt1.executeQuery();
                }

                rs.close();
                stmt.close();
                con.close();

            } else {
                alertText.setTextFill(Color.RED);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean validate_form() {
        boolean proceed = true;
        if (LoginText.getText().isEmpty() && proceed == true) {
            alertText.setText("Enter login");
            proceed = false;
        }
        if (PasswordText.getText().isEmpty() && proceed == true) {
            alertText.setText("Enter password");
            proceed = false;
        }
        if (FirstnameText.getText().isEmpty() && proceed == true) {
            alertText.setText("Enter first name");
            proceed = false;
        }
        if (LastnameText.getText().isEmpty() && proceed == true) {
            alertText.setText("Enter last name");
            proceed = false;
        }
        if (GenderMan.isSelected() == false && GenderWoman.isSelected() == false && proceed == true) {
            alertText.setText("Select gender");
            proceed = false;
        }
        /*if (chk1.isSelected() == false && chk2.isSelected() == false && chk3.isSelected() == false && proceed == true) {
            errorlbl.setText("Select post");
            proceed = false;
        }*/
        if (PhoneText.getText().isEmpty() && proceed == true) {
            alertText.setText("Enter phone");
            proceed = false;
        }
        if (EmailText.getText().isEmpty() && proceed == true) {
            alertText.setText("Enter email");
            proceed = false;
        }
        if (CreditCardText.getText().isEmpty() && proceed == true) {
            alertText.setText("Enter your Credit Card");
            proceed = false;
        }
        /*if (city.getValue() == null && proceed == true) {
            errorlbl.setText("Select city");
            proceed = false;
        }*/

        return proceed;
    }
}

