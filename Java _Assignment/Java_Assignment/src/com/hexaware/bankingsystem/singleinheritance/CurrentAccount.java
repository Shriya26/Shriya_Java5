package com.hexaware.bankingsystem.singleinheritance;

public class CurrentAccount extends Account {
    float OVERDRAFT_LIMIT = 1000.0f;
    public CurrentAccount(String customer, double OVERDRAFT_LIMIT) {
        super();
        this.OVERDRAFT_LIMIT = (float) OVERDRAFT_LIMIT;
    }
    
    
    public void withdraw(double amount) {
        if (amount > 0 && (amount <= accountBalance + OVERDRAFT_LIMIT)) {
            accountBalance -= amount;
            System.out.println("Withdrawn: " + amount + ", New Balance: " + accountBalance);
        } else {
            System.out.println("Withdrawal amount exceeds available balance and overdraft limit.");
        }
    }

}

	

