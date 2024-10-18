package com.hexaware.bankingsystem.singleinheritance;

public class ZeroBalanceAccount extends Account{
	
	 public ZeroBalanceAccount(String customer) {
	        super();
	        this.accountBalance = (float) 0.0; // Start with zero balance
	    }

}
