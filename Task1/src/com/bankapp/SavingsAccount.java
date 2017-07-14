package com.bankapp;

public class SavingsAccount implements Account {

	private double balance;
	private double rateOfInterest;

	public SavingsAccount(double balance, double rateOfInterest) {
		super();
		this.balance = balance;
		this.rateOfInterest = rateOfInterest;
	}

	public double getRateOfInterest() {
		return rateOfInterest;
	}

	public void setRateOfInterest(double rateOfInterest) {
		this.rateOfInterest = rateOfInterest;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public double deposit(double amount) {

		this.balance += amount;
		return amount;
	}

	@Override
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
