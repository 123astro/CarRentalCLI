package com.careerdevs;

import com.careerdevs.ui.UserInput;

public class TestUI {
    public static void main(String[] args) {
        String userInput = UserInput.readString("Who are you?");  // bc scanner is static in UserInput - no need to
        // create a new UserInput instance.
        System.out.println("Okay you are: " + userInput);

        int input;
        input = UserInput.readInt("What is your age? ");
        System.out.println("Okay your age is: " + input);
    }
}
