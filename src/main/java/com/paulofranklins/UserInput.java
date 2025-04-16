package com.paulofranklins;

import java.util.Scanner;

public class UserInput {

    public static Calculator.Result getUserInput(Scanner scanner) {
        System.out.print("Enter principal amount: ");
        double principal = scanner.nextDouble();

        System.out.print("Enter Annual Rate: ");
        double annualRate = scanner.nextDouble();

        System.out.print("Enter Number of Years ");
        int years = scanner.nextInt();
        return new Calculator.Result(principal, annualRate, years);
    }
}
