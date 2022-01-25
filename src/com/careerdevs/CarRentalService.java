package com.careerdevs;

import com.careerdevs.ui.UserInput;

import java.util.ArrayList;

public class CarRentalService {
    public static ArrayList<Car> carList = new ArrayList<Car>();
    public static int carInputNumber;

    public static void main(String[] args) {
        addCarsToInventory();
        do {
            availableInventory();
            dataCheck();
            System.out.println("Thank you! You are now renting the " + carList.get(carInputNumber - 1).getMake() + " " + carList.get(carInputNumber - 1).getModel());
            carList.get(carInputNumber - 1).setIsRented(true);
            //carList.remove(carInputNumber - 1);
            rentedInventory();
        } while (carList.size() != 0);
        System.out.println("All cars have been rented.");

    }

    public static void availableInventory() {
        System.out.println("Available Cars:");
        for (int i = 0; i < carList.size(); i++) {
            if (!carList.get(i).isRented()) {
                System.out.println((i + 1 + ")") + " " + carList.get(i).getMake() + " " + carList.get(i).getModel());
            }
        }
    }

    public static void rentedInventory() {
        System.out.println("Rented Cars:");
        for (int i = 0; i < carList.size(); i++) {
            if (carList.get(i).isRented()) {
                System.out.println((i + 1 + ")") + " " + carList.get(i).getMake() + " " + carList.get(i).getModel());
            }
        }
    }

    public static void dataCheck() {
        while (true) {
            carInputNumber = UserInput.readInt("\nEnter a number to select the car you would like to rent" +
                    ".\n");
            if (carInputNumber <= 0 || carInputNumber > carList.size()) {
                System.out.println("Car selection invalid, Please enter a valid number");
                availableInventory();
            } else {
                return;
            }
        }
    }

    public static void addCarsToInventory() {
        Car car1 = new Car("Honda", "Accord");
        Car car2 = new Car("Chevy", "Cruze");
        Car car3 = new Car("Toyota", "Corolla");
        carList.add(car1);
        carList.add(car2);
        carList.add(car3);

    }

}

