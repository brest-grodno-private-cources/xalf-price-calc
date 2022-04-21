package com.epam.georgia;

import com.epam.georgia.model.ReadDataState;
import com.epam.georgia.model.Status;
import com.epam.georgia.model.StatusType;
import com.epam.georgia.reader.CSVFileReader;

import java.io.IOException;
import java.util.Map;

public class Main {

    //priceCalc = pricePerKg*kg + pricePerKm*km
    public static void main(String[] args) throws IOException {
        System.out.println("CALC SYSTEM");

//        Map<Integer, Double> massPrices = readFile("mass-price.csv");
//        Map<Integer, Double> distancePrices = readFile("distance-prices.csv");

        Map<Integer, Double> massPrices = new CSVFileReader().readData("mass-prices.csv");
        if (massPrices == null || massPrices.isEmpty()) {
            System.out.println("Can't read file mass-prices.csv.");
            return;
        }

        Map<Integer, Double> distancePrices = new CSVFileReader().readData("distance-prices.csv");
        if (distancePrices == null || distancePrices.isEmpty()) {
            System.out.println("Can't read file distance-prices.csv.");
            return;
        }

        Status currentStatus = new ReadDataState(massPrices, distancePrices);
        while (currentStatus.getType() != StatusType.EXIT) {
            currentStatus = currentStatus.handle();
        }
        currentStatus.handle();
    }

//    private static Map<Integer, Double> readFile(String fileName) throws IOException {
//        Map<Integer, Double> massPrices = new CSVFileReader().readData(fileName);
//        if (massPrices == null || massPrices.isEmpty()) {
//            throw new IOException("Can't read file: " + fileName);
//        }
//        return massPrices;
//    }
}