

import java.util.Scanner;

import java.util.Random;

public class RockPaperScissor
{
    public static void main(String[] args)
    {
        RockPaperScissor output = new RockPaperScissor();
        Scanner user = new Scanner(System.in);
        System.out.println("INSTRUCTION OF THE GAME IS :--------");
        System.out.println("1 is for Rock ....");
        System.out.println("2 is for Paper ...");
        System.out.println("3 is for Scissor .");
        System.out.print("You choose: ");
        int num = user.nextInt();
        output.game(num);
    }
    void game(int num)
    {
        Random ran = new Random();
        int com = ran.nextInt(3);
        System.out.println("The computer choose: "+ com);
        System.out.println();
        if((com==1 && num==2)||(com==2 && num==3)||(com==3||num==1))
        {
            System.out.println("YOU WIIIIIN !!");
        }
        else if(com==num)
        {
            System.out.println("IT'S A DRAW !");
        }
        else
        {
            System.out.println("YOU LOSE !");
        }
    }
}
