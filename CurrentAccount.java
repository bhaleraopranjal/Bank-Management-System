package com.bank.account;

public class CurrentAccount extends BankAccount {
	
	static double ROI = 0.00;
	static double overDraftLimit = 10000;
		
	public CurrentAccount() {
		super();
	}

	public CurrentAccount(int accNo, String name, double balance) {
		super(accNo,name,balance);
	}

	public void withdraw(double amount) {
		if((this.getBalance() + overDraftLimit) >= amount)
		{
			this.setBalance(this.getBalance() - amount);
			System.out.println("\nAmount withdrawed: " + amount );
		}
		else
		{
			System.out.println("Insufficient balance");
		}			
	}
	
	public void calInterest() {
		System.out.println("\nThere is no any interest to Current account");
	}

	public void calEMI() {
		System.out.println("Your account is not Loan Account");		
	}
 
}
