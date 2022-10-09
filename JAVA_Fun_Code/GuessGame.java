
// I create a java class that allow user play "GuessGame"

import java.util.Random;
import java.util.Scanner;

public class GuessGame
{
    int userNumber;
    static int ranNumber;

    public static void main(String[] args)
    {
        boolean condition = false;
        Integer trial = 0;

        Random ran = new Random();
        ranNumber = ran.nextInt(100);

        GuessGame user = new GuessGame();
        while(!condition)
        {
            user.getNumber();
            condition= user.result();
            trial++;
        }
        System.out.println("You make the right choice with " + trial + " no. of trial");
    }

    void getNumber()
    {
        System.out.print("Guess the number:-- ");
          Scanner sc = new Scanner(System.in);
          userNumber = sc.nextInt();
    }

    boolean result()
    {
        if(ranNumber==userNumber)
        {
            System.out.println("You guess the right number !");
            return true;
        }
        else if(ranNumber<userNumber)
        {
            System.out.println("Your guess is bigger than the right number....Try again!");
        }
        else
        {
            System.out.println("Your guess is shorter than the right number....Try again!");
        }
        return false;
    }
}