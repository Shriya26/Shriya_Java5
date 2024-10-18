package com.hexaware.bankingsystem.singleinheritance;

import com.hexaware.bankingsystem.entity.Customer;

public class BankServiceProviderImpl extends CustomerServiceProviderImpl implements IBankServiceProvider{
	 private Account[] accountList; 
	    private String branchName;
	    private String branchAddress;
	    

	    public BankServiceProviderImpl(int branchId, String branchName, String branchAddress) {
	        super();
	        this.accountList = new Account[10]; 
	        this.branchName = branchName;
	        this.branchAddress = branchAddress;
	    }

	public Account[] getAccountList() {
		return accountList;
	}

	public void setAccountList(Account[] accountList) {
		this.accountList = accountList;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getBranchAddress() {
		return branchAddress;
	}

	public void setBranchAddress(String branchAddress) {
		this.branchAddress = branchAddress;
	}

	@Override
	public void createAccount(Customer customer, long accountNo, String accountType, float accountBalance) {
        Account account = new Account((int) accountNo, accountType, accountBalance, customer.getFirstName(), 0);

        for (int i = 0; i < accountList.length; i++) {
            if (accountList[i] == null) {
                accountList[i] = account; 
                addAccount(account); 
                System.out.println("Account created successfully.");
                return;
            }
        }
        System.out.println("Account list is full, cannot create new account.");
    }

	@Override
	public Account[] listAccounts() {
		return accountList;
	}

	@Override
	public double calculateInterest(long accountNumber) {
		Account account = getAccount(accountNumber);
        if (account != null) {
            return account.getAccountBalance() * 0.5; 
        } else {
            System.out.println("Account not found.");
		return 0;
	}}
        private Account getAccount(long accountNumber) {
            for (Account account : accountList) {
                if (account != null && account.getAccountNumber() == accountNumber) {
                    return account;
                }
            }
            return null; 
        }
	

}
