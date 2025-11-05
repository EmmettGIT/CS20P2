package Mastery;

import java.util.Scanner;

public class GroupAssignment {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Ask user for first and last name
        System.out.print("Enter your first name: ");
        String firstName = input.nextLine();

        System.out.print("Enter your last name: ");
        String lastName = input.nextLine();

        // Get first letter of last name (converted to uppercase for consistency)
        char firstLetter = Character.toUpperCase(lastName.charAt(0));

        int groupNumber;

        // Determine the group based on the first letter
        if (firstLetter >= 'A' && firstLetter <= 'I') {
            groupNumber = 1;
        } else if (firstLetter >= 'J' && firstLetter <= 'S') {
            groupNumber = 2;
        } else if (firstLetter >= 'T' && firstLetter <= 'Z') {
            groupNumber = 3;
        } else {
            // In case of invalid input (like non-alphabet characters)
            System.out.println("Invalid last name. Please enter alphabetic characters only.");
            input.close();
            return;
        }

        // Display the result
        System.out.println(firstName + " " + lastName + " is assigned to Group " + groupNumber);

        input.close();
    }
}

/*SCREEN DUMP
Enter your first name: Chris
Enter your last name: Peacock
Chris Peacock is assigned to Group 2
*/
