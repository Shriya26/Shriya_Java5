package com.hexaware.bankingsystem.exceptions;

public class MainBank {

	public static void main(String[] args) {
		 HMBank bank = new HMBank();

	        bank.addAccount(new Account(1234567890L, 500, 100)); 
	        
	        try {
	            System.out.println("Attempting to withdraw 700 from account ");
	            bank.withdraw(1234567890L, 700); //  OverDraftLimitExceededException
	        } catch (InsufficientFundException | InvalidAccountException | OverDraftLimitExceededException e) {
	            System.out.println("Error: " + e.getMessage());
	        }
	        try {
	            System.out.println("Attempting to withdraw 50 from account 1111111111...");
	            bank.withdraw(1111111108L, 50); //  InvalidAccountException
	        } catch (InsufficientFundException | InvalidAccountException | OverDraftLimitExceededException e) {
	            System.out.println("Error: " + e.getMessage());
	        }}
	}

	


