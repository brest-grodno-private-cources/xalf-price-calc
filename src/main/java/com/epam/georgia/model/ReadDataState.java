package com.epam.georgia.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadDataState implements Status {

    Scanner scanner = new Scanner(System.in);
    List<String> values = new ArrayList<>();

    @Override
    public Status handle() {
        while (values.size() < 4) {
            System.out.println("Please enter value:");
            values.add(scanner.next());
        }
        return new CalcState(values);
    }

    @Override
    public StatusType getType() {
        return StatusType.READ_DATA;
    }

}
