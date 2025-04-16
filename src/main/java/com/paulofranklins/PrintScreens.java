package com.paulofranklins;

import java.util.Scanner;

import static com.paulofranklins.Calculator.*;
import static com.paulofranklins.UserInput.getUserInput;

public class PrintScreens {

    public static void runningMainScreen(Scanner scanner) {
        boolean running = true;
        while (running) {
            System.out.println("1 - Mortgage Caculator");
            System.out.println("2 - Daily Interest Calculator");
            System.out.println("3 - Future Calculator");
            System.out.println("4 - Quit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    printResultMortgageCalculator(scanner);
                    break;
                case 2:
                    printFutureValueCalculator(scanner);
                    break;
                case 3:
                    printPresentValueCalculator(scanner);
                    break;
                case 4:
                    running = false;
                    System.out.println("Goodbye!");
            }
        }
    }

    public static void printResultMortgageCalculator(Scanner scanner) {
        Result result = getUserInput(scanner);

        double monthlyPayment = calculateMortgage(result.principal(), result.annualRate(), result.years());
        double totalPrice = monthlyPayment * result.years();
        double paidInterest = totalPrice - monthlyPayment;

        System.out.println();
        System.out.printf("Monthly Payment: %.2f \n", monthlyPayment);
        System.out.printf("Total Paid: %.2f \n", totalPrice);
        System.out.printf("Interest Paid: %.2f \n", paidInterest);
    }

    public static void printFutureValueCalculator(Scanner scanner) {
        Result result = getUserInput(scanner);

        double futureValue = calculateFutureValue(result.principal(), result.annualRate(), result.years());
        double earnedInterest = futureValue - result.principal();

        System.out.println();
        System.out.printf("Future value: %.2f \n", futureValue);
        System.out.printf("Interest earned: %.2f \n", earnedInterest);
    }

    public static void printPresentValueCalculator(Scanner scanner) {
        Result result = getUserInput(scanner);

        double neededInvestAmount = calculatePresentValue(result.principal(), result.annualRate(), result.years());

        System.out.println();
        System.out.printf("Value needed to invest: %.2f \n", neededInvestAmount);
    }
}
