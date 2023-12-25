package com.example.demo3.view;

import com.example.demo3.HelloApplication;

import com.example.demo3.dao.ChannelEntity;
import com.example.demo3.utils.HibernateSessionFactory;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.hibernate.Session;

import java.io.IOException;
import java.sql.SQLException;

public class InfoController {
    @FXML
    private Button CreditCardButton;
    @FXML
    private Button ChannelsButton;
    @FXML
    private Button CompaniesButton;
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
    public void StatisticsButton(ActionEvent actionEvent) throws IOException, SQLException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("statistics-view.fxml"));
        Scene scene1 = new Scene(fxmlLoader.load(), 1100, 800);
        Stage primaryStage = (Stage) StatisticsButton.getScene().getWindow();
        primaryStage.setScene(scene1);
    }

    @FXML
    public void InfoButton(ActionEvent actionEvent) throws IOException, SQLException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("info-view.fxml"));
        Scene scene1 = new Scene(fxmlLoader.load(), 1100, 800);
        Stage primaryStage = (Stage) InfoButton.getScene().getWindow();
        primaryStage.setScene(scene1);

        //--- Hibernate --------------
        System.out.println("Hibernate tutorial");

        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();

        ChannelEntity channelEntity = new ChannelEntity();
        channelEntity.setTitle("Nick");
        channelEntity.setDescription("VN");
        //channelEntity.setBirthDate(new java.util.Date());

        session.save(channelEntity);
        session.getTransaction().commit();
        session.close();
        //--- END Hibernate ----------
    }

    @FXML
    public void ExitButton(ActionEvent actionEvent) throws IOException, SQLException {
        Stage primaryStage = (Stage) ExitButton.getScene().getWindow();
        primaryStage.close();
    }
    //
}
