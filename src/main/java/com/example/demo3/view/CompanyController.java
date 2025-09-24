package com.example.demo3.view;

import com.example.demo3.HelloApplication;
import com.example.demo3.configuration.DbmsConnection;
import com.example.demo3.model.Channel;
import com.example.demo3.model.Company;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
import javafx.stage.FileChooser;

public class CompanyController implements Initializable {
    @FXML
    public Label TextAlert;
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
    private Button TasksButton;
    @FXML
    private Button ExitButton;
    @FXML
    private Button AddCompanyButton;

    @FXML
    private Button AddAddCompanyButton;
    @FXML
    private Button CancelAddCompanyButton;
    @FXML
    private Label AlertText;

    @FXML
    private TableColumn<Company, Integer> Column1;
    @FXML
    private TableColumn<Company, String> Column2;
    @FXML
    private TableColumn<Company, Integer> Column3;
    @FXML
    private TableColumn<Company, Integer> Column4;
    @FXML
    private TableColumn<Company, Integer> Column5;
    @FXML
    private TableColumn<Company, Integer> Column6;
    @FXML
    private TableView<Company> CompaniesTable;

    @FXML
    private Button AddFileButton;
    @FXML
    private Button UploadFileButton;

    @FXML
    private TextField TitleText;
    @FXML
    private ComboBox<String> ChannelBox;
    @FXML
    private Spinner<Integer> CountSubscribeSpiner;
    @FXML
    private Slider CountSubscribeSlider;
    @FXML
    private Spinner<Integer> SpeedFromSpinner;
    @FXML
    private Spinner<Integer> SpeedToSpinner;
    @FXML
    private Spinner<Integer> ProcentOffSpinner;
    @FXML
    private CheckBox ViewCheckbox;
    @FXML
    private Slider ProcentOffSlider;
    @FXML
    private DatePicker DateText;
    @FXML
    private TextArea CommentArea;

    ObservableList<Company> initialData() throws SQLException, ClassNotFoundException {
        DbmsConnection dbmsconnection = DbmsConnection.getInstance();
        Connection con = dbmsconnection.getConnection();

        String sql = "SELECT * FROM companies ORDER BY title ASC ";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        ObservableList<Company> list = FXCollections.observableArrayList();

        while(rs.next()) {
            Company company = new Company(rs.getInt("id"), rs.getString("title"), rs.getInt("channel_id"),
                rs.getInt("count_subscribe"), rs.getInt("speed_hour_from"), rs.getInt("speed_hour_to"));
                //rs.getInt("is_views"),rs.getInt("procent_off"),rs.getString("start_from"),rs.getString("comments"));

            list.add(company);
        }

        return list;
    }

    ObservableList<String> initialChannelsData() throws SQLException, ClassNotFoundException {
        DbmsConnection dbmsconnection = DbmsConnection.getInstance();
        Connection con = dbmsconnection.getConnection();

        String sql = "SELECT * FROM channels ORDER BY title ASC ";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        ObservableList<String> list = FXCollections.observableArrayList();

        while(rs.next()) {
            list.add(rs.getInt("id")+". "+rs.getString("title"));
        }

        return list;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (CompaniesTable != null) {
            Column1.setCellValueFactory(new PropertyValueFactory<>("Id"));
            Column2.setCellValueFactory(new PropertyValueFactory<>("Title"));
            Column3.setCellValueFactory(new PropertyValueFactory<>("Channel_id"));
            Column4.setCellValueFactory(new PropertyValueFactory<>("Count_subscribe"));
            Column5.setCellValueFactory(new PropertyValueFactory<>("Speed_hour_from"));
            Column6.setCellValueFactory(new PropertyValueFactory<>("Speed_hour_to"));
            try {
                CompaniesTable.setItems(initialData());
            } catch (SQLException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

        if (ChannelBox != null) {
            try {
                ChannelBox.setItems(initialChannelsData());
            } catch (SQLException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

        if (CountSubscribeSpiner != null) {
            SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 50000);
            valueFactory.setValue(1);
            CountSubscribeSpiner.setValueFactory(valueFactory);

            CountSubscribeSlider.setValue((double) CountSubscribeSpiner.getValue());
            AlertText.setText(Integer.toString(CountSubscribeSpiner.getValue()));

            CountSubscribeSpiner.valueProperty().addListener(new ChangeListener<Integer>() {
                @Override
                public void changed(ObservableValue<? extends Integer> observableValue, Integer integer, Integer t1) {
                    CountSubscribeSlider.setValue((double) CountSubscribeSpiner.getValue()); // <-- add value from spinner
                    AlertText.setText(Integer.toString(CountSubscribeSpiner.getValue()));
                }
            });
        }

        if (CountSubscribeSlider != null) {
            CountSubscribeSlider.valueProperty().addListener(new ChangeListener<Number>() {
                @Override
                public void changed(ObservableValue<? extends Number> observableValue, Number oldValue, Number newValue) {
                    double value = newValue.doubleValue();
                    System.out.println("slider ==> " + (int) value);

                    SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 50000);
                    valueFactory.setValue(newValue.intValue()); // <-- add value from slider
                    CountSubscribeSpiner.setValueFactory(valueFactory);
                    AlertText.setText(Double.toString(newValue.doubleValue()));
                }
            });
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
        System.out.println("==> channel click ");

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("upload-datas-view.fxml"));
        Scene scene1 = new Scene(fxmlLoader.load(), 1100, 800);
        Stage primaryStage = (Stage) UploadDatasButton.getScene().getWindow();
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
    public void TasksButton(ActionEvent actionEvent) throws IOException, SQLException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("tasks.fxml"));
        Scene scene1 = new Scene(fxmlLoader.load(), 1100, 800);
        Stage primaryStage = (Stage) TasksButton.getScene().getWindow();
        primaryStage.setScene(scene1);
    }

    @FXML
    public void ExitButton(ActionEvent actionEvent) throws IOException, SQLException {
        Stage primaryStage = (Stage) ExitButton.getScene().getWindow();
        primaryStage.close();
    }
    //

    @FXML
    public void onAddCompanyButton(ActionEvent actionEvent) throws IOException, SQLException {
        System.out.println("==> add company click ");

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("add-company-view.fxml"));
        Scene scene1 = new Scene(fxmlLoader.load(), 1100, 800);
        Stage primaryStage = (Stage) AddCompanyButton.getScene().getWindow();
        primaryStage.setScene(scene1);
    }

