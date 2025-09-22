package Skillbuilders;

public class randomnumbers  // Class names should start with uppercase
{
    public static void main(String[] args) 
    {
        int randNum;              // Match the variable name
        int seqLength = 0;        // Fixed spelling (was seqLenght)

        do
        {
            randNum = (int)(11 * Math.random());   // randNum consistent

            System.out.print(randNum + " ");       // Fixed "printl" → "print"

            seqLength = seqLength + 1;             // Variable spelling fixed
        }
        while (randNum != 0);  // Fixed spacing (! = → !=)

        System.out.println("\nLength of sequence was " + seqLength);
    }
}