package com.careerdevs;

import com.careerdevs.ui.UserInput;

import java.util.ArrayList;
import java.util.Locale;

public class RentalService {

    public static ArrayList<Car> availableCars = new ArrayList<>();
    public static ArrayList<Car> rentedCars = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Welcome to the Car Rental CLI!");
        createCars();
        mainMenu();
    }

    private static void createCars() {
        Car car1 = new Car("Honda", "Accord");
        Car car2 = new Car("Chevy", "Cruze");
        Car car3 = new Car("Toyota", "Corolla");
        availableCars.add(car1);
        availableCars.add(car2);
        availableCars.add(car3);
    }

    private static void flipCarsToAllAvailable() {
        for (Car rentedCar : rentedCars) {
            rentedCar.setRented(false);
            rentedCar.setCustomer("");
            availableCars.add(rentedCar);
        }
        rentedCars.clear();
    }

    private static void mainMenu() {
        boolean on = true;
        while (on) {
            System.out.println("\n1) Rent a car" + " (" + (availableCars.size()) + " Cars Available)" + "\n2) Return " +
                    "(" + (rentedCars.size()) + " Cars Available)" + "\n3)" +
                    " Create a car\n4) " +
                    "Exit");
            int input = UserInput.readInt("Please enter a selection", 1, 4);
            switch (input) {
                case 1 -> printAvailableCars();
                case 2 -> returnCarByName();
                case 3 -> createACar();
                case 4 -> on = false;
            }
        }
    }


    private static void rentACar() {
        int input = UserInput.readInt("Please enter a car you would like to rent or exit to main menu.", 1,
                availableCars.size() + 1);
        if ((availableCars.size() + 1) == input) { // EXIT TO MAIN MENU
            mainMenu();
            return;
        }
        while (true) {
            String answer =
                    UserInput.readString("Are you sure you would like to rent the " + (availableCars.get(input - 1).getName()) + "? (yes/no)").toLowerCase(Locale.ROOT);
            if (answer.equals("yes") || answer.equals("y")) {
                String customer = UserInput.readString("What is the name you would like to use to return your " +
                        "rental?\nEnter name: ").toLowerCase();
                availableCars.get(input - 1).setCustomer(customer);
                break;
            }
            if (answer.equals("no") || answer.equals("n"))
                printAvailableCars();
        }
        availableCars.get(input - 1).setRented(true);
        System.out.println("\nThank you for renting a " + availableCars.get(input - 1).
                getName() + " " + availableCars.get(input - 1).getCustomer() + ".\n");
        rentedCars.add(availableCars.remove(input - 1));
        mainMenu();
    }


    private static void returnCarByName() {
        if (rentedCars.size() == 0) {
            System.out.println("No cars to return");
            mainMenu();
        } else {
            System.out.println("\nPlease make a selection");
            int numInput = UserInput.readInt("1) Select if you are sure you would like to return a car\n2) Return " +
                            "to main menu", 1,
                    2);
            if (numInput == 1) {
                printRentedCars();
                String input =
                        UserInput.readString("Enter the name used to rent the car or select a number to return to " +
                                "previous menu").toLowerCase().trim();
                for (int i = 0; i < rentedCars.size(); i++) {
                    if (rentedCars.get(i).getCustomer().equals(input)) {
                        System.out.println("Customer " + rentedCars.get(i).getCustomer() + "s' car has been returned " +
                                "to inventory.");
                        rentedCars.get(i).setCustomer("");
                        availableCars.add(rentedCars.remove(i));
                        mainMenu();
                    } else {
                        System.out.println("Please try again");
                        returnCarByName();
                    }
                }
            }
            if (numInput == 2) {
                mainMenu();
            }
        }
    }

    private static void printAvailableCars() {
        if (availableCars.size() == 0) {
            exitMenu();
        }
        System.out.println("\nAll available Cars:");
        for (int i = 0; i < availableCars.size(); i++) {
            {
                System.out.println("(" + (i + 1) + ") " + availableCars.get(i).getName());
            }
        }
        System.out.println("(" + (availableCars.size() + 1) + ")" + " Exit to main menu\n");
        rentACar();
    }

    private static void printRentedCars() {
        System.out.println("\nAll rented Cars:");
        for (int i = 0; i < rentedCars.size(); i++) {
            {
                System.out.println("(" + (i + 1) + ") " + rentedCars.get(i).getName() + " (Customer name : " + rentedCars.get(i).getCustomer() + ")");
            }
        }
        System.out.println("(" + (rentedCars.size() + 1) + ")" + " Return to previous menu\n");
    }

    private static void exitMenu() {
        System.out.println("\nThere are no cars to rent!");
        System.out.println("1) Would you like to reset all cars to available?\n2) Would you like to create a new " +
                "car?\n3) Exit program");
        int input = UserInput.readInt("Please enter a selection", 1, 3);
        switch (input) {
            case 1 -> {
                flipCarsToAllAvailable();
            }
            case 2 -> createACar();
            case 3 -> System.exit(0);
        }
    }

    private static void createACar() {
        String make = UserInput.readString("What is the make of the car?");
        String model = UserInput.readString("What is the model of the car?");
        Car car = new Car(make, model);
        availableCars.add(car);
        mainMenu();
    }
}
//    private static void returnACar() {
//        int input = UserInput.readInt("Please enter a car you would like to return or exit to main menu.", 1,
//                rentedCars.size() + 1);
//        if ((rentedCars.size() + 1) == input) {
//            mainMenu();
//            return;
//        }
//        rentedCars.get(input - 1).setRented(false);
//        System.out.println("\nThank you for returning a " + rentedCars.get(input - 1).getName() + ".\n");
//        availableCars.add(rentedCars.remove(input - 1));
//        mainMenu();
//    }
