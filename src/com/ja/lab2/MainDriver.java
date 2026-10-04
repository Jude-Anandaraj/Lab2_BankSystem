package com.ja.lab2;


import java.util.Scanner;

public class MainDriver {

	public static void main(String[] args) {
		// Scanner for the input
		Scanner sc = new Scanner(System.in);

		//Creating a Bank account and perform deposit and withdrawal
		BankAccount account1 = createBankAccount(sc);
		performDeposit(sc ,account1);
		performWithdraw(sc, account1);
		
		BankAccount account2 = createBankAccount(sc);
		performDeposit(sc ,account2);
		performWithdraw(sc, account2);
		
		BankAccount account3 = createBankAccount(sc);
		performDeposit(sc ,account3);
		performWithdraw(sc, account3);
		
		sc.close();
	}
	
	// Method for creating bank account by taking user inputs
	public static BankAccount createBankAccount(Scanner sc) {
		// loop until get the right user input
		while (true) {
			//getting Account number
			System.out.println("\nEnter Account Number 9 digits: ");
			String accountNumber = sc.nextLine();

			// getting name
			System.out.println("Enter your name: ");
			String name = sc.nextLine();

			// getting account balance
			double balance = readDouble(sc, "Enter your opening balance: ");
			

			try {
				//creating a bank account by using user input
				BankAccount account = new BankAccount(accountNumber, name, balance);
				System.out.println("Account has been created details below...");
				System.out.println("Account Number: "+ account.getAccountNumber());
				System.out.println("Account Name: "+ account.getName());
				System.out.println("Account Balance: "+ account.getBalance());
				return account;
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.out.println("Please enter the information again...");

			}

		}
	}
	
	//Perform deposit to a bank account
	public static void performDeposit(Scanner sc, BankAccount account)
	{
		try {
			//Getting deposit amount from user
			double amount = readDouble(sc, "\nEnter deposit amount: " );
			account.deposit(amount);
			System.out.println("Current Balance = " + account.getBalance());
		}
		catch(Exception e)
		{
			System.out.println("Deposit failed: " + e.getMessage());
		}
		finally
		{
			System.out.println("Transaction has been proceeded...");
		}
	}
	
	// Perform withdrawal  to a bank account
	public static void performWithdraw(Scanner sc, BankAccount account)
	{
		try {
			//Getting withdrawal amount from user
			double amount = readDouble(sc, "\nEnter withdrawal amount: ");
			account.withdraw(amount);
			System.out.println("Current Balance = " + account.getBalance());
		}
		catch(Exception e)
		{
			System.out.println("Withdrawal failed: " + e.getMessage());
		}
		finally
		{
			System.out.println("Transaction has been proceeded...");
		}
	}
	
	//Helper method for reading double values without errors
	private static double readDouble(Scanner sc, String prompt)
	{
	    while (true)
	    {
	        System.out.println(prompt);

	        if (sc.hasNextDouble())
	        {
	            double value = sc.nextDouble();
	            sc.nextLine();
	            return value;
	        }
	        else
	        {
	            System.out.println("Invalid input. Please enter a number...");
	            sc.nextLine();
	        }
	    }
	}}
