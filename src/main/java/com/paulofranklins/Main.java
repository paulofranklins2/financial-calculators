package com.paulofranklins;

import java.util.Scanner;

import static com.paulofranklins.PrintScreens.runningMainScreen;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        runningMainScreen(scanner);
        scanner.close();
    }
}