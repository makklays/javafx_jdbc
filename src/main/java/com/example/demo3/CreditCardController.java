package com.example.demo3;

import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class CreditCardController {
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
    private Button BanksButton;
    @FXML
    private Button ExitButton;

    @FXML
    public void CreditCardButton(ActionEvent actionEvent) throws IOException, SQLException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("credit-card-view.fxml"));
        Scene scene1 = new Scene(fxmlLoader.load(), 1100, 800);
        Stage primaryStage = (Stage) CreditCardButton.getScene().getWindow();
        primaryStage.setScene(scene1);

        //CreditCardTable.setEditable(false);

        // opening database connection to MySQL server
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/makklaysdb","admin","admin");

        String sql = "SELECT * FROM my_credit_cards ORDER BY updated_at DESC ";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        ObservableList<CreditCard> list = FXCollections.observableArrayList(new CreditCard("National Bank", "Alexander", "Kuziv"), new CreditCard("Private Bank", "Alexander", "Kuziv"));
        //CreditCardTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        //CreditCardTable.getSelectionModel().setCellSelectionEnabled(true);

        //Column1.setCellValueFactory(new PropertyValueFactory<>("account"));
        Column2.setCellValueFactory(new PropertyValueFactory<>("bank"));
        Column3.setCellValueFactory(new PropertyValueFactory<>("firstname"));
        Column4.setCellValueFactory(new PropertyValueFactory<>("lastname"));
        //Column5.setCellValueFactory(new PropertyValueFactory<>("amount"));
        //Column6.setCellValueFactory(new PropertyValueFactory<>("currency"));
        //Column7.setCellValueFactory(new PropertyValueFactory<>("from_account"));
        //Column8.setCellValueFactory(new PropertyValueFactory<>("phone"));

        //CreditCardTable.getColumns().addAll(Column1, Column2, Column3, Column4, Column5, Column6, Column7, Column8);

        //List<CreditCards> list = new ArrayList<>();
        /*while(rs.next()) {
            //String column3 = rs.getString(3);
            System.out.println(rs.getInt("account")+" "+rs.getString("bank")+" "+rs.getString("firstname")+" "+rs.getString("lastname")+" "+rs.getFloat("amount")+" "+rs.getString("currency")+" "+rs.getInt("from_account")+" "+rs.getString("phone"));

            list.add(new CreditCard(rs.getString("bank"), rs.getString("firstname"), rs.getString("lastname")));

            //list.add(new CreditCard(rs.getInt("account"), rs.getString("bank"), rs.getString("firstname"),rs.getString("lastname"), rs.getFloat("amount"), rs.getString("currency"),rs.getInt("from_account"), rs.getString("phone")));
        }*/

        System.out.println(list.toString());

        CreditCardTable.setItems(list);

        if (CreditCardTable.getColumns().isEmpty()) {
            System.out.println("Table is empty");
        } else {
            System.out.println("Table is not empty");
        }

        //ObservableList<> creditCards =
        //CreditCardTable.setItems();
    }

    @FXML
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

    public static class CreditCard {
        private SimpleIntegerProperty account;
        private final SimpleStringProperty bank;
        private final SimpleStringProperty firstname;
        private final SimpleStringProperty lastname;
        private SimpleFloatProperty amount;
        private SimpleStringProperty currency;
        private SimpleIntegerProperty from_account;
        private SimpleStringProperty phone;
        private SimpleIntegerProperty credit_card;
        private SimpleStringProperty created_at;
        private SimpleStringProperty updated_at;

        private CreditCard(String bank, String fname, String lname) {
            this.bank = new SimpleStringProperty(bank);
            this.firstname = new SimpleStringProperty(fname);
            this.lastname = new SimpleStringProperty(lname);
        }
        private CreditCard(Integer acc, String bank, String fname, String lname, Float amount, String currency, Integer from_account, String phone) {
            this.account = new SimpleIntegerProperty(acc);
            this.bank = new SimpleStringProperty(bank);
            this.firstname = new SimpleStringProperty(fname);
            this.lastname = new SimpleStringProperty(lname);
            this.amount = new SimpleFloatProperty(amount);
            this.currency = new SimpleStringProperty(currency);
            this.from_account = new SimpleIntegerProperty(from_account);
            this.phone = new SimpleStringProperty(phone);
            //this.updated_at = new SimpleStringProperty(updated_at);
        }

        private CreditCard(Integer acc, String bank, String fname, String lname, Float amount, String currency, Integer from_account, String phone, Integer credit_card) {
            this.account = new SimpleIntegerProperty(acc);
            this.bank = new SimpleStringProperty(bank);
            this.firstname = new SimpleStringProperty(fname);
            this.lastname = new SimpleStringProperty(lname);
            this.amount = new SimpleFloatProperty(amount);
            this.currency = new SimpleStringProperty(currency);
            this.from_account = new SimpleIntegerProperty(from_account);
            this.phone = new SimpleStringProperty(phone);
            this.credit_card = new SimpleIntegerProperty(credit_card);
        }

        public Integer getAccount() {
            return account.get();
        }
        public void setAccount(Integer acc) {
            account.set(acc);
        }

        public String getBank() {
            return bank.get();
        }
        public void setBank(String bnk) {
            bank.set(bnk);
        }

        public String getFirstname() {
            return firstname.get();
        }
        public void setFirstname(String fname) {
            firstname.set(fname);
        }

        public String getLastname() {
            return lastname.get();
        }
        public void setLastname(String lname) {
            lastname.set(lname);
        }

        public Float getAmount() {
            return amount.get();
        }
        public void setAmount(Float amnt) {
            amount.set(amnt);
        }

        public String getCurrency() {
            return currency.get();
        }
        public void setCurrency(String curr) {
            currency.set(curr);
        }

        public Integer getFromAccount() {
            return from_account.get();
        }
        public void setFromAccount(Integer curr) {
            from_account.set(curr);
        }

        public String getPhone() {
            return phone.get();
        }
        public void setPhone(String pho) {
            phone.set(pho);
        }

        public Integer getCreditCard() {
            return credit_card.get();
        }
        public void setCreditCard(Integer ccard) {
            credit_card.set(ccard);
        }
    }
}

/******************************
 CREATE TABLE `my_credit_cards` (
 `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
 `account` int(25) NOT NULL,
 `bank` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
 `firstname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
 `lastname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
 `amount` float(25) NOT NULL,
 `currency` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
 `from_account` int(25) NOT NULL,
 `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
 `credit_card` varchar(25) DEFAULT NULL,
 `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
 `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
 PRIMARY KEY (`id`),
 KEY `account` (`account`),
 KEY `bank` (`bank`),
 KEY `firstname` (`firstname`),
 KEY `lastname` (`lastname`),
 KEY `currency` (`currency`),
 KEY `from_account` (`from_account`),
 KEY `credit_card` (`credit_card`),
 KEY `phone` (`phone`)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin
 *******************************/
