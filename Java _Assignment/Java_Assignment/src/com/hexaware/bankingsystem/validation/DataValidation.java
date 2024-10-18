package com.hexaware.bankingsystem.validation;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class BankAccount {
    private int accountNumber;
    private double balance;

    public BankAccount(int accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }
}


public class DataValidation {
    public static void main(String[] args) {
	        
	        Map<Integer, BankAccount> bankAccounts = new HashMap<>();
	        bankAccounts.put(1, new BankAccount(1, 15000.0));
	        bankAccounts.put(2, new BankAccount(2, 30000.0));
	        bankAccounts.put(3, new BankAccount(3, 75000.0));
	        bankAccounts.put(4, new BankAccount(4, 8000.0));

	        Scanner scanner = new Scanner(System.in);

	        while (true) {
	            
	            System.out.print("Enter account number: ");
	            int accountNumber = scanner.nextInt();

	            if (accountNumber == -1) {
	                System.out.println("Exit");
	                break; 
	            }

	           
	            if (bankAccounts.containsKey(accountNumber)) {
	                BankAccount account = bankAccounts.get(accountNumber);
	                System.out.printf("Account Balance for account number %d:", 
	                                  account.getAccountNumber(), account.getBalance());
	            } else {
	                System.out.println(" Try again.");
	            }
	        }

	        scanner.close(); 
	    }
	}



