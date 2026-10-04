package com.ja.lab2;

public class BankAccount {

	// Account Number
	private String accountNumber;
	// Name
	private String name;
	// Balance
	private double balance;

	// constructor
	public BankAccount(String accountNumber, String name, double balance) {
		// condition for checking accountNumber
		if (accountNumber == null || !accountNumber.matches("\\d{9}")) {
			throw new IllegalArgumentException("Account number must be exactly 9 Digits...");
		}
		// condition for name
		if (name == null || name.trim().isEmpty()) {
			throw new IllegalArgumentException("Name can not be empty...");
		}
		// condition for balance
		if (balance < 0) {
			throw new IllegalArgumentException("Opening balance can not be negative...");
		}

		// initialize the values
		this.accountNumber = accountNumber;
		this.name = name.trim();
		this.balance = round2(balance);

	}

	// deposit money method
	public void deposit(double amount) {
		// condition for deposit amount to the account
		if (amount <= 0) {
			throw new IllegalArgumentException("Deposit amount must be greater than 0...");
		}
		this.balance = round2(balance + amount);
	}

	// withdraw method
	public void withdraw(double amount) throws InsufficientFundsException {
		// withdraw condition
		if (amount <= 0) {
			throw new IllegalArgumentException("Withdraw amount must be greate than 0 ...");
		}
		// Balance must be greater than withdraw amount
		if (amount > this.balance) {
			throw new InsufficientFundsException("Insufficient balance in your account... ");
		}
		this.balance = round2(balance - amount);
	}

	// Getter of balance
	public double getBalance() {
		return this.balance;
	}

	// Getter of account number
	public String getAccountNumber() {
		return this.accountNumber;
	}

	// getter of name
	public String getName() {
		return this.name;
	}

	// helper function - 2precesion
	private static double round2(double value) {
		return Math.round(value * 100.0) / 100.0;
	}
	
	

}
