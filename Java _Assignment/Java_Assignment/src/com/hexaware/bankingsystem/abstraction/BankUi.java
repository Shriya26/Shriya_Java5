
package com.hexaware.bankingsystem.abstraction;



import java.util.Scanner;

public class BankUi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        IBankAccount account = null;

        System.out.println("Choose account type:");
        System.out.println("1. Savings Account");
        System.out.println("2. Current Account");
        int choice = scanner.nextInt();

        System.out.print("Enter account number: ");
        int accountNumber = scanner.nextInt();
        System.out.print("Enter customer name: ");
        String customerName = scanner.next();
        System.out.print("Enter initial balance: ");
        float initialBalance = scanner.nextFloat();

        switch (choice) {
            case 1:
                account = new SavingsAccount() {
                    
                    @Override
                    public void deposit(float amount) {
                        setAccountBalance(getAccountBalance() + amount);
                        System.out.println("Deposited: " + amount);
                    }

                    @Override
                    public void withdraw(float amount) {
                        if (amount <= getAccountBalance()) {
                            setAccountBalance(getAccountBalance() - amount);
                            System.out.println("Withdraw Successful: " + amount);
                        } else {
                            System.out.println("Withdraw Unsuccessful: Insufficient balance.");
                        }
                    }

                    @Override
                    public void displayBalance() {
                        System.out.printf("Savings Account Balance:"+getAccountBalance());
                    }
                };
                break;
            case 2:
                account = new CurrentAccount(4.5, accountNumber, customerName, initialBalance);
                break;
            default:
                System.out.println("Invalid choice.");
                return;
        }

        boolean exit = false;
        while (!exit) {
            System.out.println("\nMenu:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Display Balance");
            if (account instanceof SavingsAccount) {
                System.out.println("4. Calculate Interest");
            }
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Enter amount to deposit: ");
                    float depositAmount = scanner.nextFloat();
                    account.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    float withdrawAmount = scanner.nextFloat();
                    account.withdraw(withdrawAmount);
                    break;
                case 3:
                    account.displayBalance();
                    break;
                case 4:
                    if (account instanceof SavingsAccount) {
                        ((SavingsAccount) account).calculateInterest();
                    } else {
                        System.out.println("This option is not available for Current Account.");
                    }
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }

        scanner.close();
        System.out.println("Thank you for using the banking system!");
    }
}
