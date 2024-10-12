package com.bank.account;

import java.time.LocalDate;
import java.util.Scanner;

public class BankOperation {

    private int size = 10;
    private int ctr = 0;
    private BankAccount[] bank = new BankAccount[size];
    private Scanner sc = new Scanner(System.in);
    
    private Transaction[] transactions = new Transaction[100];

    public void createAccount() {
        if (ctr < size) {
            int choice = 0;
            while (choice != 5) {
                System.out.print("\n\t\t\t1.Saving Account \n\t\t\t2.Current Account \n\t\t\t3.Salary Account \n\t\t\t4.Loan Account \n\t\t\t5.Exit \nEnter your choice: ");
                choice = sc.nextInt();

                int accNo;
                String name;
                double balance;

                switch (choice) {
                    case 1:
                        accNo = ++ctr;
                        
                        System.out.print("\nEnter account holder name: ");
                        sc.nextLine();
                        name = sc.nextLine();
                        
                        System.out.print("\nEnter Balance: ");
                        balance = sc.nextDouble();
                        
                        bank[ctr] = new SavingAccount(accNo, name, balance);
                        break;

                    case 2:
                        accNo = ++ctr;
                        
                        System.out.print("\nEnter account holder name: ");
                        sc.nextLine();
                        name = sc.nextLine();
                        
                        System.out.print("\nEnter Balance: ");
                        balance = sc.nextDouble();
                        
                        bank[ctr] = new CurrentAccount(accNo, name, balance);
                        break;

                    case 3:
                        accNo = ++ctr;
                        
                        System.out.print("\nEnter account holder name: ");
                        sc.nextLine(); 
                        name = sc.nextLine();
                        
                        System.out.print("\nEnter Balance: ");
                        balance = sc.nextDouble();
                        
                        bank[ctr] = new SalaryAccount(accNo, name, balance);
                        break;

                    case 4:
                        accNo = ++ctr;
                        
                        System.out.print("\nEnter account holder name: ");
                        sc.nextLine(); 
                        name = sc.nextLine();
                        
                        System.out.print("\nEnter Balance: ");
                        balance = sc.nextDouble();
                        
                        System.out.print("\nEnter how many months you want: ");
                        int months = sc.nextInt();
                        
                        bank[ctr] = new LoanAccount(accNo, name, balance, months);
                        break;

                    case 5:
                        break;

                    default:
                        System.out.println("Invalid choice");
                        break;
                }
            }
        } else {
            System.out.print("\nYou cannot create account \nAccount limit exceed");
        }
    }

    public void login() {
    	
        System.out.print("\nEnter your account number: ");
        int acc = sc.nextInt();

        int index = searchAccount(acc);

        if (index == -1) 
        {
            System.out.println("\nAccount not found \nLogin failed");
        } 
        else 
        {
            int choice = 0;
            while (choice != 10) 
            {
                System.out.print("\n\t\t\t1.Withdraw amount \n\t\t\t2.Deposit amount \n\t\t\t3.Check Account details \n\t\t\t4.Check Interest \n\t\t\t5.Check EMI \n\t\t\t10.Exit \nEnter which operation you want to perform: ");
                choice = sc.nextInt();

                switch (choice) 
                {
                    case 1:
                    	System.out.println("\nDear " + bank[index].getName() + "," + "\n\tEnter how much amount you want to withdraw: ");
                        double withdrawAmount = sc.nextDouble();
                        
                        bank[index].withdraw(withdrawAmount);
                        
                        addTransaction(new Transaction("Withdrawal", withdrawAmount));
                        break;

                    case 2:
                    	System.out.println("\nDear " + bank[index].getName() + "," + "\n\tEnter how much amount you want to deposit: ");
                        double depositAmount = sc.nextDouble();
                        
                        addTransaction(new Transaction("Deposit", depositAmount));
                        
                        bank[index].deposit(depositAmount);
                        break;

                    case 3:
                        bank[index].display();
                        
                        System.out.println("\nAccount Type: " + bank[index].getClass().getSimpleName());
                        break;

                    case 4:
                        bank[index].calInterest();
                        break;

                    case 5:
                        if (bank[index] instanceof LoanAccount) 
                        {
                            ((LoanAccount) bank[index]).calEMI();
                        } 
                        else 
                        {
                            System.out.println("Your account is not a loan account");
                        }
                        break;

                    case 10:
                        System.out.println("----------Thank You-----------");
                        break;

                    default:
                        System.out.println("Invalid choice");
                        break;
                }
            }
        }
    }

    public void closeAccount() {
    	
        System.out.print("Enter account number you want to delete: ");
        int accNo = sc.nextInt();

        int index = searchAccount(accNo);
        if (index == -1) 
        {
            System.out.println("Account not found");
        } 
        else 
        {
        	bank[index].setBalance(0);
        	bank[index].display();
            System.out.println("\nAccount deleted successfully");
        }
    }

    private int searchAccount(int accNo) {
    	
        for (int i = 1; i <= ctr; i++) 
        {
            if (bank[i] != null && bank[i].getAccNo() == accNo) 
            {
                return i;
            }
        }
        return -1;
    }

	public void endOfDayReport() {
		
		LocalDate today = LocalDate.now();
	    System.out.println("\nToday's Date: " + today);
	        
		System.out.println("\nEnd of Day Report of Transactions Summary:");
	    
        for (Transaction transaction : transactions) 
        {
        	if (transaction != null) {
                System.out.println(transaction);
                System.out.println(); 
            }
        }

	    System.out.println("\n**********End of Day Report completed**********");
	}
	
    private void addTransaction(Transaction transaction) {
        for (int i = 0; i < transactions.length; i++) 
        {
            if (transactions[i] == null) 
            {
                transactions[i] = transaction;
                break;
            }
        }
    }
}
