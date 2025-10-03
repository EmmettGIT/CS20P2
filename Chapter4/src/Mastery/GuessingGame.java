package Mastery;

import java.util.Scanner;
import java.util.Random;

public class GuessingGame {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();

        // Step 1: Determine a secret number between 1 and 20
        int secretNumber = rand.nextInt(20) + 1;

        // Step 2: Prompt the player
        System.out.print("Enter a number between 1 and 20: ");
        int playerGuess = input.nextInt();

        // Step 3 + 4: Compare and show both numbers
        System.out.println("Secret number was: " + secretNumber);
        System.out.println("Your guess was: " + playerGuess);

        // Step 5: Display result
        if (playerGuess == secretNumber) {
            System.out.println("🎉 You won!");
        } else {
            System.out.println("Better luck next time.");
        }

        input.close();
    
    //screen dump:
        //Enter a number between 1 and 20: 9
        //Secret number was: 3
        //Your guess was: 9
        //Better luck next time.

    
    }
}