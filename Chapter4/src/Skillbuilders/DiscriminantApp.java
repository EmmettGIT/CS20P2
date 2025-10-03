package Skillbuilders;

import java.util.Scanner;

public class DiscriminantApp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Prompt user for a, b, and c
        System.out.print("Enter the value for a: ");
        int a = input.nextInt();

        System.out.print("Enter the value for b: ");
        int b = input.nextInt();

        System.out.print("Enter the value for c: ");
        int c = input.nextInt();

        // Calculate discriminant
        int discriminant = b * b - 4 * a * c;

        // Check conditions
        if (discriminant < 0) {
            System.out.println("No roots");
        } else if (discriminant == 0) {
            System.out.println("One root");
        } else {
            System.out.println("Two roots");
        }

        input.close();
    }
}