package com.hexaware.bankingsystem.entity;

public class Account {
	private int accountNumber;
	private String accountType;
	private float accountBalance;
	
	public Account() {
		super();
		
	}

	public Account(int accountNumber, String accountType, float accountBalance) {
		super();
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.accountBalance = accountBalance;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public float getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(float accountBalance) {
		this.accountBalance = accountBalance;
	}
	
	
	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", accountType=" + accountType + ", accountBalance="
				+ accountBalance +"]";
	}

	public void deposit(float amount) {
		if(amount>0) {
			System.out.printf("Deposited amount:"+amount);
		 accountBalance=accountBalance+amount;
		 
		 System.out.printf("Current balance:"+accountBalance);
		}
		else
			System.out.println("No deposit");
		 
		
	}
	 public void deposit(int amount) {
	        deposit((float) amount);
	    }

	    public void deposit(double amount) {
	        deposit((float) amount);
	    }

	
	public void withdraw(float amount) {
		if(amount<=accountBalance) {
			System.out.println("Withdraw Successful"+amount);
		accountBalance=accountBalance-amount;
		 
		 System.out.printf("Current balance:"+accountBalance);}
		else
			System.out.println("Withdraw Unsuccessful");
		
	}
	 public void withdraw(int amount) {
	        withdraw((float) amount);
	    }

	    public void withdraw(double amount) {
	        withdraw((float) amount);
	    }

	
	public double calculateInterest() {
		double interestRate= (double) 4.5;
		double interest = accountBalance * (interestRate / 100);
        return interest;
	}

}
