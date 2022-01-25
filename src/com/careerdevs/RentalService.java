package com.careerdevs;

public class RentalService {
    public static void main(String[] args) {
        System.out.println("Welcome to the Car Rental CLI!");

        Car[] carStorage = new Car[3];

        Car car1 = new Car("Honda", "Accord");
        Car car2 = new Car("Chevy", "Cruze");
        Car car3 = new Car("Toyota", "Corolla");

        carStorage[0] = car1;
        carStorage[1] = car2;
        carStorage[2] = car3;

        //problem how do we list just Rented or available cars?

        car2.setIsRented(true);

       // solution (std array) : iterate through the array only display cars where isRented is false.
//        System.out.println("Available Cars");
//        int listNumber = 1;
//        for (int i = 0; i < carStorage.length; i++) {
//            if (!carStorage[i].isRented()) { // is an available car
//                System.out.println("(" + listNumber + ") " + carStorage[i].getName());
//                listNumber++;
//            }
//        }


        System.out.println("All Cars");
        for (int i = 0; i < carStorage.length; i++) {
            String  carStatus  = !carStorage[i].isRented() ?  "Available" : "Unavailable";  // ternary expression
            System.out.println("(" + (i + 1) + ") " + carStorage[i].getName() + "(" + carStatus + ")");
        }
//        System.out.println("Available Cars");
//        for (int i = 0; i < carStorage.length; i++) {
//            if (!carStorage[i].isRented()) {
//                System.out.println("(" + (i + 1) + ") " + carStorage[i].getName());
//            }
//        }



    }

}

