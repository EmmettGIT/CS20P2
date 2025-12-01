package Mastery;

import java.util.Scanner;

public class CourseGrades {

    public static void main(String[] args) {
        GradeBook gb = new GradeBook();
        gb.getGrades();      // prompt for all grades
        gb.showGrades();     // display grade grid

        Scanner scanner = new Scanner(System.in);

        System.out.print("\nEnter a student number (1–12) to see their average: ");
        int studentNum = scanner.nextInt() - 1;   // convert to 0-based
        System.out.println("Average for student " + (studentNum + 1) + ": " + gb.studentAvg(studentNum));

        System.out.print("\nEnter a test number (1–5) to see its average: ");
        int testNum = scanner.nextInt() - 1;      // convert to 0-based
        System.out.println("Average for test " + (testNum + 1) + ": " + gb.testAvg(testNum));
    }
}

class GradeBook {

    private int[][] grades;  // 12 students × 5 tests

    public GradeBook() {
        grades = new int[12][5];
    }

    // Get all grades from user (Student 1–12, Test 1–5)
    public void getGrades() {
        Scanner scanner = new Scanner(System.in);

        for (int student = 0; student < 12; student++) {
            System.out.println("\nEnter 5 test grades for Student " + (student + 1) + ":");
            for (int test = 0; test < 5; test++) {
                System.out.print("  Test " + (test + 1) + ": ");
                grades[student][test] = scanner.nextInt();
            }
        }
    }

    // Display all grades nicely
    public void showGrades() {
        System.out.println("\nGRADE BOOK");
        System.out.println("Student | Test1  Test2  Test3  Test4  Test5");

        for (int student = 0; student < 12; student++) {
            System.out.print("   " + (student + 1) + "    | ");
            for (int test = 0; test < 5; test++) {
                System.out.print(grades[student][test] + "     ");
            }
            System.out.println();
        }
    }

    // Average for one student
    public double studentAvg(int studentNum) {
        double sum = 0;
        for (int test = 0; test < 5; test++) {
            sum += grades[studentNum][test];
        }
        return sum / 5.0;
    }

    // Average for one test
    public double testAvg(int testNum) {
        double sum = 0;
        for (int student = 0; student < 12; student++) {
            sum += grades[student][testNum];
        }
        return sum / 12.0;
    }
}
