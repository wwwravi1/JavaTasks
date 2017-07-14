package com.bankapp;

public class BankApp {

	public static void main(String[] args) {

		Account checking = new CheckingAccount(100);
		Account savings = new SavingsAccount(200, 10);

		System.out.println("Initial Balance in checking account is : " + checking.getBalance());
		System.out.println("Initial Balance in savings account is : " + savings.getBalance());

		System.out.println("Depositing 30 in checking account....");
		checking.deposit(30);
		System.out.println("Balance after depositing 30 in checking account is : " + checking.getBalance());
	}

}
