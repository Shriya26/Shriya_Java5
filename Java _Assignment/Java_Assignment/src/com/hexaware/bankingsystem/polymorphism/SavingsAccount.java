package com.hexaware.bankingsystem.polymorphism;

public class SavingsAccount extends Account{
	private double interestRate;

	public SavingsAccount(int accountNumber, String accountType, float accountBalance, double interestRate) {
        super();
        
    }

    public double calculateInterest() {
    	double interest = getAccountBalance() * (interestRate / 100);
        return interest;
    	
    }

}
