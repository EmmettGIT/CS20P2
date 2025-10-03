package Skillbuilders;

public class randomnumbers
{
    public static void main(String[] args) 
    {
        int randNum;
        int seqLength = 0;

        do
        {
            randNum = (int)(11 * Math.random());

            System.out.print(randNum + " ");

            seqLength = seqLength + 1;
        }
        while (randNum != 0);

        System.out.println("\nLength of sequence was " + seqLength);
    }
}