package com.example.demo3;

import com.example.demo3.dao.UserEntity;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

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
            AlertText.setTextFill(Color.BLACK);
            AlertText.setText(Login.getText() + " " + Password.getText());

            // log
            logger.info("login ==> " + Login.getText() + " password ==> " + Password.getText());

            //--- hibernate -----------
            UserEntity Usr = new UserEntity();
            // Usr.setId(111);
            Usr.setLogin("MakKlays");
            Usr.setFirstname("Alexanderrrr");
            Usr.setLastname("Kuzivvvvv");
            Usr.setPassword("12345678");
            Usr.setPhone("+380988705397");
            Usr.setEmail("makklays@gmail.com");
            Usr.setCity("CITY 22");
            Usr.setGender("man");
            Usr.setCode("1111222233334444");
            Usr.setIsAuth(false);

            /*
            Configuration conf = new Configuration().configure;
            conf.addAnnotatedClass(UserEntity.class);
            StandardServiceRegistryBuilder sBilder = new StandardServiceRegistryBuilder()
                    .applySettings(conf.getProperties());
            SessionFactory sf = conf.buildSessionFactory(sBilder.build());
            // create
            Session sessionCreate = sf.openSession();
            Transaction trCreate = sessionCreate.beginTransaction; // Начало транзакции
            sessionCreate.save(Usr);
            trCreate.commit();
            sessionCreate.close(); // Завершение транзакции
            // read
            Session sessionRead = sf.openSession();
            Transaction trRead = sessionRead.beginTransaction();
            Student usr1 = sessionRead.find(UserEntity.class, o:1);
            System.out.println(usr1.toString());
            trRead.commit();
            sessionCreate.close();
            */
            //--- end hibernate ----------

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

