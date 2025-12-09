/*
HEADER
Program: TugOfWar.java   Last Date of this Revision: December 9, 2025

Purpose: To create a two-player tug-of-war game where each player races
		 to press their button 10 times, and the winner is shown by flashing both LEDs once and then the winner’s LED five times.

Author: Emmett Stransky
School: CHHS
Course: Computer Programming 20
*/

// add phidgets library
import com.phidget22.*;

public class TugOfWar {
    public static void main(String[] args) throws Exception {

        // devices
        DigitalOutput redLED = new DigitalOutput();
        DigitalOutput greenLED = new DigitalOutput();
        DigitalInput redButton = new DigitalInput();
        DigitalInput greenButton = new DigitalInput();

        // addressing
        redLED.setHubPort(1);
        redLED.setIsHubPortDevice(true);

        greenLED.setHubPort(4);
        greenLED.setIsHubPortDevice(true);

        redButton.setHubPort(0);
        redButton.setIsHubPortDevice(true);

        greenButton.setHubPort(5);
        greenButton.setIsHubPortDevice(true);

        // opening
        redLED.open(1000);
        greenLED.open(1000);
        redButton.open(1000);
        greenButton.open(1000);

        int redCount = 0;
        int greenCount = 0;

        boolean lastRed = false;
        boolean lastGreen = false;

        System.out.println("Game Start! First to 10 presses wins!");

        // loop
        while (true) {
            // read button states
            boolean r = redButton.getState();
            boolean g = greenButton.getState();

            // detect rising edge: button goes from false to true
            if (r && !lastRed) {
                redCount++;
                System.out.println("Red pressed: " + redCount);
            }
            if (g && !lastGreen) {
                greenCount++;
                System.out.println("Green pressed: " + greenCount);
            }

            lastRed = r;
            lastGreen = g;

            // check win conditions
            if (redCount >= 10) {
                System.out.println("RED WINS!");
                winnerFlash(redLED, greenLED, true);
                break;
            }
            if (greenCount >= 10) {
                System.out.println("GREEN WINS!");
                winnerFlash(redLED, greenLED, false);
                break;
            }

            Thread.sleep(20); // small delay for stable reading
        }
    }

    // flash sequence
    public static void winnerFlash(DigitalOutput redLED, DigitalOutput greenLED, boolean redWins) throws Exception{

        // flash both LEDs once
        redLED.setState(true);
        greenLED.setState(true);
        Thread.sleep(500);
        redLED.setState(false);
        greenLED.setState(false);
        Thread.sleep(500);

        // flash winner 5 times
        DigitalOutput winner = redWins ? redLED : greenLED;

        for (int i = 0; i < 5; i++) {
            winner.setState(true);
            Thread.sleep(300);
            winner.setState(false);
            Thread.sleep(300);
        }
    }
}

/*
SCREEN DUMP
Game Start! First to 10 presses wins!
Red pressed: 1
Green pressed: 1
Red pressed: 2
Green pressed: 2
Green pressed: 3
Red pressed: 3
Green pressed: 4
Red pressed: 4
Green pressed: 5
Red pressed: 5
Green pressed: 6
Green pressed: 7
Green pressed: 8
Green pressed: 9
Red pressed: 6
Green pressed: 10
GREEN WINS!
*/