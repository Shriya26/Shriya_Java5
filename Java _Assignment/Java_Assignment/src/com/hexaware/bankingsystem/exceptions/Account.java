package com.hexaware.bankingsystem.exceptions;

public class Account {
	private long accountNumber;
    private double balance;
    private double overdraftLimit;
    
	public Account(long accountNumber, double balance,double overdraftLimit) {
		super();
		this.accountNumber = accountNumber;
		this.balance = balance;
		 this.overdraftLimit = overdraftLimit;
	}
	 public long getAccountNumber() {
	        return accountNumber;
	    }

	    public double getBalance() {
	        return balance;
	    }

	    public void deposit(double amount) {
	        balance += amount;
	    }

	   public void withdraw(double amount) throws InsufficientFundException, OverDraftLimitExceededException {
	        if (amount > balance + overdraftLimit) {
	            throw new OverDraftLimitExceededException("Overdraft limit exceeded for account: " + accountNumber);
	        }
	        balance -= amount;
	    }
	

}
