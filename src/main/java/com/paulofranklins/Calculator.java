package com.paulofranklins;


public class Calculator {
    public record Result(double principal, double annualRate, int years) {
    }

    //Calculator 1: A mortgage calculator
    public static double monthlyRate(double rate) {
        return rate / 100 / 12;
    }

    public static double dailyRate(double rate) {
        return rate / 100 / 365;
    }

    private static int getTotalMonths(int years) {
        return years * 12;
    }

    public static double calculateMortgage(double principal, double annualRate, int year) {
        double monthlyRate = monthlyRate(annualRate);
        int totalMonths = getTotalMonths(year);

        //M=P×(i*(1+i)^n / ((1+i)^n)-1)
        double ratePower = Math.pow(1 + monthlyRate, totalMonths);
        return principal * (monthlyRate * ratePower) / (ratePower - 1);
    }

    //Calculator 2: future value calculator
    public static double calculateFutureValue(double principal, double rate, int year) {
        //FV = P × (1 + (r / 365))^(365 × t)
        double dailyRate = dailyRate(rate);
        double growthFactor = 1 + dailyRate;
        double exponent = 365 * year;

        double compoundInterest = Math.pow(growthFactor, exponent);
        return principal * compoundInterest;
    }

    //Calculator 3: presente value calculator
    public static double calculatePresentValue(double principal, double rate, int year) {
        double monthlyRate = monthlyRate(rate);
        int totalMonths = getTotalMonths(year);

        // PV = P × (1 - (1 + i)^-n) / i
        return principal * (1 - Math.pow(1 + monthlyRate, -totalMonths)) / monthlyRate;
    }

}
