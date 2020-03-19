package com.company;

import javafx.scene.chart.XYChart;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        FileReader fileReader = new FileReader("/Users/alexandregresset/Desktop/Series3.txt");

        System.out.println(fileReader.getStageTitle());
        System.out.println(fileReader.getChartTitle());
        System.out.println(fileReader.getxAxisLabel());
        System.out.println(fileReader.getyAxisLabel());

        for (int i = 0; i < fileReader.getListSeries().size(); i++) {
            System.out.println("\n" + fileReader.getListSeries().get(i).getName());
            for (int j = 0; j < fileReader.getListSeries().get(i).getData().size(); j++) {
                System.out.println(fileReader.getListSeries().get(i).getData().get(j));
            }
        }

        FileMaker fileMaker = new FileMaker("/Users/alexandregresset/Desktop/Series4.txt", "StageFileBlou", "ChartFileBlou", "les X", "les Y", fileReader.getListSeries());
    }
}
