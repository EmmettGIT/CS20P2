package Skillbuilders;

import java.util.Scanner;

public class RectanglePerimeter 
{

	public static void main(String[] args)
	{

		// Declare variables
        int width;
        int length;
        
        try (// Create a Scanner object for reading input
		Scanner input = new Scanner(System.in)) {
			// Ask user for input
			System.out.print("Enter a width: ");
			width = input.nextInt();
			
			// Ask user for input
			System.out.print("Enter a length: ");
			length = input.nextInt();
		}
        
        // Calculate perimeter: P = 2 * (length + width)
        int perimeter = 2 * (length + width);
        
        // Display result
        System.out.println("Rectangle width: " + width);
        System.out.println("Rectangle length: " + length);
        System.out.println("Perimeter: " + perimeter);
		
	}

}
