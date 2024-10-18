package com.hexaware.bankingsystem.singleinheritance;

import java.util.ArrayList;
import java.util.List;

public class CustomerServiceProviderImpl implements ICustomerServiceProvider {
	private List<Account> accounts;
	public CustomerServiceProviderImpl() {
        accounts = new ArrayList<>();
    }
	public void addAccount(Account account) {
        accounts.add(account); 
    }
	
	@Override
	public double getAccountBalance(long accountNumber) {
		for (Account account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                return account.getAccountBalance(); 
        }
		}
        System.out.println("Invalid account number");
        return 0; 
	}
		

	@Override
	public double deposit(long accountNumber, double amount) {
	    for (Account account : accounts) {
            if (account.getAccountNumber() == accountNumber && amount > 0) {
                account.setAccountBalance(account.getAccountBalance() + (float) amount); 
                return account.getAccountBalance(); 
            }
            System.out.println("Deposit failed");

        }		return 0;
	}

	@Override
	public double withdraw(long accountNumber, double amount) {
		 for (Account account : accounts) {
	            if (account.getAccountNumber() == accountNumber && amount > 0) {
	                if (account.getAccountBalance() >= amount) {
	                    account.setAccountBalance(account.getAccountBalance() - (float) amount); // Deduct amount
	                    return account.getAccountBalance(); // Return updated balance
	                } else {
	                    System.out.println("Insufficient balance.");
	                    return account.getAccountBalance();
	                }
	            }
	        }
	        System.out.println("Invalid account number or withdrawal amount.");
	        return 0;
	}

	@Override
	public void transfer(long fromAccountNumber, long toAccountNumber, double amount) {
		 Account fromAccount = null;
	        Account toAccount = null;

	        for (Account account : accounts) {
	            if (account.getAccountNumber() == fromAccountNumber) {
	                fromAccount = account;
	            }
	            if (account.getAccountNumber() == toAccountNumber) {
	                toAccount = account;
	            }
	        }

	        if (fromAccount != null && toAccount != null && amount > 0) {
	            if (fromAccount.getAccountBalance() >= amount) {
	                fromAccount.setAccountBalance(fromAccount.getAccountBalance() - (float) amount); 
	                toAccount.setAccountBalance(toAccount.getAccountBalance() + (float) amount); 
	                System.out.println("Transfer successful.");
	            } else {
	                System.out.println("Insufficient balance in from account.");
	            }
	        } else {
	            System.out.println("Transfer unsuccessful");
	        }
		
	}

	@Override
	public String getAccountDetails(long accountNumber) {
		for (Account account : accounts){
           
				if (account.getAccountNumber() == accountNumber) {
				    return account.toString(); 
				}
			
        }
        return "Account not found.";
    }
	}


