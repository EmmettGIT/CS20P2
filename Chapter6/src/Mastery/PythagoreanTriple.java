package Mastery;

public class PythagoreanTriple {
    public static void main(String[] args) {
        int a, b, c;

        System.out.println("Pythagorean Triples (A and B less than 100):");
        System.out.println("____________________________________________");
        System.out.println(" ");

        for (a = 1; a < 100; a++) {
            for (b = 1; b < 100; b++) {
                int sumOfSquares = a * a + b * b;
                if (PerfectSquare(sumOfSquares)) {
                    c = (int) Math.sqrt(sumOfSquares);
                    System.out.printf("A = %d, B = %d, C = %d%n", a, b, c);
                }
            }
        }
    }

    public static boolean PerfectSquare(int number) {
        int sqrt = (int) Math.sqrt(number);
        return sqrt * sqrt == number;
    }
}

/* SCREEN DUMP
Pythagorean Triples (A and B less than 100):
____________________________________________
 
A = 3, B = 4, C = 5
A = 4, B = 3, C = 5
A = 5, B = 12, C = 13
A = 6, B = 8, C = 10
A = 7, B = 24, C = 25
A = 8, B = 6, C = 10
A = 8, B = 15, C = 17
A = 9, B = 12, C = 15
A = 9, B = 40, C = 41
A = 10, B = 24, C = 26
A = 11, B = 60, C = 61
A = 12, B = 5, C = 13
A = 12, B = 9, C = 15
A = 12, B = 16, C = 20
A = 12, B = 35, C = 37
A = 13, B = 84, C = 85
A = 14, B = 48, C = 50
A = 15, B = 8, C = 17
A = 15, B = 20, C = 25
A = 15, B = 36, C = 39
A = 16, B = 12, C = 20
A = 16, B = 30, C = 34
A = 16, B = 63, C = 65
A = 18, B = 24, C = 30
A = 18, B = 80, C = 82
A = 20, B = 15, C = 25
A = 20, B = 21, C = 29
A = 20, B = 48, C = 52
A = 20, B = 99, C = 101
A = 21, B = 20, C = 29
A = 21, B = 28, C = 35
A = 21, B = 72, C = 75
A = 24, B = 7, C = 25
A = 24, B = 10, C = 26
A = 24, B = 18, C = 30
A = 24, B = 32, C = 40
A = 24, B = 45, C = 51
A = 24, B = 70, C = 74
A = 25, B = 60, C = 65
A = 27, B = 36, C = 45
A = 28, B = 21, C = 35
A = 28, B = 45, C = 53
A = 28, B = 96, C = 100
A = 30, B = 16, C = 34
A = 30, B = 40, C = 50
A = 30, B = 72, C = 78
A = 32, B = 24, C = 40
A = 32, B = 60, C = 68
A = 33, B = 44, C = 55
A = 33, B = 56, C = 65
A = 35, B = 12, C = 37
A = 35, B = 84, C = 91
A = 36, B = 15, C = 39
A = 36, B = 27, C = 45
A = 36, B = 48, C = 60
A = 36, B = 77, C = 85
A = 39, B = 52, C = 65
A = 39, B = 80, C = 89
A = 40, B = 9, C = 41
A = 40, B = 30, C = 50
A = 40, B = 42, C = 58
A = 40, B = 75, C = 85
A = 40, B = 96, C = 104
A = 42, B = 40, C = 58
A = 42, B = 56, C = 70
A = 44, B = 33, C = 55
A = 45, B = 24, C = 51
A = 45, B = 28, C = 53
A = 45, B = 60, C = 75
A = 48, B = 14, C = 50
A = 48, B = 20, C = 52
A = 48, B = 36, C = 60
A = 48, B = 55, C = 73
A = 48, B = 64, C = 80
A = 48, B = 90, C = 102
A = 51, B = 68, C = 85
A = 52, B = 39, C = 65
A = 54, B = 72, C = 90
A = 55, B = 48, C = 73
A = 56, B = 33, C = 65
A = 56, B = 42, C = 70
A = 56, B = 90, C = 106
A = 57, B = 76, C = 95
A = 60, B = 11, C = 61
A = 60, B = 25, C = 65
A = 60, B = 32, C = 68
A = 60, B = 45, C = 75
A = 60, B = 63, C = 87
A = 60, B = 80, C = 100
A = 60, B = 91, C = 109
A = 63, B = 16, C = 65
A = 63, B = 60, C = 87
A = 63, B = 84, C = 105
A = 64, B = 48, C = 80
A = 65, B = 72, C = 97
A = 66, B = 88, C = 110
A = 68, B = 51, C = 85
A = 69, B = 92, C = 115
A = 70, B = 24, C = 74
A = 72, B = 21, C = 75
A = 72, B = 30, C = 78
A = 72, B = 54, C = 90
A = 72, B = 65, C = 97
A = 72, B = 96, C = 120
A = 75, B = 40, C = 85
A = 76, B = 57, C = 95
A = 77, B = 36, C = 85
A = 80, B = 18, C = 82
A = 80, B = 39, C = 89
A = 80, B = 60, C = 100
A = 80, B = 84, C = 116
A = 84, B = 13, C = 85
A = 84, B = 35, C = 91
A = 84, B = 63, C = 105
A = 84, B = 80, C = 116
A = 88, B = 66, C = 110
A = 90, B = 48, C = 102
A = 90, B = 56, C = 106
A = 91, B = 60, C = 109
A = 92, B = 69, C = 115
A = 96, B = 28, C = 100
A = 96, B = 40, C = 104
A = 96, B = 72, C = 120
A = 99, B = 20, C = 101
*/