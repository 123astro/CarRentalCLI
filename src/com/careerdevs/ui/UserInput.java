package com.careerdevs.ui;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInput {
    private static Scanner scanner = new Scanner(System.in);  // only used in this class

    public static String readString(String question) {
        System.out.println(question + "\nInput: ");
        String inputString = scanner.next();
        return inputString.trim();
    }
//    public static int readInt(String question) {
//        System.out.println(question + "\nNumber: ");
//        while (!scanner.hasNextInt()) {
//            System.out.println("Please enter a valid number!");
//            scanner.nextLine();
//        }
//        return scanner.nextInt();
//    }

    public static int readInt(String question, int min, int max) {
        while (true) {
            try {
                System.out.print(question + "\nSelection:  ");
                int temp = scanner.nextInt(); // exception risk
                if (temp >= min && temp <= max) {
                    return temp;
                }
                scanner.nextLine();
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("You must enter an integer, try again");
            }
        }
    }
}


