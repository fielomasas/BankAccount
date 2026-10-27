package bankaccount;

/** Represents a savings account with an owner. */
public class SavingsAccount extends BankAccount {
    private String ownerName;

    /**
     * Generates a savings account
     * @param ownerName being the name for the account
     */
    public SavingsAccount(String ownerName) {
        this.ownerName = ownerName;
        System.out.println("Account Owner: " + getOwnerName());
    }

    public String getOwnerName() {
        return ownerName;
    }
}
