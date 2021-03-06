package com.epam.georgia.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ReadDataState implements Status {

    public static final int NUMBER_NEEDED_VALUES = 2;

    Map<Integer, Double> massPrices;
    Map<Integer, Double> distancePrices;

    public ReadDataState(Map<Integer, Double> massPrices, Map<Integer, Double> distancePrices) {
        this.massPrices = massPrices;
        this.distancePrices = distancePrices;
    }

    Scanner scanner = new Scanner(System.in);
    List<Double> values = new ArrayList<>();
    String[] systemMessages = {"Please enter mass ", "Please enter distance "};
    String helpMessage = "(or press 'q' to Exit): ";

    @Override
    public Status handle() {
        while (values.size() < NUMBER_NEEDED_VALUES) {
            System.out.println(systemMessages[values.size()] + helpMessage);

            String enteredValue = scanner.next();
            if (enteredValue.equalsIgnoreCase("q")) {
                return new ExitState();
            }

            if (isCorrectValue(enteredValue)) {
                values.add(Double.valueOf(enteredValue));
            }
        }
        return new CalcState(massPrices, distancePrices, values);
    }

    private boolean isCorrectValue(String value) {
        boolean checkResult = true;
        try {
            Double ev = Double.valueOf(value);
            if (ev <= 0) {
                System.out.println("Entered value should be > 0");
                checkResult = false;
            }
        } catch (NumberFormatException ex) {
            System.out.println("Please enter correct value: ");
            checkResult = false;
        }
        return checkResult;
    }

    @Override
    public StatusType getType() {
        return StatusType.READ_DATA;
    }

}
