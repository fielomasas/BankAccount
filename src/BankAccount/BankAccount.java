package BankAccount;
public class BankAccount {
    private double balance;
    private boolean isFrozen;

    public BankAccount() {
        this.balance = 0;
        this.isFrozen = false;
    }

    public void deposit(double amount) {
        if(isFrozen()) {
            System.out.println("Account is FROZEN. Unable to transact.");
            return;
        }

        System.out.printf("Amount deposited: %.2f%n", amount);
        
        if (amount <= 0) {
            System.out.println("Invalid amount. Must be greater than 0.");
        } else {
            balance += amount;

            System.out.printf("Current Balance: %.2f%n", getBalance());
        }
    }

    public void withdraw(double amount) {
        if(isFrozen()) {
            System.out.println("Account is FROZEN. Unable to transact.");
            return;
        } 

        System.out.printf("Amount withdrawn: %.2f%n", amount);
        
        if (amount <= 0) {
            System.out.println("Invalid amount. Must be greater than 0.");
        } else if (amount > balance) {
            System.out.printf("Insufficient balance. Current balance: %.2f%n", getBalance());
        } else {
            balance -= amount;

            System.out.printf("Current Balance: %.2f%n", getBalance());
        }
    }

    // Helper Functions
    public boolean isFrozen() {
        return isFrozen;
    }

    public double getBalance() {
        return balance;
    }

    public void freezeAccount() {
        isFrozen = true;
    }

    public void unfreezeAccount() {
        isFrozen = false;
    }
}
