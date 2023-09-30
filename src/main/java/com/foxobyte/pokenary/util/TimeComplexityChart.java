package com.foxobyte.pokenary.util;

import com.foxobyte.pokenary.service.PokemonService;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class TimeComplexityChart extends Application {
    @Autowired
    PokemonService service;
    private String title;
    private List<XYChart.Series> series = new ArrayList<>();

    public void setTitle(String title) {
        this.title = title;
    }

    public void addSeries(List<Long> results, String title) {
        XYChart.Series series = new XYChart.Series();
        series.setName(title);

        for (int i = 0; i < results.size(); i++) {
            series.getData().add(new XYChart.Data<>(i, results.get(i)));
        }

        this.series.add(series);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        final LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);

        primaryStage.setTitle("Time Complexity Analysis");
        xAxis.setLabel("Number of Elements");
        lineChart.setTitle(this.title);
        Scene scene = new Scene(lineChart, 800, 600);

        series.stream().forEach(s -> lineChart.getData().add(s));
        lineChart.setCreateSymbols(false);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
