package com.hexaware.bankingsystem.association;

import java.util.Scanner;

public class BankApp {

	public static void main(String[] args) {
		
		        Bank bank = new Bank();
		        Scanner scanner = new Scanner(System.in);

		        while (true) {
		            System.out.println("\nCommands: create_account, deposit, withdraw, get_balance, transfer, get_account_details, exit");
		            System.out.print("Enter command: ");
		            String command = scanner.nextLine().trim().toLowerCase();

		            if (command.equals("exit")) {
		                System.out.println("Goodbye!");
		                break; 
		            }

		            switch (command) {
		                case "create_account":
		                    createAccount(bank, scanner);
		                    break;
		                case "deposit":
		                    deposit(bank, scanner);
		                    break;
		                case "withdraw":
		                    withdraw(bank, scanner);
		                    break;
		                case "get_balance":
		                    getBalance(bank, scanner);
		                    break;
		                case "transfer":
		                    transfer(bank, scanner);
		                    break;
		                case "get_account_details":
		                    getAccountDetails(bank, scanner);
		                    break;
		                default:
		                    System.out.println("Invalid command. Please try again.");
		            }
		        }
		        scanner.close(); 
		    }

		    private static void createAccount(Bank bank, Scanner scanner) {
		        System.out.print("Enter customer ID: ");
		        int customerId = Integer.parseInt(scanner.nextLine());
		        System.out.print("Enter first name: ");
		        String firstName = scanner.nextLine();
		        System.out.print("Enter last name: ");
		        String lastName = scanner.nextLine();
		        System.out.print("Enter account type (Savings/Checking): ");
		        String accountType = scanner.nextLine();
		        System.out.print("Enter initial balance: ");
		        float balance = Float.parseFloat(scanner.nextLine());

		        Customer customer = new Customer(customerId, firstName, lastName, "", 0, "");
		        String result = bank.createAccount(customer, accountType, balance);
		        System.out.println(result);
		    }

		    private static void deposit(Bank bank, Scanner scanner) {
		        System.out.print("Enter account number: ");
		        int accountNumber = Integer.parseInt(scanner.nextLine());
		        System.out.print("Enter amount to deposit: ");
		        float amount = Float.parseFloat(scanner.nextLine());
		        String result = bank.deposit(accountNumber, amount);
		        System.out.println(result);
		    }

		    private static void withdraw(Bank bank, Scanner scanner) {
		        System.out.print("Enter account number: ");
		        int accountNumber = Integer.parseInt(scanner.nextLine());
		        System.out.print("Enter amount to withdraw: ");
		        float amount = Float.parseFloat(scanner.nextLine());
		        String result = bank.withdraw(accountNumber, amount);
		        System.out.println(result);
		    }

		    private static void getBalance(Bank bank, Scanner scanner) {
		        System.out.print("Enter account number: ");
		        int accountNumber = Integer.parseInt(scanner.nextLine());
		        String result = bank.getAccountBalance(accountNumber);
		        System.out.println(result);
		    }

		    private static void transfer(Bank bank, Scanner scanner) {
		        System.out.print("Enter from account number: ");
		        int fromAccountNumber = Integer.parseInt(scanner.nextLine());
		        System.out.print("Enter to account number: ");
		        int toAccountNumber = Integer.parseInt(scanner.nextLine());
		        System.out.print("Enter amount to transfer: ");
		        float amount = Float.parseFloat(scanner.nextLine());
		        String result = bank.transfer(fromAccountNumber, toAccountNumber, amount);
		        System.out.println(result);
		    }

		    private static void getAccountDetails(Bank bank, Scanner scanner) {
		        System.out.print("Enter account number: ");
		        int accountNumber = Integer.parseInt(scanner.nextLine());
		        String result = bank.getAccountDetails(accountNumber);
		        System.out.println(result);
		    }
		


	}


