package com.hexaware.bankingsystem.conditional;

import java.util.Scanner;

public class Loan {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter credit score");
		int creditScore=sc.nextInt();
		
		System.out.println("Enter annual income");
		double annualIncome=sc.nextDouble();
		
		if(creditScore>=700 && annualIncome>=50000)
			System.out.println("Eligible for loan");
		else
			System.out.println("Not eligible for loan");
	}
	     

}
