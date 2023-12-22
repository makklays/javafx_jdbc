package com.example.demo3;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.LogManager;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

/**
 * FXML Controller class
 *
 * @author Makklays
 */
public class LoginController {
    @FXML
    private Label alertText;
    @FXML
    private TextField login;
    @FXML
    private PasswordField password;
    @FXML
    private Button registrationButton;
    @FXML
    private Button loginButton;
    private static final Logger logger = Logger.getLogger("my logger");

    @FXML
    protected void onRegistrationButtonClick() throws IOException, SQLException {
        alertText.setTextFill(Color.RED);
        alertText.setText("Need registration");

        logger.info("Need registration");

        //AnchorPane apane = new AnchorPane();
        //apane.getChildren().add(new Label("My Text !"));
        //Registration.getScene().setRoot(apane);

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("registration-view.fxml"));
        Scene scene1 = new Scene(fxmlLoader.load(), 800, 500);
        //stage.setTitle("AI BOT for SEO");
        Stage primaryStage = (Stage) registrationButton.getScene().getWindow();
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
            alertText.setText(login.getText() + " " + password.getText());

            // log
            logger.info("login ==> " + login.getText() + " password ==> " + password.getText());

            // opening database connection to MySQL server
            //Connection con = DriverManager.getConnection("jdbc:mariadb://89.184.93.8:3306/javafx_aibot?user=u_javafx_aib&password=Ul1SwXimEQ9W");
            //Connection con = DriverManager.getConnection("jdbc:mysql://vs3092.mirohost.net:3306/javafx_aibot", "u_javafx_aib", "Ul1SwXimEQ9W");
            //Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/makklaysdb", "admin", "admin");
            // or
            //ClassSingleton classSingleton1 = ClassSingleton.getInstance();
            DbmsConnection dbmsconnection = DbmsConnection.getInstance();
            Connection con = dbmsconnection.getConnection();

            String sql = "SELECT * FROM users WHERE login=? AND password=? ";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, login.getText());
            stmt.setString(2, password.getText());

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                alertText.setTextFill(Color.GREEN);
                alertText.setText("Authorized");
                System.out.println("User exist in the database");

                // log
                logger.info("User exist in the database");
                if (logger.isLoggable(Level.FINE)) {
                    logger.fine("Authorized");
                }

                // new scene 'layout-view.fxml'
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("layout-view.fxml"));
                Scene scene1 = new Scene(fxmlLoader.load(), 1100, 800);
                Stage primaryStage = (Stage) loginButton.getScene().getWindow();
                primaryStage.setScene(scene1);

            } else {
                alertText.setTextFill(Color.RED);
                alertText.setText("User didn't found");
                System.out.println("User not exist in the database");

                logger.info("User not exist in the database");
            }

            rs.close();
            stmt.close();
            con.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
            // log
            logger.log(Level.WARNING, "SQLException :", e);
        } catch (IOException | ClassNotFoundException e) {
            // log
            logger.log(Level.WARNING, "IOException | ClassNotFoundException :", e);
            throw new RuntimeException(e);
        }
    }
}

