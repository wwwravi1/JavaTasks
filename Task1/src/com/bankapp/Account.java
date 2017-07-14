package com.bankapp;

public interface Account {
	
	public abstract double deposit(double amount);
	public abstract double withdraw(double amount);
	public abstract double getBalance();

}
