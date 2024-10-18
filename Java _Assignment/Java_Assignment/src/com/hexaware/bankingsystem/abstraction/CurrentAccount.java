package com.hexaware.bankingsystem.abstraction;

public class CurrentAccount extends SavingsAccount {
    final float OVERDRAFT_LIMIT = 1000.0f;

    public CurrentAccount(double interestRate, int accountNumber, String customerName, float accountBalance) {
        super(interestRate, accountNumber, customerName, accountBalance);
    }

    @Override
    public void deposit(float amount) {
        setAccountBalance(getAccountBalance() + amount);
        System.out.println("Deposited: " + amount);
    }

    @Override
    public void withdraw(float amount) {
        if (amount <= getAccountBalance() + OVERDRAFT_LIMIT) {
            setAccountBalance(getAccountBalance() - amount);
            System.out.println("Withdraw Successful: " + amount);
            System.out.printf("Current balance: ", getAccountBalance());
        } else {
            System.out.println("Withdraw Unsuccessful: exceeds overdraft limit.");
        }
    }

    @Override
    public void displayBalance() {
        System.out.printf("Current Account Balance: %.2f\n", getAccountBalance());
    }
}

	

