package com.hexaware.bankingsystem.singleinheritance;

import com.hexaware.bankingsystem.entity.Customer;

public interface IBankServiceProvider {
	void createAccount(Customer customer, long accountNo, String accountType, float accountBalance); 

    Account[] listAccounts(); 

    double calculateInterest(long accountNumber); 

}
