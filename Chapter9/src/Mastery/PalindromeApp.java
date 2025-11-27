//HEADER
//Program: PalindromeApp.java   Last Date of this Revision: November 27, 2025

//Purpose: To allow the user to enter a word or phrase and determine whether it reads the same forwards and backwards, identifying it as a palindrome.

//Author: Emmett Stransky
//School: CHHS
//Course: Computer Programming 20

package Mastery;

import java.util.Scanner;

public class PalindromeApp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Prompt the user
        System.out.print("Enter a word or phrase: ");
        String original = input.nextLine();

        // Normalize the string: remove spaces + ignore case
        String cleaned = original.replaceAll(" ", "").toLowerCase();

        // Build reversed version
        String reversed = "";
        for (int i = cleaned.length() - 1; i >= 0; i--) {
            reversed += cleaned.charAt(i);
        }

        // Check palindrome
        if (cleaned.equals(reversed)) {
            System.out.println("\"" + original + "\" IS a palindrome.");
        } else {
            System.out.println("\"" + original + "\" is NOT a palindrome.");
        }
    }
}

/* SCREEN DUMP
Enter a word or phrase: Taco Cat
"Taco Cat" IS a palindrome.
Enter a word or phrase: Rotors
"Rotors" is NOT a palindrome.
*/