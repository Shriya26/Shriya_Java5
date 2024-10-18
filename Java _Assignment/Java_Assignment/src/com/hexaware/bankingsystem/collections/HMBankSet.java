package com.hexaware.bankingsystem.collections;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.hexaware.bankingsystem.exceptions.Account;

public class HMBankSet {
	 private Set<Account> accounts;  

	 public HMBankSet() {
	        this.accounts = new TreeSet<>(Comparator.comparing(Account::getAccountNumber)); // Sort by account number
	    }

	    public void addAccount(Account account) {
	        accounts.add(account);  
	    }

	    public Account getAccount(int accountNumber) {
	        for (Account account : accounts) {
	            if (account.getAccountNumber() == accountNumber) {
	                return account; 
	            }
	        }
	        return null;  
	    }

	    public List<Account> listAccounts() {
	        return new ArrayList<>(accounts);  
	    }
}
