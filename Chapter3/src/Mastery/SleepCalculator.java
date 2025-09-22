package Mastery;

import java.util.Scanner;

public class SleepCalculator {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Get birthdate
        System.out.println("Enter your birthdate:");
        System.out.print("Year: ");
        int birthYear = input.nextInt();
        System.out.print("Month: ");
        int birthMonth = input.nextInt();
        System.out.print("Day: ");
        int birthDay = input.nextInt();

        // Get today's date
        System.out.println("Enter today's date:");
        System.out.print("Year: ");
        int currentYear = input.nextInt();
        System.out.print("Month: ");
        int currentMonth = input.nextInt();
        System.out.print("Day: ");
        int currentDay = input.nextInt();

        // Calculate total days alive
        int daysAlive = calculateDaysAlive(birthYear, birthMonth, birthDay,
                                           currentYear, currentMonth, currentDay);

        // Calculate hours slept (8 hours per day)
        int hoursSlept = daysAlive * 8;

        // Output results
        System.out.println("You have been alive for " + daysAlive + " days.");
        System.out.println("You have slept " + hoursSlept + " hours.");

        input.close();
    }

    // Helper method to calculate days alive
    public static int calculateDaysAlive(int bYear, int bMonth, int bDay,
                                         int cYear, int cMonth, int cDay) {
        // Convert everything into days
        int birthTotalDays = (bYear * 365) + (bMonth * 30) + bDay;
        int currentTotalDays = (cYear * 365) + (cMonth * 30) + cDay;

        return currentTotalDays - birthTotalDays;
    }
}

//SCREEN DUMP:
//Enter your birthdate:
//Year: 2009
//Month: 09
//Day: 11
//Enter today's date:
//Year: 2025
//Month: 09
//Day: 19
//You have been alive for 5848 days.
//You have slept 46784 hours.