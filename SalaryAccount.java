package com.bank.account;

import java.time.LocalDateTime;

public class SalaryAccount extends BankAccount {
	  private LocalDateTime lastTransactionDateTime;
	  private static double rateOfInterest = 0.02;
	
	  public SalaryAccount() {
		    super();
		    this.lastTransactionDateTime = LocalDateTime.now();
	  }
	
	  public SalaryAccount(int accNo, String name, double balance) {
		    super(accNo, name, balance);
		    this.lastTransactionDateTime = LocalDateTime.now();
	  }
	
	  public LocalDateTime getLastTransactionDateTime() {
		return lastTransactionDateTime;
	  }
	
	  public void setLastTransactionDateTime(LocalDateTime lastTransactionDateTime) {
		  this.lastTransactionDateTime = lastTransactionDateTime;
	  }
	
	  public static double getRateOfInterest() {
		  return rateOfInterest;
	  }
	
	  public static void setRateOfInterest(double rateOfInterest) {
		  SalaryAccount.rateOfInterest = rateOfInterest;
	  }

	  public void deposit(double amount) {
		  if (!isFreeze()) 
		  {
		      super.deposit(amount);
		      lastTransactionDateTime = LocalDateTime.now();
		  } 
		  else 
		  {
	    	  System.out.println("Account is frozen because of inactivity. Consider contacting the bank.");
		  }
	  }
	
	  public void withdraw(double amount) {
	    if (!isFreeze()) 
	    {
		      if (this.balance >= amount) 
		      {
		    	  this.setBalance(this.getBalance() - amount);
		    	  System.out.println("\nAmount withdrawn: " + amount);
		    	  lastTransactionDateTime = LocalDateTime.now();   
		      } 
		      else 
		      {
		    	  System.out.println("Insufficient balance");
		      }
	    } 
	    else 
	    {
	    	System.out.println("Account is frozen because of inactivity. Consider contacting the bank.");
	    }
	  }
	
	  private boolean isFreeze() {
		  return LocalDateTime.now().minusMonths(2).isAfter(lastTransactionDateTime);
	  }
	  
	  public void calInterest() {
		    double interest = this.getBalance() * rateOfInterest;
		    System.out.println("Interest accrued: " + interest);
	  }

	  @Override
	  public void calEMI() {
		  System.out.println("Your account is not Loan Account");		
	  }
}






