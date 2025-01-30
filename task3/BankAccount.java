package task3;

import java.util.Scanner;

class BankAccount {
    private String accountNumber;
    private double balance;

    public BankAccount(String accountNumber) { 
        this.accountNumber = accountNumber;
        this.balance = 0;
    }

    public boolean deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            return true;
        } else {
            return false;
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= this.balance) {
            this.balance -= amount;
            return true;
        } else {
            return false;
        }
    }

    public double checkBalance() {
        return this.balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

}

class ATM {
    private BankAccount account;
    private Scanner scanner;

    public ATM() {
        this.scanner = new Scanner(System.in);
        this.account = null; // Initially no account
    }

    public void createAccount() {
        System.out.print("Enter your account number: ");
        String accountNumber = scanner.next();
        this.account = new BankAccount(accountNumber); // Create account object
        System.out.println("Account created successfully.");
    }

    public void displayMenu() {
        System.out.println("\nWelcome to the ATM");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    public void run() {
        while (account == null) { 
            System.out.println("No account found. Please create an account first.");
            System.out.println("1. Create Account");
            int choice = getIntegerInput();
            if (choice == 1) {
                createAccount();
            } else {
                System.out.println("Invalid Choice");
            }
        }

        while (true) {
            displayMenu();
            System.out.print("Enter your choice (1-4): ");
            int choice = getIntegerInput();

            switch (choice) {
                case 1:
                    double withdrawAmount = getDoubleInput("Enter amount to withdraw: ");
                    if (account.withdraw(withdrawAmount)) {
                        System.out.println("Withdrawal successful.");
                    } else {
                        System.out.println("Insufficient balance or invalid amount.");
                    }
                    break;
                case 2:
                    double depositAmount = getDoubleInput("Enter amount to deposit: ");
                    if (account.deposit(depositAmount)) {
                        System.out.println("Deposit successful.");
                    } else {
                        System.out.println("Invalid amount.");
                    }
                    break;
                case 3:
                    double balance = account.checkBalance();
                    System.out.println("Your balance is: $" + balance);
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }



    private double getDoubleInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return scanner.nextDouble();
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Clear the invalid input
            }
        }
    }

    private int getIntegerInput() {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.next(); // Clear the invalid input
            }
        }
    }


    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.run();
    }
}