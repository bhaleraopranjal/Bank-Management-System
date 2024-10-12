package com.bank.account;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
    	
        Scanner sc = new Scanner(System.in);
        BankOperation bankOp = new BankOperation();
        
        System.out.println("\n+-------------------------------------------------------+\n|------------------Welcome to Our Bank------------------|\n+-------------------------------------------------------+");
        
        int mainChoice = 0;
        while (mainChoice != 3) {
        	
            System.out.print("\n\t\t\t1.Admin \n\t\t\t2.Customer \n\t\t\t3.Exit \nEnter your choice: ");
            mainChoice = sc.nextInt();
            
            switch (mainChoice) {
            
                case 1:
                    adminMenu(bankOp, sc);
                    break;
                    
                case 2:
                    customerMenu(bankOp, sc);
                    break;
                    
                case 3:
                    System.out.println("----------Thank You for using Our Bank-----------");
                    break;
                    
                default:
                    System.out.println("Invalid choice, please try again.");
                    break;
                    
            }
        }
        
        sc.close();
    }
    
    private static void adminMenu(BankOperation bankOp, Scanner sc) {
    	
        int choice = 0;
        while (choice != 4) {
        	
            System.out.print("\n\t\t\t1.Create Account \n\t\t\t2.Close Account \n\t\t\t3.End of Day Report \n\t\t\t4.Exit \nEnter your choice: ");
            choice = sc.nextInt();
            
            switch (choice) {
            
                case 1:
                    bankOp.createAccount();
                    break;
                    
                case 2:
                    bankOp.closeAccount();
                    break;
                    
                case 3:
                    bankOp.endOfDayReport();
                    break;
                    
                case 4:
                    return;
                    
                default:
                    System.out.println("Invalid choice, please try again.");
                    break;
                    
            }
        }
    }
   
    private static void customerMenu(BankOperation bankOp, Scanner sc) {
    	
        int choice = 0;
        while (choice != 2) 
        {
            System.out.print("\n\t\t\t1.Login \n\t\t\t2.Exit \nEnter your choice: ");
            choice = sc.nextInt();
            
            switch (choice) {
            
                case 1:
                    bankOp.login();
                    break;
                    
                case 2:
                    return;
                    
                default:
                    System.out.println("Invalid choice, please try again.");
                    break;
                    
            }
        }
    }
}
