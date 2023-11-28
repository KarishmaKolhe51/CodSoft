import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient funds. Withdrawal failed.");
            return false;
        }

        balance -= amount;
        System.out.println("Withdrawal successful. Remaining balance: " + balance);
        return true;
    }
}

class ATM {
    private BankAccount bankAccount;

    public ATM(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public void displayMenu() {
        System.out.println("\nATM Menu:\n1. Check Balance\n2. Deposit\n3. Withdraw\n4. Exit");
    }

    public void operate() {
        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            displayMenu();
            System.out.print("\nEnter your choice (1-4): ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2: {
                    System.out.print("\nEnter deposit amount: ");
                    deposit(scanner.nextDouble());
                    break;
                }
                case 3: {
                    System.out.print("\nEnter withdrawal amount: ");
                    withdraw(scanner.nextDouble());
                    break;
                }
                case 4:
                    System.out.println("\nExiting ATM. Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        } while (choice != 4);

        scanner.close();
    }

    private void checkBalance() {
        System.out.println("\nCurrent Balance: " + bankAccount.getBalance());
    }

    private void deposit(double amount) {
        bankAccount.deposit(amount);
        System.out.println("\nDeposit successful. New balance: " + bankAccount.getBalance());
    }

    private void withdraw(double amount) {
        bankAccount.withdraw(amount);
    }

    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(1000);
        ATM atm = new ATM(userAccount);
        atm.operate();
    }

}