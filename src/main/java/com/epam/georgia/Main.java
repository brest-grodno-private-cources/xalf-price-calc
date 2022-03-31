package com.epam.georgia;

import com.epam.georgia.calc.Calculator;
import com.epam.georgia.calc.CalculatorImpl;

import java.util.Scanner;

public class Main {

    //priceCalc = pricePerKg*kg + pricePerKm*km
    public static void main(String[] args) {

        String pricePerKg, pricePerKm, km, kg;

        System.out.println("HELLO! Good day!");
        System.out.println("Please enter pricePerKg:");
        Scanner scanner = new Scanner(System.in);

        pricePerKg = scanner.next();
        System.out.println("pricePerKg = " + pricePerKg);

        pricePerKm = scanner.next();
        System.out.println("Please enter pricePerKm:");
        System.out.println("pricePerKm = " + pricePerKm);

        kg = scanner.next();
        System.out.println("Please enter kg:");
        System.out.println("kg = " + kg);

        km = scanner.next();
        System.out.println("Please enter km:");
        System.out.println("km = " + km);

        Calculator calc;
        //if (!km.equals("")) {
            calc = new CalculatorImpl();
        //} else {
        //    calc = new ABCCalcImpl();
        //}

        System.out.println("Result = " + calc.handle(Double.valueOf(pricePerKg), Double.valueOf(pricePerKm),
                Double.valueOf(kg), Double.valueOf(km)));
    }

}
