package com.techmatrix.javafx_jdbc.view;

import com.techmatrix.javafx_jdbc.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import javafx.scene.chart.NumberAxis;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class StatisticsController implements Initializable {
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
    private final NumberAxis xAxis = new NumberAxis();
    @FXML
    private final CategoryAxis yAxis = new CategoryAxis();
    @FXML
    private AreaChart<String, Number> StatAreaChart;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (StatAreaChart != null) {

            xAxis.setLabel("Percent");
            //xAxis.setTickLabelRotation(90);

            yAxis.setLabel("Performance");

            StatAreaChart.setLegendVisible(true);
            StatAreaChart.setCreateSymbols(true);

            // example of datas
            StatAreaChart.setTitle("Temperature Monitoring (in Degrees C)");

            XYChart.Series<String, Number> data = new XYChart.Series<String, Number>();
            data.getData().add(new XYChart.Data<>("2004", 82502));
            data.getData().add(new XYChart.Data<>("2005", 84026));
            data.getData().add(new XYChart.Data<>("2006", 85007));
            data.getData().add(new XYChart.Data<>("2007", 86216));
            data.getData().add(new XYChart.Data<>("2008", 85559));
            data.getData().add(new XYChart.Data<>("2009", 84491));
            data.getData().add(new XYChart.Data<>("2010", 87672));
            data.getData().add(new XYChart.Data<>("2011", 88575));
            data.getData().add(new XYChart.Data<>("2012", 89837));
            data.getData().add(new XYChart.Data<>("2013", 90701));

            XYChart.Series<String, Number> series1 = new XYChart.Series<String, Number>();
            series1.getData().add(new XYChart.Data<>( "2004", 80000));
            series1.getData().add(new XYChart.Data<>( "2005", 20000));
            series1.getData().add(new XYChart.Data<>( "2006", 50000));
            series1.getData().add(new XYChart.Data<>( "2010", 10000));
            series1.getData().add(new XYChart.Data<>( "2022", 60000));
            series1.getData().add(new XYChart.Data<>( "2023", 80000));
            StatAreaChart.getData().addAll(series1, data);

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
    public void UploadDatasButton(ActionEvent actionEvent) throws IOException, SQLException {
        System.out.println("==> upload datas click ");

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
}
