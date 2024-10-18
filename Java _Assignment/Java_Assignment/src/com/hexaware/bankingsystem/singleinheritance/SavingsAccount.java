package com.hexaware.bankingsystem.singleinheritance;

public class SavingsAccount extends Account{
	private double interestRate;

	public SavingsAccount(String Customer,double interestRate) {
		super();
		this.interestRate = interestRate;
		this.accountBalance=500;
	}
	
	


}
