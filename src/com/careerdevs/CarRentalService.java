package com.careerdevs;

import com.careerdevs.ui.UserInput;

import java.util.ArrayList;
import java.util.Scanner;

public class CarRentalService {
    public static Scanner scanner = new Scanner(System.in);
    public static ArrayList<Car> carList = new ArrayList<Car>();

    public static void main(String[] args) {
        addCarsToInventory();
        do {
            inventory();
            int carInputNumber= UserInput.readInt("\nEnter a number to select the car you would like to rent.\nSelection: ");
            carList.remove(carInputNumber - 1);
        } while (carList.size() != 0);
        System.out.println("All cars have been rented.");
    }

    public static void inventory() {
        for (int i = 0; i < carList.size(); i++) {
            System.out.println((i + 1 + ")") + " " + carList.get(i));
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

