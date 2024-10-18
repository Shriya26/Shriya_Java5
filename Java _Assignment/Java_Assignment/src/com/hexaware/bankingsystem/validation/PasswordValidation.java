package com.hexaware.bankingsystem.validation;

import java.util.Scanner;

public class PasswordValidation {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

        System.out.print("Set Password: ");
        String password = scanner.nextLine();

        boolean isValid = validatePassword(password);

        if (isValid) {
            System.out.println("Valid Password");
        } else {
            System.out.println("Invalid Password!!");
        }

        scanner.close();
    }

    public static boolean validatePassword(String password) {
        if (password.length() < 8) {
            System.out.println("Password must be at least 8 characters long.");
            return false;
        }

        if (!password.matches(".*[A-Z].*")) {
            System.out.println("Password must contain at least one uppercase letter.");
            return false;
        }

        if (!password.matches(".*\\d.*")) {
            System.out.println("Password must contain at least one digit.");
            return false;
        }

        return true;
    }


	}


