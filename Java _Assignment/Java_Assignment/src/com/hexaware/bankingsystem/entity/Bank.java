package com.hexaware.bankingsystem.entity;

public class Bank {
	

	public static void main(String[] args) {
		
		Account account=new Account(1,"Savings",100000);
		
		account.deposit(1000);
		account.withdraw(500);
		
		account.calculateInterest();
		double interest = account.calculateInterest();
		System.out.printf("interest:"+interest);
		account.setAccountBalance(account.getAccountBalance() + (float) interest);
		System.out.printf("New account balance after interest:", account.getAccountBalance());
		
		
		

	}

}
