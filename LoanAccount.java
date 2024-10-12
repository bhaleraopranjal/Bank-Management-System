package com.bank.account;

public class LoanAccount extends BankAccount {

	static double ROI = 0.10;
	private int month;

	public LoanAccount() {
		super();
	}

	public LoanAccount(int accNo, String name, double balance, int month) {
		super(accNo,name,balance);
		this.month = month;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public void withdraw(double amount) {
		if(amount <= this.balance) 
		{
			this.balance -= amount;
			System.out.println("\nAmount withdrawn \nAvailable balnce: "+ this.balance);
		}
		else
		{
			System.out.println("Amount for withdraw is more than account balance");
		}
	}

	public void calEMI() {
		double MonthlyEMI = this.balance / month;
		System.out.println("Your EMI amount: " + MonthlyEMI);
	}
	
	public void calInterest() {
		double interest = this.balance * ROI;
		System.out.println("\nInterest: " + interest);
	}
	
}
