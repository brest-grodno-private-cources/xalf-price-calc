package com.epam.georgia;

import com.epam.georgia.model.ReadDataState;
import com.epam.georgia.model.Status;
import com.epam.georgia.model.StatusType;
import com.epam.georgia.reader.CSVFileReader;
import com.epam.georgia.reader.FileReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.Map;

public class Main {

    //priceCalc = pricePerKg*kg + pricePerKm*km
    public static void main(String[] args) throws IOException {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
        FileReader fileReader = (FileReader) applicationContext.getBean(CSVFileReader.class);

        System.out.println("CALC SYSTEM");

        String massPricesFileName = "mass-prices.csv";
        String distancePricesFileName = "distance-prices.csv";
        if (args != null && args.length == 2) {
            massPricesFileName = args[0];
            distancePricesFileName = args[1];
        }

        System.out.println("mass-prices file is: " + massPricesFileName);
        System.out.println("distance-prices file is: " + distancePricesFileName);

        Map<Integer, Double> massPrices = readFile(fileReader, massPricesFileName);
        Map<Integer, Double> distancePrices = readFile(fileReader, distancePricesFileName);

        Status currentStatus = new ReadDataState(massPrices, distancePrices);
        while (currentStatus.getType() != StatusType.EXIT) {
            currentStatus = currentStatus.handle();
        }
        currentStatus.handle();
    }

    private static Map<Integer, Double> readFile(FileReader fileReader, String fileName) throws IOException {
        Map<Integer, Double> massPrices = fileReader.readData(fileName);
        if (massPrices == null || massPrices.isEmpty()) {
            throw new IOException("Can't read file: " + fileName);
        }
        return massPrices;
    }
}