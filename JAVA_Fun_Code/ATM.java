

import java.util.Scanner;

public class ATM
{
    int pin=4321;
    int balance=10000;
    static ATM user = new ATM();
    public static void main(String[] args)
    {
        boolean condition= false;
        do {
            System.out.println();
            System.out.println("Welcome to our ATM");
            System.out.println("Please select an option");
            System.out.println("1. Reset pin");
            System.out.println("2. Check Balance");
            System.out.println("3. Deposit Money");
            System.out.println("4. Withdraw Money");
            System.out.println("5. To Exit");
            System.out.println();
            System.out.print("Enter your choice:-- ");
            int choice = user.input();
            switch (choice)
            {
                case 1:
                    user.resetPin();
                    break;
                case 2:
                    user.checkBalance();
                    break;
                case 3:
                    user.depositMoney();
                    break;
                case 4:
                    user.withdrawMoney();
                    break;
                case 5:
                     System.out.println("You successfully exit the program!");
                     condition=user.exit();
                     break;
                default:
                    System.out.println("You choose wrong option!...Try again! ");
            }
        }
        while(condition==false);
    }
    int input()
    {
        Scanner sc = new Scanner(System.in);
        int input=sc.nextInt();
        return input;
    }
    void checkBalance()
    {
        System.out.println("You want to check your balance !");
        System.out.print("Enter your pin:-- ");
        int pin1 = user.input();
        if (pin==pin1)
        {
            System.out.println("Your current balance is: $"+balance);
        }
        else
            System.out.println("You entered wrong pin...Try gain!");
    }
    void depositMoney()
    {
        System.out.println("You want to deposit money !");
        System.out.print("Enter your pin:-- ");
        int pin1 = user.input();
        System.out.println();
        if (pin==pin1)
        {
            System.out.print("Enter the amount you want to deposit:-- ");
            int amount= user.input();
            balance = balance+amount;
            System.out.println("Your current balance is: $"+balance);
        }
        else
            System.out.println("You entered wrong pin!...Try again");
    }
    void withdrawMoney()
    {
        System.out.println("You want to withdraw money !");
        System.out.print("Enter your pin:-- ");
        int pin1 = user.input();
        System.out.println();
        if (pin==pin1)
        {
            System.out.print("Enter the amount you want to withdraw:-- ");
            int amount = user.input();
            if (balance < amount)
                System.out.println("Your account balance is insufficient! ");
            else if (balance == amount)
                System.out.println("You can not withdraw full amount! ");
            else
            {
                balance = balance - amount;
                System.out.println("Your withdraw: $" + amount);
                System.out.println("Your current balance is: $" + balance);
            }
        }
        else
            System.out.println("You entered wrong pin!...Try again");
    }
    void resetPin()
    {
        System.out.println("You want to reset pin !");
        System.out.print("Enter your pin:-- ");
        int pin2 = user.input();
        if (pin==pin2)
        {
            System.out.println("Enter your new pin: ");
            int newPin = user.input();
            int length = (int) (Math.log10(newPin) + 1);
            if (length == 4)
            {
                pin = newPin;
                System.out.println("You successfully changed the pin! ");
            }
            else
                System.out.println("Security pin must be in 4 digits! ");
        }
        else
            System.out.println("You entered wrong pin...Try gain!");
    }
    boolean exit()
    {
        return true;
    }
}