    @FXML
    public void onAddAddCompanyButton(ActionEvent actionEvent) throws IOException, SQLException, ClassNotFoundException {
        boolean connect = validate_form();
        if (connect) {
            // add channel to database
            DbmsConnection dbmsconnection = DbmsConnection.getInstance();
            Connection con = dbmsconnection.getConnection();

            System.out.println("DATA to Company:");
            System.out.println("ChannelBox ===> "+ ChannelBox.getValue());
            System.out.println("DateText ===> "+ DateText.getValue());
            System.out.println("CountSubscribeSpiner ===> "+ CountSubscribeSpiner.getValue());
            System.out.println("SpeedFromSpinner ===> "+ SpeedFromSpinner.getValue());
            System.out.println("SpeedToSpinner ===> "+ SpeedToSpinner.getValue());
            System.out.println("ViewCheckbox ===> "+ ViewCheckbox.isSelected());
            System.out.println("ProcentOffSpinner ===> "+ ProcentOffSpinner.getValue());

            // TODO! Add a new company
            String sql1 = "INSERT INTO companies (title, channel_id, count_subscribe, speed_hour_from, speed_hour_to, is_views, procent_off, start_from, comments) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?) ";
            PreparedStatement stmt1 = con.prepareStatement(sql1);
            stmt1.setString(1, TitleText.getText());
            stmt1.setInt(2, 1); // <-- ChannelBox.getValue() -- need ID - have String title
            stmt1.setInt(3, CountSubscribeSpiner.getValue());
            stmt1.setInt(4, SpeedFromSpinner.getValue() == null ? 0 : SpeedFromSpinner.getValue());
            stmt1.setInt(5, SpeedToSpinner.getValue() == null ? 0 : SpeedToSpinner.getValue());
            stmt1.setInt(6, ViewCheckbox.isSelected() ? 1 : 0);
            stmt1.setInt(7, ProcentOffSpinner.getValue() == null ? 0 : ProcentOffSpinner.getValue());
            stmt1.setString(8, DateText.getValue().toString());
            stmt1.setString(9, CommentArea.getText());

            int i = stmt1.executeUpdate();
            if (i > 0) {
                AlertText.setTextFill(Color.GREEN);
                AlertText.setText("You inserted company successfully");

                System.out.println("You inserted company successfully");
            } else {
                AlertText.setTextFill(Color.RED);
                AlertText.setText("Can't insert company in the database");

                System.out.println("Can't insert company in the database");
            }

            // redirect to list of channels
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("company-view.fxml"));
            Scene scene1 = new Scene(fxmlLoader.load(), 1100, 800);
            Stage primaryStage = (Stage) AddAddCompanyButton.getScene().getWindow();
            primaryStage.setScene(scene1);
        } else {
            AlertText.setTextFill(Color.RED);
        }
    }

    public boolean validate_form() {
        boolean proceed = true;
        AlertText.setTextFill(Color.RED);

        if (TitleText.getText().isEmpty() && proceed == true) {
            AlertText.setText("Enter Title");
            proceed = false;
        }
        if (ChannelBox.getValue() == null && proceed == true) { // <-- TODO: add validate for ComboBox
            AlertText.setText("Choose channel");
            proceed = false;
        }
        if (CountSubscribeSpiner.getValue().toString().isEmpty() && proceed == true) {
            AlertText.setText("Enter count subscribe");
            proceed = false;
        }
        if (DateText.getValue() == null && proceed == true) {
            AlertText.setText("Enter date");
            proceed = false;
        }

        return proceed;
    }

    @FXML
    public void onCancelAddCompanyButton(ActionEvent actionEvent) throws IOException, SQLException {
        // redirect to list of channels
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("company-view.fxml"));
        Scene scene1 = new Scene(fxmlLoader.load(), 1100, 800);
        Stage primaryStage = (Stage) CancelAddCompanyButton.getScene().getWindow();
        primaryStage.setScene(scene1);
    }

    //--- upload file ---
    @FXML
    public void onAddFileButton(ActionEvent actionEvent) throws IOException, SQLException {
        // choose file
        System.out.println("==> choose file click ");
    }

    @FXML
    public void onUploadFileButton(ActionEvent actionEvent) throws IOException, SQLException {
        // upload file
        System.out.println("==> upload file click ");
    }
}
