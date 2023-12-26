package com.example.demo3.view;

import com.example.demo3.configuration.DbmsConnection;
import com.example.demo3.HelloApplication;
import com.example.demo3.model.Channel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class ChannelController implements Initializable {
    @FXML
    private Button CreditCardButton;
    @FXML
    private Button ChannelsButton;
    @FXML
    private Button CompaniesButton;
    @FXML
    private Button UploadDatasButton;
    @FXML
    private Button StatisticsButton;
    @FXML
    private Button InfoButton;
    @FXML
    private Button AddChannelButton;
    @FXML
    private Button ListChannelsButton;
    @FXML
    private Button AddAddChannelButton;
    @FXML
    private Button CancelAddChannelButton;
    @FXML
    private TextField TitleText;
    @FXML
    private TextArea DescrArea;
    @FXML
    private Label AlertText;

    @FXML
    private TableColumn<Channel, Integer> Column1;
    @FXML
    private TableColumn<Channel, String> Column2;
    @FXML
    private TableColumn<Channel, String> Column3;
    @FXML
    private TableView<Channel> ChannelsTable;
    @FXML
    private Button ExitButton;

    ObservableList<Channel> initialData() throws SQLException, ClassNotFoundException {
        DbmsConnection dbmsconnection = DbmsConnection.getInstance();
        Connection con = dbmsconnection.getConnection();

        String sql = "SELECT * FROM channels ORDER BY title ASC ";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        ObservableList<Channel> list = FXCollections.observableArrayList();

        while(rs.next()) {
            Channel channel = new Channel(rs.getInt("id"), rs.getString("title"), rs.getString("description"));
            list.add(channel);
        }

        return list;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (ChannelsTable != null) {
            Column1.setCellValueFactory(new PropertyValueFactory<>("Id"));
            Column2.setCellValueFactory(new PropertyValueFactory<>("Title"));
            Column3.setCellValueFactory(new PropertyValueFactory<>("Description"));
            try {
                ChannelsTable.setItems(initialData());
            } catch (SQLException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @FXML
    public void onAddAddChannelButton(ActionEvent actionEvent) throws IOException, SQLException, ClassNotFoundException {
        boolean connect = validate_form();
        if (connect) {
            // add channel to database
            DbmsConnection dbmsconnection = DbmsConnection.getInstance();
            Connection con = dbmsconnection.getConnection();

            String sql1 = "INSERT INTO channels (title, description) VALUES (?, ?) ";
            PreparedStatement stmt1 = con.prepareStatement(sql1);
            stmt1.setString(1, TitleText.getText());
            stmt1.setString(2, DescrArea.getText());

            int i = stmt1.executeUpdate();
            if (i > 0) {
                AlertText.setTextFill(Color.GREEN);
                AlertText.setText("You inserted successfully");

                System.out.println("You inserted successfully");
            } else {
                AlertText.setTextFill(Color.RED);
                AlertText.setText("Can't insert channel in the database");

                System.out.println("Can't insert channel in the database");
            }

            // Out
            System.out.println("Channel ==> " + TitleText.getText() + " --- " + DescrArea.getText());

            // redirect to list of channels
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("channel-view.fxml"));
            Scene scene1 = new Scene(fxmlLoader.load(), 1100, 800);
            Stage primaryStage = (Stage) AddAddChannelButton.getScene().getWindow();
            primaryStage.setScene(scene1);
        } else {
            AlertText.setTextFill(Color.RED);
        }
    }

    public boolean validate_form() {
        boolean proceed = true;
        if (TitleText.getText().isEmpty() && proceed == true) {
            AlertText.setText("Enter Title");
            proceed = false;
        }
        if (DescrArea.getText().isEmpty() && proceed == true) {
            AlertText.setText("Enter description");
            proceed = false;
        }

        return proceed;
    }

    @FXML
    public void onCancelAddChannelButton(ActionEvent actionEvent) throws IOException, SQLException {
        // redirect to list of channels
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("channel-view.fxml"));
        Scene scene1 = new Scene(fxmlLoader.load(), 1100, 800);
        Stage primaryStage = (Stage) CancelAddChannelButton.getScene().getWindow();
        primaryStage.setScene(scene1);
    }

    @FXML
    public void onAddChannelButton(ActionEvent actionEvent) throws IOException, SQLException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("add-channel-view.fxml"));
        Scene scene1 = new Scene(fxmlLoader.load(), 1100, 800);
        Stage primaryStage = (Stage) AddChannelButton.getScene().getWindow();
        primaryStage.setScene(scene1);
    }

    @FXML
    public void onListChannelsButton(ActionEvent actionEvent) throws IOException, SQLException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("channel-view.fxml"));
        Scene scene1 = new Scene(fxmlLoader.load(), 1100, 800);
        Stage primaryStage = (Stage) ListChannelsButton.getScene().getWindow();
        primaryStage.setScene(scene1);
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
        System.out.println("==> channel click ");

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("channel-view.fxml"));
        Scene scene1 = new Scene(fxmlLoader.load(), 1100, 800);
        Stage primaryStage = (Stage) ChannelsButton.getScene().getWindow();
        primaryStage.setScene(scene1);
    }

    @FXML
    public void CompaniesButton(ActionEvent actionEvent) throws IOException, SQLException {
        System.out.println("==> company click ");

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("company-view.fxml"));
        Scene scene1 = new Scene(fxmlLoader.load(), 1100, 800);
        Stage primaryStage = (Stage) CompaniesButton.getScene().getWindow();
        primaryStage.setScene(scene1);
    }

    @FXML
    public void UploadDatasButton(ActionEvent actionEvent) throws IOException, SQLException {
        System.out.println("==> upload datas click ");

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("upload-datas-view.fxml"));
        Scene scene1 = new Scene(fxmlLoader.load(), 1100, 800);
        Stage primaryStage = (Stage) UploadDatasButton.getScene().getWindow();
        primaryStage.setScene(scene1);
    }

    @FXML
    public void StatisticsButton(ActionEvent actionEvent) throws IOException, SQLException {
        System.out.println("==> statistics click ");

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("statistics-view.fxml"));
        Scene scene1 = new Scene(fxmlLoader.load(), 1100, 800);
        Stage primaryStage = (Stage) StatisticsButton.getScene().getWindow();
        primaryStage.setScene(scene1);
    }

    @FXML
    public void InfoButton(ActionEvent actionEvent) throws IOException, SQLException {
        System.out.println("==> info click ");

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

