package com.epam.georgia;

public class Main {

    public static void main(String[] args) {
        if (args.length > 0) {
            System.out.println("TEST: " + args[0]);
        } else {
            System.out.println("TEST: " + args.length);
        }

    }

}
