package Mastery;

import java.util.Scanner;

public class Eggs {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Prompt user
        System.out.print("Enter the number of eggs purchased: ");
        int eggs = input.nextInt();

        // Calculate dozens and extras
        int dozens = eggs / 12;
        int extras = eggs % 12;

        // Determine per-dozen price
        double pricePerDozen;
        if (dozens < 4) {
            pricePerDozen = 0.50;
        } else if (dozens < 6) {
            pricePerDozen = 0.45;
        } else if (dozens < 11) {
            pricePerDozen = 0.40;
        } else {
            pricePerDozen = 0.35;
        }

        // Calculate bill
        double total = (dozens * pricePerDozen) + (extras * (pricePerDozen / 12));

        // Display result
        System.out.printf("The bill is equal to: $%.2f%n", total);

        input.close();
    
    //Enter the number of eggs purchased: 18
    //The bill is equal to: $0.75
    
    }
}