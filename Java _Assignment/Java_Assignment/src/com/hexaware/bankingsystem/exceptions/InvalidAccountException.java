package com.hexaware.bankingsystem.exceptions;

import com.hexaware.bankingsystem.entity.Account;

public class InvalidAccountException extends Exception{
	 public InvalidAccountException(String message) {
	        super(message);
	    }
}
