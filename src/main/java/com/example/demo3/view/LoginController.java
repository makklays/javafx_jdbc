package com.example.demo3.view;

import com.example.demo3.HelloApplication;
import com.example.demo3.configuration.DbmsConnection;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * FXML Controller class
 *
 * @author Makklays
 */
public class LoginController {
    @FXML
    private Label AlertText;
    @FXML
    private TextField Login;
    @FXML
    private PasswordField Password;
    @FXML
    private Button RegistrationButton;
    @FXML
    private Button LoginButton;
    private static final Logger logger = Logger.getLogger("my logger");

    @FXML
    protected void onRegistrationButtonClick() throws IOException, SQLException {
        AlertText.setTextFill(Color.RED);
        AlertText.setText("Need registration");

        logger.info("Need registration");

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("registration-view.fxml"));
        Scene scene1 = new Scene(fxmlLoader.load(), 800, 500);
        Stage primaryStage = (Stage) RegistrationButton.getScene().getWindow();
        primaryStage.setScene(scene1);
    }

    @FXML
    protected void onEnterButtonClick() throws IOException, SQLException {
        AlertText.setTextFill(Color.BLACK);
        AlertText.setText(Login.getText() + " " + Password.getText());

        // log
        logger.info("login ==> " + Login.getText() + " password ==> " + Password.getText());

        //--- Hibernate example insert -----------
        /*Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();

        UserEntity user = new UserEntity();
        user.setLogin("MakKlays");
        user.setFirstname("Alexanderrrr");
        user.setLastname("Kuzivvvvv");
        user.setPassword("12345678");
        user.setPhone("+380988705397");
        user.setEmail("makklays@gmail.com");
        user.setCity("CITY 22");
        user.setGender("man");
        user.setCode("1111222233334444");
        user.setIsAuth(false);

        session.save(user);
        session.getTransaction().commit();
        session.close();*/
        //--- END Hibernate ----------

        // connection to MySQL server
        DbmsConnection dbmsconnection = DbmsConnection.getInstance();
        Connection con = dbmsconnection.getConnection();

        String sql = "SELECT * FROM users WHERE login=? AND password=? ";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, Login.getText());
        stmt.setString(2, Password.getText());

        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            AlertText.setTextFill(Color.GREEN);
            AlertText.setText("Authorized");
            System.out.println("User exist in the database");

            // log
            logger.info("User exist in the database");
            if (logger.isLoggable(Level.FINE)) {
                logger.fine("Authorized");
            }

            // Add user to session - user_id
            com.example.demo3.utils.Session.getInstance().setUserId(1L);

            // new scene 'layout-view.fxml'
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("layout-view.fxml"));
            Scene scene1 = new Scene(fxmlLoader.load(), 1100, 800);
            Stage primaryStage = (Stage) LoginButton.getScene().getWindow();
            primaryStage.setScene(scene1);

        } else {
            AlertText.setTextFill(Color.RED);
            AlertText.setText("User didn't found");
            System.out.println("User not exist in the database");

            logger.info("User not exist in the database");
        }

        rs.close();
        stmt.close();
        con.close();
    }
}

