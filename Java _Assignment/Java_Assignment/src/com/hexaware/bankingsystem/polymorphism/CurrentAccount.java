package com.hexaware.bankingsystem.polymorphism;

public class CurrentAccount extends Account{
	private static final float OVERDRAFT_LIMIT = 1000.0f;
	
	public void withdraw(float amount) {
		if(amount<=getAccountBalance()+OVERDRAFT_LIMIT) {
			System.out.println("Withdraw Successful"+amount);
		setAccountBalance(getAccountBalance()-amount);
		 
		 System.out.printf("Current balance:"+getAccountBalance());}
		else
			System.out.println("Withdraw Unsuccessful");
		
	}
	

}
