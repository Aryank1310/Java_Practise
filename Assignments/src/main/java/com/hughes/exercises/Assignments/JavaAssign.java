/**
 * Java Core Assignment
 */
package com.hughes.exercises.Assignments;

import java.util.Scanner;

class Account {
    private String accountId;
    private String accountName;
    private String address;
    private double depositAmount;

    public Account(String accountId, String accountName, String address, double depositAmount) {
        this.accountId = accountId;
        this.accountName = accountName;
        this.address = address;
        this.depositAmount = depositAmount;
    }

    public String getAccountId() {
        return accountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public String getAddress() {
        return address;
    }

    public double getDepositAmount() {
        return depositAmount;
    }

    public void getDetails() {
        System.out.println("Account ID: " + accountId);
        System.out.println("Account Name: " + accountName);
        System.out.println("Address: " + address);
        System.out.println("Deposit Amount: Rs" + depositAmount);
    }

    public void showDetails() {
        System.out.println("Account Details:");
        getDetails();
    }

    public void depositAmount(double amount) {
        depositAmount += amount;
        System.out.println("Rs" + amount + " deposited successfully.");
        System.out.println("Updated  Amount: Rs" + depositAmount);
    }

    public void withdrawAmount(double amount) {
        if (amount > depositAmount) {
            System.out.println("Insufficient funds. Withdrawal not allowed.");
        } else {
            depositAmount -= amount;
            System.out.println("Rs" + amount + " withdrawn successfully.");
            System.out.println("Updated  Amount: Rs" + depositAmount);
        }
    }

    public void payLoan(double amount) {
        System.out.println("Loan payment of Rs" + amount + " made successfully.");
    }

    public void showAccountDetails() {
        System.out.println("Account Details:");
        getDetails();
    }
}

class Loan extends Account {
    private String loanId;
    private String loanType;
    private double loanAmount;

    public Loan(String accountId, String accountName, String address, double depositAmount,
                String loanId, String loanType, double loanAmount) {
        super(accountId, accountName, address, depositAmount);
        this.loanId = loanId;
        this.loanType = loanType;
        this.loanAmount = loanAmount;
    }

    public String getLoanId() {
        return loanId;
    }

    public String getLoanType() {
        return loanType;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public void getLoan() {
        System.out.println("Loan ID: " + loanId);
        System.out.println("Loan Type: " + loanType);
        System.out.println("Loan Amount: Rs" + loanAmount);
    }

    public void showLoanDetails() {
        System.out.println("Loan Details:");
        getLoan();
    }

    @Override
    public void payLoan(double amount) {
        super.payLoan(amount);
        loanAmount -= amount; // Subtract the payment amount from the loan amount
        System.out.println("Loan Details after payment:");
        getLoan();
    }
}

class Transaction extends Loan {
    private double amount;

    public Transaction(String accountId, String accountName, String address, double depositAmount,
                       String loanId, String loanType, double loanAmount, double amount) {
        super(accountId, accountName, address, depositAmount, loanId, loanType, loanAmount);
        this.amount = amount;
    }

    public void depositAmount(double deposit) {
        super.depositAmount(deposit);
    }

    public void withdrawAmount(double withdrawal) {
        super.withdrawAmount(withdrawal);
    }

    public void payLoan() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter loan payment amount: Rs");
        double payment = scanner.nextDouble();
        super.payLoan(payment);
    }

    public void showAccountDetails() {
        System.out.println("Transaction Details:");
        super.showAccountDetails();
    }

    public void showLoanDetails() {
        super.showLoanDetails();
    }
}

public class JavaAssign {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create an array to store 10 accounts
        Account[] accounts = new Account[10];

