package com.company;

import javafx.scene.chart.XYChart;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileReader {

    private String stageTitle = "";
    private String chartTitle = "";
    private String xAxisLabel = "";
    private String yAxisLabel = "";
    private ArrayList<XYChart.Series> listSeries = new ArrayList<XYChart.Series>();

    private String filename;

    public FileReader(String filename) throws IOException {
        this.filename = filename;

        File file = new File(filename);
        Scanner scan = new Scanner(file);
        int seriesId = -1;

        while (scan.hasNextLine()) {
            String line = scan.nextLine();

            if (line.equals("stageTitle")) {
                line = scan.nextLine();
                stageTitle = line;
            }

            if (line.equals("chartTitle")) {
                line = scan.nextLine();
                chartTitle = line;
            }

            if (line.equals("xAxisLabel")) {
                line = scan.nextLine();
                xAxisLabel = line;
            }

            if (line.equals("yAxisLabel")) {
                line = scan.nextLine();
                yAxisLabel = line;
            }

            if (line.equals("series")) {
                seriesId++;
                listSeries.add(new XYChart.Series());
                listSeries.get(seriesId).setName(scan.nextLine());
            }

            if (line.split("\\[")[0].equals("Data")) {
                String[] splitLine = line.split("\\[");
                String[] splitLineRest = splitLine[1].split(",");
                listSeries.get(seriesId).getData().add(new XYChart.Data( Integer.parseInt(splitLineRest[0]), Integer.parseInt(splitLineRest[1])));
            }
        }
    }

    public String getStageTitle() { return stageTitle; }

    public String getChartTitle() { return chartTitle; }

    public String getxAxisLabel() { return xAxisLabel; }

    public String getyAxisLabel() { return yAxisLabel; }

    public ArrayList<XYChart.Series> getListSeries() {
        return listSeries;
    }

    public String getFilename() {
        return filename;
    }
}

