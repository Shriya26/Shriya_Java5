package com.hexaware.bankingsystem.collections;

import java.util.HashMap;
import java.util.Map;

import com.hexaware.bankingsystem.exceptions.Account;

public class HMBankMap {
	private Map<Integer, Account> accounts;  

    public HMBankMap() {
        this.accounts = new HashMap<>();  
    }

    public void addAccount(Account account) {
        accounts.put((int) account.getAccountNumber(), account);  // Add account by account number
    }

    public Account getAccount(int accountNumber) {
        return accounts.get(accountNumber);  // Retrieve account by account number
    }

    public Map<Integer, Account> listAccounts() {
        return accounts;  // Return the map of accounts
    }

}
