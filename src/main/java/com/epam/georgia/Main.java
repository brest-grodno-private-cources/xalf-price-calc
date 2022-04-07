package com.epam.georgia;

import com.epam.georgia.model.ReadDataState;
import com.epam.georgia.model.Status;
import com.epam.georgia.model.StatusType;

public class Main {

    //priceCalc = pricePerKg*kg + pricePerKm*km
    public static void main(String[] args) {
        System.out.println("CALC SYSTEM");
        Status currentStatus = new ReadDataState();
        while (currentStatus.getType() != StatusType.EXIT) {
            currentStatus = currentStatus.handle();
        }
        currentStatus.handle();
    }
}