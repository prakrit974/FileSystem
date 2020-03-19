package com.company;

import javafx.scene.chart.XYChart;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class FileMaker {

    public FileMaker(String fileName, String stageTitle, String chartTitle, String xAxisLabel, String yAxisLabel, ArrayList<XYChart.Series> listSeries) throws IOException {

        PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));

        printWriter.println("stageTitle");
        printWriter.println(stageTitle);

        printWriter.println("chartTitle");
        printWriter.println(chartTitle);

        printWriter.println("xAxisLabel");
        printWriter.println(xAxisLabel);

        printWriter.println("yAxisLabel");
        printWriter.println(yAxisLabel);

        for (int i = 0; i < listSeries.size(); i++) {
            printWriter.println("series");
            printWriter.println(listSeries.get(i).getName());
            for (int j = 0; j < listSeries.get(i).getData().size(); j++) {
                printWriter.println(listSeries.get(i).getData().get(j));
            }
        }

        printWriter.close();
    }
}
