package com.careerdevs.ui;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInput {
    private static Scanner scanner = new Scanner(System.in);  // only used in this class

    public static String readString(String question) {

        while(true) {
            System.out.println(question + "\nInput: ");
            String inputString = scanner.nextLine();
            if(!inputString.trim().equals(""))  {  // if not equal to anything => true
                    return inputString.trim();
            }
            System.out.println("You must enter something!");
        }
    }

//    public static int readInt(String question) {
//        System.out.println(question + "\nNumber: ");
//        while (!scanner.hasNextInt()) {
//            System.out.println("Please enter a valid number!");
//            scanner.nextLine();
//        }
//        return scanner.nextInt();
//    }

    public static int readInt(String question) {
        while (true) {
            try {
                System.out.print(question + "\nSelection: ");
                int temp = scanner.nextInt(); // exception risk
                return temp;
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("You must enter an integer, try again");
            }
        }
    }
}


