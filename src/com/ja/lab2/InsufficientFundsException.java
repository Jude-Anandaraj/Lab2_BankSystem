/*
 * Jude Anandaraj
 * 2026/10/03
 * Custom Exception class for Bank system
 */
package com.ja.lab2;

public class InsufficientFundsException extends Exception {
	
	public InsufficientFundsException(String message)
	{
		super(message);
	}
}
