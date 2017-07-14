package com.bankapp;

public class CheckingAccount implements Account {

	private double balance;

	public CheckingAccount(double balance) {
		this.balance = balance;
	}

	public double getBalance() {
		return balance;
	}
	public double deposit(double amount) {
		this.balance += amount;// this.balance = this.balance + amount;
		return amount;
	}

	public double withdraw(double amount) {
		if (amount <= balance) {
			this.balance -= amount;// this.balance = this.balance - amount;
			return amount;
		} else {
			System.out.println("You have insufficient funds");
			return 0.0;
		}
	}

}