        // Loop to allow the user to enter account details and loan details up to 10 times
        int accountIndex = 0;
        while (accountIndex < 10) {
            // Get user input for account creation
            System.out.println("Enter Account Details (Press '0' to exit):");
            System.out.print("Account ID (7 digits followed by 4 characters, e.g., 1234567-ASDF): ");
            String accountId = scanner.nextLine();

            // Check if the user wants to exit
            if (accountId.equals("0")) {
                break;
            }

            // Validate the account ID format
            while (!accountId.matches("\\d{7}-[A-Za-z]{4}")) {
                System.out.println("Invalid account ID format. Please enter again.");
                System.out.print("Account ID: ");
                accountId = scanner.nextLine();
            }

            System.out.print("Account Name: ");
            String accountName = scanner.nextLine();
            System.out.print("Address: ");
            String address = scanner.nextLine();

            // Initialize account with user input data
            Account currentAccount = new Account(accountId, accountName, address, 0.0);
            accounts[accountIndex++] = currentAccount;

            // Get user input for loan creation
            System.out.println("\nEnter Loan Details:");
            System.out.print("Loan ID: ");
            String loanId = scanner.nextLine();
            System.out.print("Loan Type (home or car): ");
            String loanType = scanner.nextLine();
            System.out.print("Loan Amount: $");
            double loanAmount = scanner.nextDouble();
            scanner.nextLine(); // Consume the newline character

            // Initialize loan with user input data
            Loan currentLoan = new Loan(accountId, accountName, address, 0.0, loanId, loanType, loanAmount);
            accounts[accountIndex++] = currentLoan;
        }

        // Infinite loop for options
        while (true) {
            // Display available accounts
            System.out.println("\nAvailable Accounts:");
            for (int i = 0; i < accountIndex; i += 2) {
                System.out.println((i / 2 + 1) + ". " + accounts[i].getAccountName() +
                        " (" + accounts[i].getAccountId() + ")");
            }

            // Get user's choice of account
            System.out.print("Choose an account (1-" + (accountIndex / 2) + ", 0 to exit): ");
            int accountChoice = scanner.nextInt();

            // Check if the user wants to exit
            if (accountChoice == 0) {
                System.out.println("Thank you!");
                System.exit(0);
            }

            // Validate user's choice
            if (accountChoice < 1 || accountChoice > (accountIndex / 2)) {
                System.out.println("Invalid choice. Please choose again.");
                continue;
            }

            // Declare and initialize Transaction object inside the loop
            Transaction transaction = new Transaction(
                    accounts[(accountChoice - 1) * 2].getAccountId(),
                    accounts[(accountChoice - 1) * 2].getAccountName(),
                    accounts[(accountChoice - 1) * 2].getAddress(),
                    accounts[(accountChoice - 1) * 2].getDepositAmount(),
                    ((Loan) accounts[(accountChoice - 1) * 2 + 1]).getLoanId(),
                    ((Loan) accounts[(accountChoice - 1) * 2 + 1]).getLoanType(),
                    ((Loan) accounts[(accountChoice - 1) * 2 + 1]).getLoanAmount(),
                    0.0
            );

            // Present options to the user
            while (true) {
                System.out.println("\nOptions for " + accounts[(accountChoice - 1) * 2].getAccountName() +
                        " (" + accounts[(accountChoice - 1) * 2].getAccountId() + "):");
                System.out.println("1. Deposit");
                System.out.println("2. Withdraw");
                System.out.println("3. Pay Loan");
                System.out.println("4. Show Account Details");
                System.out.println("5. Show Loan Details");
                System.out.println("6. Change Account");
                System.out.println("0. Exit");

                // Get user choice
                System.out.print("Choose an option (1-6): ");
                int choice = scanner.nextInt();

                // Perform transaction based on user choice
                switch (choice) {
                    case 1:
                        System.out.print("Enter deposit amount: $");
                        double deposit = scanner.nextDouble();
                        transaction.depositAmount(deposit);
                        break;
                    case 2:
                        System.out.print("Enter withdrawal amount: $");
                        double withdrawal = scanner.nextDouble();
                        transaction.withdrawAmount(withdrawal);
                        break;
                    case 3:
                        transaction.payLoan();
                        break;
                    case 4:
                        transaction.showAccountDetails();
                        break;
                    case 5:
                        transaction.showLoanDetails();
                        break;
                    case 6:
                        break;
                    case 0:
                        System.out.println("Exiting the program. Thank you!");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice. Please choose again.");
                }

                // Check if the user wants to change the account
                if (choice == 6) {
                    break;
                }
            }
        }
    }
}
