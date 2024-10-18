package com.hexaware.bankingsystem.loops;

import java.util.Scanner;

public class CompoundInterest {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter no. of customers");
		int noOfCustomers=sc.nextInt();
		for(int i=1;i<=noOfCustomers;i++) {
		System.out.println("Enter initial balance");
		double initialBalance= sc.nextDouble();
				
	    System.out.println("Enter annual interest rate");
		double interestRate= sc.nextDouble();
		
		System.out.println("Enter no. of years");
		int years=sc.nextInt();
		
		double futureBalance = initialBalance * Math.pow((1 + interestRate/100),years);
	
		System.out.println(futureBalance);
		
		}	
		sc.close();

	}

}
