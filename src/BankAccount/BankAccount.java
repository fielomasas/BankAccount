package BankAccount;

public abstract class BankAccount {
    private double balance;
    private boolean isFrozen;

    public abstract String getOwnerName();

    public BankAccount() {
        this.balance = 0;
        this.isFrozen = false;
    }

    public void deposit(double amount) {
        if(isFrozen()) {
            System.out.println("Account is FROZEN. Unable to transact.");
            return;
        }
        
        if (amount <= 0) {
            System.out.println("Invalid amount. Must be greater than 0.");
            return;
        }

        double roundedAmount = Math.round(amount * 100.00) / 100.0;
        balance += roundedAmount;
        System.out.printf("Amount deposited: %.2f%n", amount);
        System.out.printf("Current Balance: %.2f%n", getBalance());
    }

    public void withdraw(double amount) {
        if(isFrozen()) {
            System.out.println("Account is FROZEN. Unable to transact.");
            return;
        }

        double roundedAmount = Math.round(amount * 100.00) / 100.0;
        
        if (roundedAmount <= 0) {
            System.out.println("Invalid amount. Must be greater than 0.");
            return;
        }
        
        if (roundedAmount > balance) {
            System.out.printf("Insufficient balance. Current balance: %.2f%n", getBalance());
            return;
        }

        balance -= roundedAmount;
        System.out.printf("Amount withdrawn: %.2f%n", amount);
        System.out.printf("Current Balance: %.2f%n", getBalance());
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
