package Mastery;
import java.util.Scanner;

public class CollegeCalculator {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("=== College Cost Calculator ===");

        // Expenses
        System.out.print("Enter yearly tuition cost: ");
        double tuition = input.nextDouble();

        System.out.print("Enter yearly rent cost: ");
        double rent = input.nextDouble();

        System.out.print("Enter yearly food cost: ");
        double food = input.nextDouble();

        System.out.print("Enter yearly transportation cost: ");
        double transportation = input.nextDouble();

        System.out.print("Enter yearly books/supplies cost: ");
        double books = input.nextDouble();

        System.out.print("Enter other expenses (entertainment, clothing, etc.): ");
        double otherExpenses = input.nextDouble();

        // Offsets
        System.out.print("Enter scholarship amount: ");
        double scholarships = input.nextDouble();

        System.out.print("Enter bursary/grant amount: ");
        double bursary = input.nextDouble();

        System.out.print("Enter part-time job income: ");
        double jobIncome = input.nextDouble();

        System.out.print("Enter other offset costs (family support, etc.): ");
        double otherOffsets = input.nextDouble();

        // Calculate totals
        double totalExpenses = tuition + rent + food + transportation + books + otherExpenses;
        double totalOffsets = scholarships + bursary + jobIncome + otherOffsets;
        double netCost = totalExpenses - totalOffsets;

        // Output results
        System.out.println("\n=== Summary ===");
        System.out.println("Total Expenses: $" + totalExpenses);
        System.out.println("Total Offsets: $" + totalOffsets);

        if (netCost > 0) {
            System.out.println("You will need: $" + netCost + " for your school year.");
        } else if (netCost == 0) {
            System.out.println("Your costs are fully covered. Net cost = $0.");
        } else {
            System.out.println("Congratulations! You have a surplus of $" + Math.abs(netCost) + ".");
        }

        input.close();
    }
}

//=== College Cost Calculator ===
//Enter yearly tuition cost: 20000
//Enter yearly rent cost: 2000
//Enter yearly food cost: 7000
//Enter yearly transportation cost: 1000
//Enter yearly books/supplies cost: 1000
//Enter other expenses (entertainment, clothing, etc.): 1
//Enter scholarship amount: 1
//Enter bursary/grant amount: 2
//Enter part-time job income: 14
//Enter other offset costs (family support, etc.): 10

//=== Summary ===
//Total Expenses: $31001.0
//Total Offsets: $27.0
//You will need: $30974.0 for your school year.