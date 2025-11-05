package Mastery;

import java.util.Random;

public class RandomWalk {
    public static void main(String[] args) {
        final int BRIDGE_LENGTH = 7;
        final int TRIALS = 50;
        Random rand = new Random();

        int totalSteps = 0;
        int maxSteps = 0;

        for (int trial = 1; trial <= TRIALS; trial++) {
            int position = BRIDGE_LENGTH / 2; 
            int steps = 0;

            
            while (position >= 0 && position < BRIDGE_LENGTH) {
                int direction = rand.nextInt(2); // 0 or 1
                if (direction == 0)
                    position++; // forward
                else
                    position--; // backward

                steps++;
            }

            totalSteps += steps;
            if (steps > maxSteps)
                maxSteps = steps;
        }

        double averageSteps = (double) totalSteps / TRIALS;

        System.out.printf("Average steps before falling off: %.2f%n", averageSteps);
        System.out.println("Greatest number of steps: " + maxSteps);
    }
}

//SCREEN DUMP
//Average steps before falling off: 14.52
//Greatest number of steps: 50
