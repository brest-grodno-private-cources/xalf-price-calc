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

        Map<Integer, Double> massPrices = new CSVFileReader().readData("mass-price.csv");
        if (massPrices == null || massPrices.isEmpty()) {
            System.out.println("Can't read file.");
            return;
        }

        Map<Integer, Double> distancePrices = new CSVFileReader().readData("distance-price.csv");
        if (distancePrices == null || distancePrices.isEmpty()) {
            System.out.println("Can't read file.");
            return;
        }

        Status currentStatus = new ReadDataState();
        while (currentStatus.getType() != StatusType.EXIT) {
            currentStatus = currentStatus.handle();
        }
        currentStatus.handle();
    }
}