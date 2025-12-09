/*
 * HEADER
 */
//Program: AdderGame.java   Last Date of this Revision: November 17, 2025

//Purpose: The purpose of the Adder game is to give the user addition questions and award points based on how many tries they need to get the correct answer.

//Author: Emmett Stransky
//School: CHHS
//Course: Computer Programming 20


package Mastery;

import java.util.Random;
import java.util.Scanner;

public class AdderGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();
        int score = 0;
        final int QUIT_CODE = 999;

        System.out.println("Welcome to Adder! Enter " + QUIT_CODE + " at any time to quit.\n");

        while (true) {
            int a = rand.nextInt(21); 
            int b = rand.nextInt(21); 
            int correct = a + b;

            System.out.print(a + " + " + b + " = ");
            int tries = 0;
            boolean answeredCorrectly = false;

            while (tries < 3) {
                // validate input is integer
                if (!scanner.hasNextInt()) {
                    // consume invalid token and prompt again
                    String bad = scanner.next();
                    System.out.print("Please enter an integer (or " + QUIT_CODE + " to quit): ");
                    continue;
                }

                int answer = scanner.nextInt();

                // Check for quit code
                if (answer == QUIT_CODE) {
                    System.out.println("\nYour score is: " + score);
                    scanner.close();
                    return;
                }

                tries++;

                if (answer == correct) {
                    // gives points based on which try
                    if (tries == 1) {
                        score += 5;
                    } else if (tries == 2) {
                        score += 3;
                    } else { // tries == 3
                        score += 1;
                    }
                    answeredCorrectly = true;
                    break; // move to next problem
                } else {
                    if (tries < 3) {
                        System.out.print("Wrong answer. Enter another answer: ");
                    } else {
                        // after third wrong
                        System.out.println("Wrong answer.");
                    }
                }
            }

            if (!answeredCorrectly) {
                System.out.println("The correct answer is: " + correct);
           
            }

            // loop continues to next problem automatically
        }
    }
}

//SCREEN DUMP
//Welcome to Adder! Enter 999 at any time to quit.

//10 + 14 = 24
//9 + 12 = 21
//15 + 1 = 17
//Wrong answer. Enter another answer: 18
//Wrong answer. Enter another answer: 14
//Wrong answer.
//The correct answer is: 16
//17 + 10 = 27
//7 + 11 = 999

//Your score is: 15
