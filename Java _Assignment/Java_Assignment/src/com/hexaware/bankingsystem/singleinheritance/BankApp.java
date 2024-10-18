package com.hexaware.bankingsystem.singleinheritance;

import java.util.Scanner;

import com.hexaware.bankingsystem.entity.Customer;

public class BankApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Account[] accounts = new Account[10];
        BankServiceProviderImpl bankService = new BankServiceProviderImpl(5, "Icici", "Bangalore");

        while (true) {
            System.out.println("\n--- Banking System Menu ---");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Get Balance");
            System.out.println("5. Transfer");
            System.out.println("6. Get Account Details");
            System.out.println("7. List Accounts");
            System.out.println("8. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1: 
                    createAccountMenu(bankService, scanner);
                    break;
                case 2: 
                    System.out.print("Enter account number: ");
                    long depositAccountNumber = scanner.nextLong();
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    bankService.deposit(depositAccountNumber, depositAmount);
                    break;
                case 3: 
                    System.out.print("Enter account number: ");
                    long withdrawAccountNumber = scanner.nextLong();
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    bankService.withdraw(withdrawAccountNumber, withdrawAmount);
                    break;
                case 4: 
                    System.out.print("Enter account number: ");
                    long balanceAccountNumber = scanner.nextLong();
                    double balance = bankService.getAccountBalance(balanceAccountNumber);
                    System.out.println("Current balance: " + balance);
                    break;
                case 5: 
                    System.out.print("Enter from account number: ");
                    long fromAccountNumber = scanner.nextLong();
                    System.out.print("Enter to account number: ");
                    long toAccountNumber = scanner.nextLong();
                    System.out.print("Enter amount to transfer: ");
                    double transferAmount = scanner.nextDouble();
                    bankService.transfer(fromAccountNumber, toAccountNumber, transferAmount);
                    break;
                case 6: 
                    System.out.print("Enter account number: ");
                    long detailsAccountNumber = scanner.nextLong();
                    String accountDetails = bankService.getAccountDetails(detailsAccountNumber);
                    System.out.println(accountDetails);
                    break;
                case 7: 
                    System.out.println("List of Accounts");
                    Account[] accounts1 = bankService.listAccounts();
                    for (Account account : accounts1) {
                        if (account != null) {
                            System.out.println(account);
                        }
                    }
                    break;
                case 8:
                    System.out.println("Exit");
                    scanner.close();
                    return; 
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    private static void createAccountMenu(BankServiceProviderImpl bankService, Scanner scanner) {
        while (true) {
            System.out.println("\n--- Create Account ---");
            System.out.println("1. Savings Account");
            System.out.println("2. Current Account");
            System.out.println("3. Zero Balance Account");
            System.out.println("4. Back to Main Menu");
            System.out.print("Choose account type: ");
            int accountTypeChoice = scanner.nextInt();

            if (accountTypeChoice == 4) {
                return; 
            }

            System.out.print("Enter account number: ");
            long accountNo = scanner.nextLong();
            System.out.print("Enter initial balance: ");
            float initialBalance = scanner.nextFloat();
           
            Customer customer = new Customer();

            switch (accountTypeChoice) {
                case 1:
                    bankService.createAccount(customer, accountNo, "Savings", initialBalance);
                    break;
                case 2:
                    bankService.createAccount(customer, accountNo, "Current", initialBalance);
                    break;
                case 3:
                    bankService.createAccount(customer, accountNo, "Zero Balance", initialBalance);
                    break;
                default:
                    System.out.println("Invalid account type. Please try again.");
            }
        }
    }
}
