package Skillbuilders;

import java.util.Scanner;

public class Hurricane {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Ask user for hurricane category
        System.out.print("Enter a hurricane category (1-5): ");
        int category = input.nextInt();

        String mph = "";
        String kts = "";
        String kmh = "";

        // Match category with wind speed ranges
        switch (category) {
            case 1:
                mph = "74-95 mph";
                kts = "64-82 kt";
                kmh = "119-153 km/hr";
                break;
            case 2:
                mph = "96-110 mph";
                kts = "83-95 kt";
                kmh = "154-177 km/hr";
                break;
            case 3:
                mph = "111-130 mph";
                kts = "96-113 kt";
                kmh = "178-209 km/hr";
                break;
            case 4:
                mph = "131-155 mph";
                kts = "114-135 kt";
                kmh = "210-249 km/hr";
                break;
            case 5:
                mph = "greater than 155 mph";
                kts = "greater than 135 kt";
                kmh = "greater than 249 km/hr";
                break;
            default:
                System.out.println("Invalid category. Please enter a number from 1 to 5.");
                input.close();
                return; // Exit if invalid input
        }

        // Display results
        System.out.println("\nHurricane Category " + category + ":");
        System.out.println("Wind Speed (mph): " + mph);
        System.out.println("Wind Speed (kt): " + kts);
        System.out.println("Wind Speed (km/hr): " + kmh);

        input.close();
    }
}