package com.hexaware.bankingsystem.exceptions;

import java.util.HashSet;
import java.util.Set;

public class HMBank {
	private Set<Account> accounts = new HashSet<>();
	public void addAccount(Account account) {
        accounts.add(account);
    }
	public Account findAccount(long accountNumber) throws InvalidAccountException {
        for (Account account : accounts) {
            if (account.getAccountNumber()==accountNumber) {
                return account;
            }
        }
        throw new InvalidAccountException("Invalid account number: " + accountNumber);
    }
	 public void withdraw(long accountNumber, double amount)
	            throws InvalidAccountException, InsufficientFundException, OverDraftLimitExceededException {
	        Account account = findAccount(accountNumber);
	        account.withdraw(amount); 
	    }
	
}
