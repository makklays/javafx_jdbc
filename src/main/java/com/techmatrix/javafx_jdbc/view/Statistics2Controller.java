package com.techmatrix.javafx_jdbc.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import java.net.URL;
import java.util.ResourceBundle;

public class Statistics2Controller implements Initializable {

    @FXML
    private AreaChart<String, Number> StatAreaChart;

    @FXML
    private CategoryAxis xAxis;

    @FXML
    private NumberAxis yAxis;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Настройки осей
        xAxis.setLabel("Year");
        yAxis.setLabel("Tasks");

        StatAreaChart.setLegendVisible(true);
        StatAreaChart.setCreateSymbols(true);

        // Сбрасываем старые данные
        StatAreaChart.getData().clear();

        // Пример данных
        XYChart.Series<String, Number> series1 = new XYChart.Series<>();
        series1.setName("PHP");
        series1.getData().add(new XYChart.Data<>("2007", 82));
        series1.getData().add(new XYChart.Data<>("2008", 274));
        series1.getData().add(new XYChart.Data<>("2009", 253));
        series1.getData().add(new XYChart.Data<>("2025", 253));
        StatAreaChart.getData().add(series1);

        XYChart.Series<String, Number> series2 = new XYChart.Series<>();
        series2.setName("Java");
        series2.getData().add(new XYChart.Data<>("2007", 11));
        series2.getData().add(new XYChart.Data<>("2008", 345));
        series2.getData().add(new XYChart.Data<>("2009", 478));
        series2.getData().add(new XYChart.Data<>("2025", 478));
        StatAreaChart.getData().add(series2);

    }
}

