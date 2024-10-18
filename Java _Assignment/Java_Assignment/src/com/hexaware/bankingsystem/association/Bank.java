package com.hexaware.bankingsystem.association;

public class Bank {
    private Account[] accounts;
    private int accountCount;
    private static final int MAX_ACCOUNTS = 50;

    public Bank() {
        accounts = new Account[MAX_ACCOUNTS];
        accountCount = 0;
    }

    public String createAccount(Customer customer, String accountType, float balance) {
        if (accountCount >= MAX_ACCOUNTS) {
            return "Maximum account limit reached.";
        }
        int accountNumber = 1001 + accountCount;
        accounts[accountCount++] = new Account(accountNumber, accountType, balance, customer.getFirstName() + " " + customer.getLastName());
        return "Account created. Account Number: " + accountNumber;
    }

    public String getAccountBalance(int accountNumber) {
        for (int i = 0; i < accountCount; i++) {
            if (accounts[i].getAccountNumber() == accountNumber) {
                return "Account balance: " + accounts[i].getAccountBalance();
            }
        }
        return "Account not found.";
    }

    public String deposit(int accountNumber, float amount) {
        if (amount <= 0) {
            return "Deposit amount must be positive.";
        }
        for (int i = 0; i < accountCount; i++) {
            if (accounts[i].getAccountNumber() == accountNumber) {
                accounts[i].setAccountBalance(accounts[i].getAccountBalance() + amount);
                return "New balance: " + accounts[i].getAccountBalance();
            }
        }
        return "Account not found.";
    }

    public String withdraw(int accountNumber, float amount) {
        if (amount <= 0) {
            return "Withdrawal amount must be positive.";
        }
        for (int i = 0; i < accountCount; i++) {
            if (accounts[i].getAccountNumber() == accountNumber) {
                if (amount > accounts[i].getAccountBalance()) {
                    return "Insufficient funds.";
                }
                accounts[i].setAccountBalance(accounts[i].getAccountBalance() - amount);
                return "New balance: " + accounts[i].getAccountBalance();
            }
        }
        return "Account not found.";
    }

    public String transfer(int fromAccountNumber, int toAccountNumber, float amount) {
        if (amount <= 0) {
            return "Transfer amount must be positive.";
        }
        Account fromAccount = null;
        Account toAccount = null;

        for (int i = 0; i < accountCount; i++) {
            if (accounts[i].getAccountNumber() == fromAccountNumber) {
                fromAccount = accounts[i];
            }
            if (accounts[i].getAccountNumber() == toAccountNumber) {
                toAccount = accounts[i];
            }
        }

        if (fromAccount == null) return "From account not found.";
        if (toAccount == null) return "To account not found.";
        if (amount > fromAccount.getAccountBalance()) return "Insufficient funds.";

        fromAccount.setAccountBalance(fromAccount.getAccountBalance() - amount);
        toAccount.setAccountBalance(toAccount.getAccountBalance() + amount);
        return "Transfer successful.";
    }

    public String getAccountDetails(int accountNumber) {
        for (int i = 0; i < accountCount; i++) {
            if (accounts[i].getAccountNumber() == accountNumber) {
                return accounts[i].toString(); 
            }
        }
        return "Account not found.";
    }
}
