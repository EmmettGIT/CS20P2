//HEADER
//Program: Game21.java   Last Date of this Revision: November 19, 2025

//Purpose: The purpose of the program is to let the user play a simplified blackjack-style Game of 21 against the computer, drawing cards until choosing to stop or until they bust.

//Author: Emmett Stransky
//School: CHHS
//Course: Computer Programming 20

package Mastery;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game21 {

    // ------------------ Card Class ------------------
    static class Card {
        private int number;
        private int value;

        public Card(int number) {
            this.number = number;

            if (number == 1) {              // Ace
                value = 11;
            } else if (number >= 11) {      // Jack, Queen, King
                value = 10;
            } else {
                value = number;             // 2–10
            }
        }

        public int getValue() {
            return value;
        }

        public int getNumber() {
            return number;
        }

        public boolean isAce() {
            return number == 1;
        }
    }

    // ------------------ Deck Class ------------------
    static class Deck {
        private Random rand = new Random();

        public Card dealCard() {
            return new Card(rand.nextInt(13) + 1);
        }
    }

    // ------------------ Hand Class ------------------
    static class Hand {
        private ArrayList<Card> cards = new ArrayList<>();

        public void addCard(Card c) {
            cards.add(c);
        }

        public int getBestScore() {
            int total = 0;
            int aceCount = 0;

            for (Card c : cards) {
                total += c.getValue();
                if (c.isAce()) {
                    aceCount++;
                }
            }

            // Correct ace values if needed
            while (total > 21 && aceCount > 0) {
                total -= 10;  // change Ace from 11 -> 1
                aceCount--;
            }

            return total;
        }

        public String toString() {
            String result = "";
            for (Card c : cards) {
                int n = c.getNumber();
                if (n == 1) result += "Ace ";
                else if (n == 11) result += "Jack ";
                else if (n == 12) result += "Queen ";
                else if (n == 13) result += "King ";
                else result += n + " ";
            }
            return result.trim();
        }
    }

    // ------------------ Player Class ------------------
    static class Player {
        private Hand hand = new Hand();

        public void addCard(Card c) {
            hand.addCard(c);
        }

        public int getScore() {
            return hand.getBestScore();
        }

        public String getHand() {
            return hand.toString();
        }
    }

    // ------------------ Computer Class ------------------
    static class Computer {
        private Hand hand = new Hand();

        public void addCard(Card c) {
            hand.addCard(c);
        }

        public int getScore() {
            return hand.getBestScore();
        }

        public String getHand() {
            return hand.toString();
        }

        public boolean shouldHit() {
            return getScore() < 16; // simple rule
        }
    }

    // ------------------ MAIN GAME ------------------
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Deck deck = new Deck();

        boolean playAgain = true;

        while (playAgain) {
            Player player = new Player();
            Computer computer = new Computer();

            System.out.println("\n--- Game of 21 ---");

            // Initial 2 cards
            player.addCard(deck.dealCard());
            player.addCard(deck.dealCard());

            // -------- Player Turn (Unlimited Hits) --------
            boolean playerDone = false;

            while (!playerDone) {
                System.out.println("\nYour hand: " + player.getHand() +
                        " (Score: " + player.getScore() + ")");

                if (player.getScore() > 21) {
                    System.out.println("You busted!");
                    break;
                }

                System.out.print("Hit or Stay? (h/s): ");
                String choice = input.nextLine();

                if (choice.equalsIgnoreCase("h")) {
                    player.addCard(deck.dealCard());
                } else {
                    playerDone = true;
                }
            }

            // -------- Computer Turn --------
            while (computer.shouldHit()) {
                computer.addCard(deck.dealCard());
            }

            System.out.println("\nComputer's hand: " + computer.getHand() +
                    " (Score: " + computer.getScore() + ")");

            int pScore = player.getScore();
            int cScore = computer.getScore();

            // -------- Determine Winner --------
            System.out.println("\n--- Result ---");

            if (pScore > 21 && cScore > 21) {
                System.out.println("Both busted! No winner.");
            } else if (pScore > 21) {
                System.out.println("You busted! Computer wins.");
            } else if (cScore > 21) {
                System.out.println("Computer busted! You win!");
            } else if (pScore > cScore) {
                System.out.println("You win!");
            } else if (cScore > pScore) {
                System.out.println("Computer wins.");
            } else {
                System.out.println("It's a tie!");
            }

            // -------- Play Again? --------
            System.out.print("\nPlay again? (y/n): ");
            playAgain = input.nextLine().equalsIgnoreCase("y");
        }

        System.out.println("\nThanks for playing!");
        input.close();
    }
}

//--- Game of 21 ---
//Your hand: 7 King (Score: 17)
//Hit or Stay? (h/s): h

//Your hand: 7 King 3 (Score: 20)
//Hit or Stay? (h/s): h

//Your hand: 7 King 3 4 (Score: 24)
//You busted!

//Computer's hand: 9 Ace (Score: 20)

//--- Result ---
//You busted! Computer wins.

//Play again? (y/n): y


//--- Game of 21 ---
//Your hand: 5 6 (Score: 11)
//Hit or Stay? (h/s): h

//Your hand: 5 6 8 (Score: 19)
//Hit or Stay? (h/s): s

//Computer's hand: 10 2 5 (Score: 17)

//--- Result ---
//You win!

//Play again? (y/n): y


//--- Game of 21 ---
//Your hand: Ace 7 (Score: 18)
//Hit or Stay? (h/s): s

//Computer's hand: 4 King 6 (Score: 20)

//--- Result ---
//Computer wins.

//Play again? (y/n): n

//Thanks for playing!
