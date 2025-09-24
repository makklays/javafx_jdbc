package com.techmatrix.javafx_jdbc.view;

import com.techmatrix.javafx_jdbc.configuration.DbmsConnection;
import com.techmatrix.javafx_jdbc.HelloApplication;
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
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.LogManager;

public class RegistrationController {
    @FXML
    public Button RegistrationButton;
    @FXML
    public ToggleGroup group;
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
    private static final Logger logger = Logger.getLogger(RegistrationController.class.getName());

    @FXML
    protected void onLoginButtonClick() throws IOException, SQLException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login-view.fxml"));
        Scene scene1 = new Scene(fxmlLoader.load(), 800, 500);
        Stage primaryStage = (Stage) LoginButton.getScene().getWindow();
        primaryStage.setScene(scene1);
    }

    @FXML
    public void onRegistrationButtonClick(ActionEvent actionEvent) throws IOException, SQLException {

        // init logger from properties
        LogManager.getLogManager().readConfiguration(
            RegistrationController.class.getResourceAsStream("/logging.properties")
        );

        // Logger slf4j
        //Logger logger = LoggerFactory.getLogger(Solution.class);
        logger.info("info - hello world!");
        logger.fine("fine - hello world!");
        logger.log(Level.WARNING, "warning - hello world!", "Trace exception e");
        logger.log(Level.SEVERE, "warning - hello world!", "Trace exception e");

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

                // connection to MySQL server
                DbmsConnection dbmsconnection = DbmsConnection.getInstance();
                Connection con = dbmsconnection.getConnection();

                String sql = "SELECT * FROM users WHERE login=? ";
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setString(1, LoginText.getText());

                alertText.setTextFill(Color.BLACK);
                alertText.setText(LoginText.getText());

                // add info logger
                logger.log(Level.INFO, "search user by login", LoginText.getText());

                ResultSet rs = stmt.executeQuery();

                if (rs.next()) {
                    alertText.setTextFill(Color.RED);
                    alertText.setText("User with this 'Login' exist, try other 'Login'");
                    System.out.println("User exist in the database");
                } else {
                    System.out.println("User not exist in the database. And can inserting in database.");

                    System.out.println("DATA: "+LoginText.getText()+" "+PasswordText.getText()+" "+
                            FirstnameText.getText()+" "+LastnameText.getText()+" "+gender+" "+PhoneText.getText()+" "+
                            EmailText.getText()+" "+CreditCardText.getText());

                    String sql1 = "INSERT INTO users (login, password, firstname, lastname, gender, phone, email, code) "+
                                            " VALUES (?, ?, ?, ?, ?, ?, ?, ?) ";
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

                        // add info logger
                        logger.log(Level.INFO, "You was successfully registered");

                        System.out.println("You was successfully registered");
                    } else {
                        alertText.setTextFill(Color.RED);
                        alertText.setText("Can't insert user in the database");

                        // add info logger
                        logger.log(Level.INFO, "Can't insert user in the database");

                        System.out.println("Can't insert user in the database");
                    }
                }

                rs.close();
                stmt.close();
                con.close();

            } else {
                alertText.setTextFill(Color.RED);
            }
        }
        catch (SQLException e) {
            logger.log(Level.WARNING, "trouble exception", e);
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
        if (!GenderMan.isSelected() && !GenderWoman.isSelected() && proceed == true) {
            alertText.setText("Select gender");
            proceed = false;
        }
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

        return proceed;
    }
}

