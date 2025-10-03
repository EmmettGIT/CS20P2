package Skillbuilders;

import java.util.Scanner;

public class skillbuild1 {

    public static void main(String[] args) {
        int numVisitors;
        int totalVisitors = 0;
        int avgVisitors;

        Scanner input = new Scanner(System.in);

        for (int day = 1; day <= 5; day++) {
            System.out.println(
                "Enter the number of visitors on day " + day + " : "
            );
            numVisitors = input.nextInt();
            totalVisitors = totalVisitors + numVisitors;
        } // end for loop

        avgVisitors = totalVisitors / 5;
        System.out.println("The average number of visitors is : " + avgVisitors);

        input.close();
    }
}