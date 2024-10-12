package com.bank.account;

public class SavingAccount extends BankAccount {

	  private static double minBalance = 10000;
	  private static double rateOfInterest = 0.03;
	
	  public SavingAccount() {
		  super();
	  }
	
	  public SavingAccount(int accNo, String name, double balance) {
		  super(accNo, name, balance);
	  }

	  public void withdraw(double amount) {
		    if (this.getBalance() - amount >= minBalance) 
		    {
			      this.setBalance(this.getBalance() - amount);
			      System.out.println("Amount withdrawn successfully");
		    } 
		    else 
		    {
		    	double availableWithdrawal = this.getBalance() - minBalance;
		      
			      if (availableWithdrawal > 0) 
			      {
			        this.setBalance(minBalance);
			        System.out.println("Insufficient funds. Withdrew maximum possible amount: " + availableWithdrawal);
			      } 
			      else 
			      {
			        System.out.println("Insufficient balance to meet minimum balance requirement.");
			      }
		    }
	  }
	
	  public void calInterest() {
		    double interest = this.getBalance() * rateOfInterest;
		    System.out.println("Interest accrued: " + interest);
	  }
	  
	  public void calEMI() {
			System.out.println("No EMI");		
	  }
	  
}
