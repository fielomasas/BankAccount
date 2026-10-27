package BankAccount;

/** Represents a savings account with an owner. */
public class SavingsAccount extends BankAccount {
    private String ownerName;

    public SavingsAccount(String ownerName) {
        this.ownerName = ownerName;
        System.out.println("Account Owner: " + getOwnerName());
    }

    public String getOwnerName() {
        return ownerName;
    }
}
