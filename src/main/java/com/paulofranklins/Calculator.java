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

    public static double calculateMortgage(double principal, double annualRate, int years) {
        double monthlyRate = monthlyRate(annualRate);
        int totalMonths = years * 12;

        //M=P×(i*(1+i)^n / ((1+i)^n)-1)
        double ratePower = Math.pow(1 + monthlyRate, totalMonths);
        return principal * (monthlyRate * ratePower) / (ratePower - 1);
    }

    //Calculator 2: future value calculator
    public static double calculateFutureValue(double principal, double rate, int time) {
        //FV = P × (1 + (r / 365))^(365 × t)
        double dailyRate = dailyRate(rate);
        double growthFactor = 1 + dailyRate;
        double exponent = 365 * time;

        double compoundInterest = Math.pow(growthFactor, exponent);
        return principal * compoundInterest;
    }

    //Calculator 3: presente value calculator
    public static double calculatePresentValue(double monthlyPayout, double annualRate, int years) {
        double monthlyRate = monthlyRate(annualRate);
        int totalMonths = years * 12;
        if (monthlyRate == 0) {
            return monthlyPayout * totalMonths;
        }
        return monthlyPayout * (1 - Math.pow(1 + monthlyRate, -totalMonths)) / monthlyRate;
    }

}
