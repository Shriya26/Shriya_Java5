package com.hexaware.bankingsystem.collections;

import java.util.Scanner;

import com.hexaware.bankingsystem.exceptions.Account;

public class BankUi {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HMBankList bank = new HMBankList();
        HMBankSet bank1 = new HMBankSet();
        HMBankMap bank2 = new HMBankMap();

        while (true) {
            System.out.println("Enter account details:");

            System.out.print("Account Number: ");
            int accountNumber = scanner.nextInt();

            System.out.print("Initial Balance: ");
            float initialBalance = scanner.nextFloat();

            double overdraftLimit;
            long account = new Account(accountNumber);
            bank.getAccount(account);
            System.out.println("Account added successfully!");

         
            System.out.print("Do you want to add another account? (yes/no): ");
            String response = scanner.next();
            if (!response.equalsIgnoreCase("yes")) {
                break;
            }
        }

        System.out.println("\nAccounts sorted by account number:");
        for (Account account : bank.getAllAccounts()) {
            System.out.println(account);
        }

      
        System.out.print("\nEnter an account number to retrieve: ");
        int accountNumberToRetrieve = scanner.nextInt();
        Account retrievedAccount = bank.getAccount(accountNumberToRetrieve);
        if (retrievedAccount != null) {
            System.out.println("Retrieved Account: " + retrievedAccount);
        } else {
            System.out.println("Account not found.");
        }

        scanner.close();  
    }
}

