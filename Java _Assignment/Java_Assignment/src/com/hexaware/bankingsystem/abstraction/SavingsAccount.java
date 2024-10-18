package com.hexaware.bankingsystem.abstraction;

public abstract class SavingsAccount implements IBankAccount {
    private double interestRate = 4.5;
    private int accountNumber;
    private String customerName;
    private float accountBalance;

    public SavingsAccount() {
        super();
    }

    public SavingsAccount(double interestRate, int accountNumber, String customerName, float accountBalance) {
        super();
        this.interestRate = interestRate;
        this.accountNumber = accountNumber;
        this.customerName = customerName;
        this.accountBalance = accountBalance;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public float getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(float accountBalance) {
        this.accountBalance = accountBalance;
    }

    @Override
    public String toString() {
        return "SavingsAccount [interestRate=" + interestRate + ", accountNumber=" + accountNumber + 
               ", customerName=" + customerName + ", accountBalance=" + accountBalance + "]";
    }

    public void calculateInterest() {
        double interest = accountBalance * (interestRate / 100);
        accountBalance += interest; 
        System.out.println("Interest of " + interest + " added. New balance: " + accountBalance);
    }

    @Override
    public abstract void withdraw(float amount);
}
