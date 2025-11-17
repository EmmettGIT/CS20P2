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
            int a = rand.nextInt(21); // 0..20
            int b = rand.nextInt(21); // 0..20
            int correct = a + b;

            System.out.print(a + " + " + b + " = ");
            int tries = 0;
            boolean answeredCorrectly = false;

            while (tries < 3) {
                // Validate input is integer
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
                    // award points based on which try
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