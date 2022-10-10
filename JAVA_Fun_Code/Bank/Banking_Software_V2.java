package com.PKD;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

import java.util.Scanner;

public class Banking_Software_V2
{
    static Banking_Software_V2 user1;

    static {
        try {
            user1 = new Banking_Software_V2();
        } catch (FilloException e) {
            throw new RuntimeException(e);
        }
    }

    Fillo fillo = new Fillo();
    Connection connection = fillo.getConnection("C:\\Users\\HP\\Desktop\\BankingSoftwareDatabase.xlsx");
    static int AccountNumber = 165000;
    public Banking_Software_V2() throws FilloException
    {
    }

    public boolean checkExcelData(String x, String y)throws FilloException
    {
        String strQuery= "SELECT Account_No.,Pin from Sheet1"; //Writing query similar to SQL.
        Recordset recordset = connection.executeQuery(strQuery);
        recordset.moveFirst();
        while(recordset.next())
        {
            if(recordset.getField("Account_No.").trim().equals(x) && recordset.getField("Pin").trim().equals(y))
            {
                return true;
            }
        }
        return false;
    }

    public void insertExcel(String a, String x, String y, String z)throws FilloException
    {
        String strQuery= "INSERT into Sheet1(Name,Account_No.,Security_Pin,Amount)VALUES('"+a+"','"+x+"','"+y+"','"+z+"')";
        connection.executeUpdate(strQuery);
        connection.close();
    }

    public void updateExcel()throws FilloException
    {
        String strQuery = "Update Sheet1 set ";
        connection.executeUpdate(strQuery);
        connection.close();
    }


    public static void main(String[] args) throws FilloException {
        boolean condition = false;
        do {
            System.out.println();
            System.out.println("Welcome to our P.K.BANK");
            System.out.println("Please select an option");
            System.out.println("1. Reset pin");
            System.out.println("2. Check Balance");
            System.out.println("3. Deposit Money");
            System.out.println("4. Withdraw Money");
            System.out.println("5. To Exit");
            System.out.println("10. To create new Bank Account");
            System.out.println();
            System.out.print("Enter your choice:-- ");
            String choice = user1.input();
            switch (choice)
            {
                case "1":
                    user1.resetPin();
                    break;
                case "2":
                    user1.checkBalance();
                    break;
                case "3":
                    user1.depositMoney();
                    break;
                case "4":
                    user1.withdrawMoney();
                    break;
                case "5":
                    System.out.println("You successfully exit the program!");
                    condition=user1.exit();
                    break;
                case "10":
                    System.out.println("You want to create a new bank account!");
                    System.out.println("Give us the required information....");
                    newAccountOpen();
                default:
                    System.out.println("You choose wrong option!...Try again! ");
            }
        }
        while(condition==false);
    }

    String input()
    {
        Scanner sc = new Scanner(System.in);
        String input=sc.nextLine();
        return input;
    }

    void resetPin() throws FilloException {
        boolean b = false;
        System.out.println("You want to reset pin !");
        System.out.print("Enter your account number:-- ");
        String accNum=user1.input();
        System.out.print("Enter your pin:-- ");
        String pin1 = user1.input();
        System.out.println();
        if (user1.checkExcelData(accNum,pin1)==true)
        {
            System.out.println("Enter your new pin: ");
            String newPin = user1.input();
            int length = newPin.length();
            if (length == 4)
            {
                //How to update the value of the variable...

                System.out.println("You successfully changed the pin! ");
            }
            else
                System.out.println("Security pin must be in 4 digits! ");
        }
        else
            System.out.println("You entered wrong Account Number && Pin ...Try gain!");
    }

    void checkBalance() throws FilloException
    {
        boolean b = false;
        System.out.println("You want to check balance!");
        System.out.print("Enter your account number:-- ");
        String accNum=user1.input();
        System.out.print("Enter your pin:-- ");
        String pin1 = user1.input();
        System.out.println();
        if (user1.checkExcelData(accNum,pin1)==true)
        {
            String strQuery= "SELECT * from Sheet1 where Pin = 'pin1'";                      //Is this right ?.........
            Recordset recordset = connection.executeQuery(strQuery);
            System.out.println("Your current balance is: $"+ recordset.getField("Amount"));
        }
        else
            System.out.println("You entered wrong pin...Try gain!");
    }

    void depositMoney() throws FilloException {
        System.out.println("You want to deposit money !");
        System.out.print("Enter your account number:-- ");
        String accNum=user1.input();
        System.out.print("Enter your pin:-- ");
        String pin1 = user1.input();
        System.out.println();
        if (user1.checkExcelData(accNum,pin1)==true)
        {
            //How to update the value of the variable...

            System.out.print("Enter the amount you want to deposit:-- ");
            String amount= user1.input();
            balance = balance+amount;
            System.out.println("Your current balance is: $"+balance);
        }
        else
            System.out.println("You entered wrong pin!...Try again");
    }

    void withdrawMoney() throws FilloException {
        System.out.println("You want to withdraw money !");
        System.out.print("Enter your account number:-- ");
        String accNum=user1.input();
        System.out.print("Enter your pin:-- ");
        String pin1 = user1.input();
        System.out.println();
        if (user1.checkExcelData(accNum,pin1)==true)
        {
            //How to update the value of the variable...
            System.out.print("Enter the amount you want to withdraw:-- ");
            String amount = user1.input();
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

    boolean exit()
    {
        return true;
    }

    static void newAccountOpen() throws FilloException
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your name:-- ");
        String AccountHolder = sc.nextLine();
        System.out.println("Your Account Number is:-- "+AccountNumber);
        AccountNumber++;
        System.out.print("Enter your security pin:-- ");
        String pin = user1.input();
        if (pin.length()==4)
        {
            String str = String.valueOf(AccountNumber);
            System.out.print("Enter the amount of money you want to deposit:-- ");
            String money= user1.input();
            user1.insertExcel(AccountHolder,str,pin,money);                //How to insert the value of the variable....
        }
        else
        {
            System.out.println("The security pin must contain 4 digits.....TRY AGAIN !");
        }
    }
}