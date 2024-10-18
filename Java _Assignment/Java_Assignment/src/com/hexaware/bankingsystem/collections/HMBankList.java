package com.hexaware.bankingsystem.collections;

import java.util.ArrayList;

import java.util.List;

import com.hexaware.bankingsystem.exceptions.Account;

public class HMBankList {

	    private List<Account> accounts; 

	    public HMBankList() {
	        this.accounts = new ArrayList<>();  
	    }

	    public void addAccount(long accountNumber, double initialBalance, double overdraftLimit) {
	        Account newAccount = new Account(accountNumber, initialBalance, overdraftLimit);
	        accounts.add(newAccount); 
	    }

	    public Account getAccount(long accountNumber) {
	        for (Account account : accounts) {
	            if (account.getAccountNumber() == accountNumber) {
	                return account;  
	            }
	        }
	        return null;  
	    }

	    public List<Account> getAllAccounts() {
	        return accounts; 
	    }
	}



