package com.bank.account;

abstract public class BankAccount {
	private int accNo;
	public String name;
	public double balance;
	  
	public BankAccount() {
	
	}
	
	public BankAccount(int accNo, String name, double balance) {
		this.accNo = accNo;
		this.name = name;
		this.balance = balance;
	}
    
	public int getAccNo() {
		return accNo;
	}

	public void setAccNo(int accNo) {
		this.accNo = accNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public void deposit(double amount) {
		this.balance = this.balance + amount;
		System.out.println("Amount deposited successfully");
	}
	
	abstract public void withdraw(double amount);
	
	abstract public void calInterest();
	
	public void display() {
		System.out.print("\n\nAccount No.: " + this.accNo);
		System.out.print("\nAccount holder name: " + this.name);
		System.out.print("\nBalance: " + this.balance);
	}
	
	public abstract void calEMI();
}
