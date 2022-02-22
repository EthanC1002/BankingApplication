/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BankingApplication;

/**
 *
 * @author ethan
 */
import java.util.*;
public class BankAccount 
{
    private double balance;
    private String customerName;
    private String customerId;
    ArrayList<Double> prevTran = new ArrayList<>();
    Scanner scan1 = new Scanner(System.in);
    char option;
    BankAccount(String name, String id)
    {
        customerName = name;
        customerId = id;
    }
    
    //Deposit
    public void deposit(double deposit)
    {
        if (deposit > 0)
        {
            balance += deposit;
            prevTran.add(deposit);
        }
    }
    
    //Withdraw
    public void withdrawal(double withdrawal)
    {
        if (withdrawal > 0)
        {
            balance -= withdrawal;
            prevTran.add(-withdrawal);
        }
    }
    
    //Check Previous Transaction
    public void transactions()
    {
        for (int i = 0; i<prevTran.size(); i++)
        {
            if (prevTran.get(i) < 0)
            {
                System.out.println("Withdrawal: Transaction " + (i+1) + ": " + prevTran.get(i));
            } else 
            {
                System.out.println("Deposit: Transaction " + (i+1) + ": " + prevTran.get(i));
            }
        }
    }
    
    public void pick ()
    {
        System.out.println("Pick another option: ");
        option = scan1.next().charAt(0);
    }
    
    public void options()
    {
        while (option != 'e')
        {
            switch(option)
            {
                case 'c':
                    System.out.println("Account Balance: $" + balance);
                    pick();
                    break;
                case 'd':
                    System.out.println("How much would you like to deposit? Type dollar amount: ");
                    double amnt = scan1.nextDouble();
                    deposit(amnt);
                    pick();
                    break;
                case 'w':
                    System.out.println("How much would you like to withdraw? Type dollar amount: ");
                    amnt = scan1.nextDouble();
                    withdrawal(amnt);
                    pick();
                    break;
                case 't':
                    transactions();
                    pick();
                    break;
            }
        }
        if (option == 'e')
        {
            System.out.println("You have logged out.");
        } 
    }
    
    //Menu
    public void Menu()
    {
        System.out.println("Welcome " + customerName);
        System.out.println("Your ID: " + customerId);
        System.out.println();
        System.out.println("To check balance: type 'c'");
        System.out.println("To make deposit: type 'd'");
        System.out.println("To make withdrawal: type 'w'");
        System.out.println("To check transaction history: type 't'");
        System.out.println("To exit: type 'e'");
        System.out.println();
        System.out.println("=================================================");
        System.out.println("Enter an option: ");
        option = scan1.next().charAt(0);
        
       options();
    }
}
