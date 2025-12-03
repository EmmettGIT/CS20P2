//HEADER
//Program: SelectionSort.java   Last Date of this Revision: December 3, 2025

//Purpose: To generate a list of random numbers, sort them from lowest to highest using selection sort, and display the sorted results.

//Author: Emmett Stransky
//School: CHHS
//Course: Computer Programming 20

package Mastery;

import java.util.Scanner;
import java.util.Random;

public class SelectionSort {

    private int[] originalArray;
    private int[] sortedArray;

    // Constructor
    public SelectionSort(int[] arr) {
        originalArray = arr;
        sortedArray = new int[arr.length];
        sort();
    }

    public void display() {
        System.out.println("Sorted Array:");
        for (int n : sortedArray) {
            System.out.print(n + " ");
        }
        System.out.println();
    }
    
    private void sort() {
        int[] temp = new int[originalArray.length];
        System.arraycopy(originalArray, 0, temp, 0, originalArray.length);

        for (int i = 0; i < sortedArray.length; i++) {
            int lowIndex = findLowest(temp);
            sortedArray[i] = temp[lowIndex];
            temp[lowIndex] = Integer.MAX_VALUE; //shows its been used
        }
    }

    // Finds lowest index
    private int findLowest(int[] arr) {
        int lowIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[lowIndex]) {
                lowIndex = i;
            }
        }
        return lowIndex;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Random rand = new Random();

        System.out.print("How many values do you want in the array? ");
        int values = input.nextInt();

        int[] myNums = new int[values];

        // Fill random numbers (0–100)
        for (int i = 0; i < myNums.length; i++) {
            myNums[i] = rand.nextInt(101);
        }

        // Show original array
        System.out.println("Original Array:");
        for (int n : myNums) {
            System.out.print(n + " ");
        }
        System.out.println();

        // Create object and display sorted array
        SelectionSort sortedArray = new SelectionSort(myNums);
        sortedArray.display();
        
        input.close();
    }
}

/* SCREEN DUMP
How many values do you want in the array? 14
Original Array:
49 52 23 89 5 75 22 73 63 70 91 87 92 68 
Sorted Array:
5 22 23 49 52 63 68 70 73 75 87 89 91 92

How many values do you want in the array? 9
Original Array:
17 74 12 45 60 81 56 67 59 
Sorted Array:
12 17 45 56 59 60 67 74 81 
*/