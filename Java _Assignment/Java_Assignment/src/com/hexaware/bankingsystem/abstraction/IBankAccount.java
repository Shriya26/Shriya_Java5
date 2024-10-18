package com.hexaware.bankingsystem.abstraction;

public interface IBankAccount {
    void deposit(float amount);
    void withdraw(float amount);
    void displayBalance();
}
