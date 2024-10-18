package com.hexaware.bankingsystem.singleinheritance;

public class Account {
	private int accountNumber;
	private String accountType;
	protected float accountBalance;
	private String customer;
	private int lastAccNo;
	public Account() {
		super();
	}
	public Account(int accountNumber, String accountType, float accountBalance, String customer, int lastAccNo) {
		super();
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.accountBalance = accountBalance;
		this.customer = customer;
		this.lastAccNo = lastAccNo;
	}
	public long getAccountNumber() {
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
	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	public int getLastAccNo() {
		return lastAccNo;
	}
	public void setLastAccNo(int lastAccNo) {
		this.lastAccNo = lastAccNo;
	}
	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", accountType=" + accountType + ", accountBalance="
				+ accountBalance + ", customer=" + customer + ", lastAccNo=" + lastAccNo + "]";
	}
	

}
