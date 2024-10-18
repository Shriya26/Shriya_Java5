package com.hexaware.bankingsystem.conditional;

import java.util.Scanner;

public class Atm {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
		
		System.out.println("Enter your current balance: ");
        double balance = sc.nextDouble();
        
        System.out.print("Select an option: ");
        System.out.println("1.Check Balance");
        System.out.println("2.Withdraw");
        System.out.println("3.Deposit");
        System.out.println("4.Exit");
        
        
        int choice = sc.nextInt();
        
        switch(choice) {
        case 1: 
        	System.out.printf("Balance=",balance);
        	break;
        case 2:
        	double withdraw=sc.nextDouble();
        	System.out.printf("Enter amount to withdraw:",withdraw);
        	if (withdraw > balance) {
                System.out.println("Balance less then withdraw amount");
            } else if (withdraw % 100 != 0 && withdraw % 500 != 0) {
                System.out.println("Error: Withdrawal amount must be in multiples of 100 or 500.");
            } else {
                balance -= withdraw;
                System.out.printf("You have successfully withdrawn:"+withdraw);
                System.out.printf("New Balance:"+ balance);
            }
        	break;
        case 3:
               
                System.out.print("Enter the amount to deposit: ");
                double depositAmount = sc.nextDouble();
                balance = balance+depositAmount;
                System.out.printf("Amount deposited"+depositAmount);
                System.out.printf("Current balance"+balance);
                break;
        case 4:
        	    System.out.println("Exit");
        	    return;
        default: System.out.println("invalid choice");
            
        }
		
         sc.close();
	}}

}
