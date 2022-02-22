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
public class BankingApplication 
{
    public static void main(String[] args)
    {
        System.out.println("Enter name: ");
        Scanner scan1 = new Scanner(System.in);
        String name = scan1.nextLine();
        System.out.println("Enter ID: ");
        String id = scan1.nextLine();
        System.out.println("=================================================");
        BankAccount a1 = new BankAccount(name, id);
        
        a1.Menu();
    }
}
