package com.example.demo3;

import com.example.demo3.model.CreditCard;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class CreditCardController implements Initializable {
    @FXML
    private TableColumn<CreditCard, Integer> Column1;
    @FXML
    private TableColumn<CreditCard, String> Column2;
    @FXML
    private TableColumn<CreditCard, String> Column3;
    @FXML
    private TableColumn<CreditCard, String> Column4;
    @FXML
    private TableColumn<CreditCard, Float> Column5;
    @FXML
    private TableColumn<CreditCard, String> Column6;
    @FXML
    private TableColumn<CreditCard, Integer> Column7;
    @FXML
    private TableColumn<CreditCard, String> Column8;
    @FXML
    public TableView<CreditCard> CreditCardTable;
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
    private TextField searchText;

    ObservableList<CreditCard> initialData() throws SQLException, ClassNotFoundException {
        // opening database connection to MySQL server
        //Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/makklaysdb", "admin", "admin");
        // or
        DbmsConnection dbmsconnection = DbmsConnection.getInstance();
        Connection con = dbmsconnection.getConnection();

        String sql = "SELECT * FROM credit_cards ORDER BY updated_at DESC ";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        ObservableList<CreditCard> list = FXCollections.observableArrayList();

        while(rs.next()) {
            CreditCard card1 = new CreditCard(rs.getInt("account"), rs.getString("bank"), rs.getString("firstname"), rs.getString("lastname"), rs.getFloat("amount"), rs.getString("currency"), rs.getInt("fromaccount"), rs.getString("phone"));
            System.out.println(card1.getInfo());

            list.add(card1);
        }

        return list;

        /*CreditCard cc1 = new CreditCard(123123,"Nation Bank","Alexander","Kuziv");
        CreditCard cc2 = new CreditCard(124444,"Alfa Bank","Alexander","Kuziv");
        CreditCard cc3 = new CreditCard(125555,"Privat Bank","Alexander","Kuziv");
        return FXCollections.observableArrayList(cc1, cc2, cc3);*/
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Column1.setCellValueFactory(new PropertyValueFactory<>("Account"));
        Column2.setCellValueFactory(new PropertyValueFactory<>("Bank"));
        Column3.setCellValueFactory(new PropertyValueFactory<>("Firstname"));
        Column4.setCellValueFactory(new PropertyValueFactory<>("Lastname"));
        Column5.setCellValueFactory(new PropertyValueFactory<>("Amount"));
        Column6.setCellValueFactory(new PropertyValueFactory<>("Currency"));
        Column7.setCellValueFactory(new PropertyValueFactory<>("Fromaccount"));
        Column8.setCellValueFactory(new PropertyValueFactory<>("Phone"));

        try {
            CreditCardTable.setItems(initialData());
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void SearchButton(ActionEvent event) throws SQLException, ClassNotFoundException {
        //CreditCard card = new CreditCard(12311111,"Nation Bank11","Alexander11","Kuziv11", 100F, "USD", 1111, "+380988705397");
        //System.out.println(card.getInfo());
        //boolean b = CreditCardTable.getItems().add(card);
        //System.out.println("==> " + b);

        //Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/makklaysdb", "admin", "admin");
        // or
        DbmsConnection dbmsconnection = DbmsConnection.getInstance();
        Connection con = dbmsconnection.getConnection();

        String serachtxt = searchText.getText();
        if (!serachtxt.isEmpty()) {
            String sql = "SELECT * FROM credit_cards WHERE account LIKE ? OR amount >= ? ORDER BY amount ASC ";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, "%"+serachtxt+"%");
            stmt.setString(2, serachtxt);
            //System.out.println(stmt.getQueryTimeout()); // get query - sql
            ResultSet rs = stmt.executeQuery();

            ObservableList<CreditCard> list = FXCollections.observableArrayList();

            while(rs.next()) {
                System.out.println("Search: "+ serachtxt + " ==> " +rs.getInt("account")+ " " + rs.getFloat("amount"));

                CreditCard card1 = new CreditCard(rs.getInt("account"), rs.getString("bank"), rs.getString("firstname"), rs.getString("lastname"), rs.getFloat("amount"), rs.getString("currency"), rs.getInt("fromaccount"), rs.getString("phone"));
                list.add(card1);
            }

            CreditCardTable.setItems(list);
        }
    }

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
    }

    @FXML
    public void ExitButton(ActionEvent actionEvent) throws IOException, SQLException {
        Stage primaryStage = (Stage) ExitButton.getScene().getWindow();
        primaryStage.close();
    }
    //
}

