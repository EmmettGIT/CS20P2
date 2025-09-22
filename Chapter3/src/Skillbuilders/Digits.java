package Skillbuilders;

import java.util.Scanner;

public class Digits {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Prompt user
        System.out.print("Enter a two-digit number: ");
        int number = input.nextInt();

        // Separate digits
        int ones = number % 10;       // remainder gives ones place
        int tens = number / 10;       // integer division gives tens place

        // Display results
        System.out.println("Tens place: " + tens);
        System.out.println("Ones place: " + ones);

        input.close();
    }
}