package com.careerdevs;

import com.careerdevs.ui.UserInput;
import java.util.ArrayList;

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

    private static void printAvailableCars() {
        if(availableCars.size() == 0 ){
            exitMenu();
        }
        System.out.println("All available Cars");
        for (int i = 0; i < availableCars.size(); i++) {{
                System.out.println("(" + (i + 1) + ") " + availableCars.get(i).getName());
            }
        }
        rentACar();
    }

    private static void mainMenu(){
        System.out.println("1) Rent a car\n2) Return a car\n3) Exit\n");
        int input = UserInput.readInt("Please enter a selection");
        switch (input) {
            case 1 -> printAvailableCars();
            case 2 -> printRentedCars();
            case 3 -> System.exit(0);
        }
    }

    private static void rentACar() {
        int input = UserInput.readInt("Please enter a car you would like to rent");
        System.out.println("Thank you for renting a "  + availableCars.get(input -1).getName() + ".");
        rentedCars.add(availableCars.remove(input -1));
        mainMenu();
    }

    private static void returnACar() {
        int input = UserInput.readInt("Please enter a car you would like to return");
        System.out.println("Thank you for returning a "  + rentedCars.get(input -1).getName() + ".");
        availableCars.add(rentedCars.remove(input -1));
        mainMenu();
    }

    private static void printRentedCars(){
        System.out.println("All rented Cars");
        for (int i = 0; i < availableCars.size(); i++) {{
            System.out.println("(" + (i + 1) + ") " + rentedCars.get(i).getName());
        }
        }
        returnACar();
    }

    private static void exitMenu(){
        System.out.println("1) Would you like to reset all cars to available?\n2) Would you like to exit? ");
        int input = UserInput.readInt("Please enter a selection");
        switch (input) {
            case 1 -> {
                createCars();
                rentedCars.clear();
            }
            case 2 -> System.exit(0);
        }
    }
}

