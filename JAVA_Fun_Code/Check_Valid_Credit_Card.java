

import java.util.Scanner;         /* If this doesn't work, then
                                   User given number will be stored into a String variable, then I will transform
                                   that variable into Int Array...*/

public class Check_Valid_Credit_Card
{
    String userNumber;

    public static void main(String[] args)
    {
        Check_Valid_Credit_Card user = new Check_Valid_Credit_Card();
        user.getNumber();
        user.checkNumber();
    }

    void getNumber()
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your credit number:---");
        userNumber = sc.next();
    }

    void checkNumber()
    {
        int[] arr1;
        int sum1=0;
        int sum2=0;
        int sum3=0;
        int totalNumber=0;
        arr1 = new int[userNumber.length()];
        for (int i=0; i<userNumber.length(); i++) {
            arr1[i] = Integer.parseInt(userNumber.substring(i, i + 1));
        }
        if (arr1.length==13 || arr1.length==16)
        {
            if (arr1[0]==4 || arr1[0]==5 || (arr1[0]==3 && arr1[1]==7) || arr1[0]==6)
            {
                for (int i=(arr1.length)-1; i>=0 ; i--)
                {
                    if (i%2==0)
                    {
                        int a=arr1[i];
                        a=a*2;
                        if (a>=10)
                        {
                           sum1=sum1+a%10+1;
                        }
                        else if(a<10)
                        {
                            sum2=sum2+a;
                        }
                    }
                    else if(i%2!=0)
                    {
                        sum3=sum3+arr1[i];
                    }
                }

                totalNumber = sum1+sum2+sum3;

                if (totalNumber%10==0)
                {
                    System.out.println("Your Credit card number is valid !");
                }
                else if (totalNumber%10!=0)
                {
                    System.out.println("Your Credit card number is not valid !");
                }

            }
            else
            {
                System.out.println("It's wrong.....You don't have VISA CARD, MASTER CARD, AMERICAN EXPRESS, DISCOVER CARD !");
            }
        }
        else
            {
                System.out.println("It's wrong....you credit card number doesn't have right numbers of digits !");
            }
    }
}

