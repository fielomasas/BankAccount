package BankAccount;

public class SavingsAccount extends BankAccount{
    private String ownerName;

    public SavingsAccount(String ownerName) {
        this.ownerName = ownerName;
        System.out.println("Account Owner: " + getOwnerName());
    }

    public String getOwnerName() {
        return ownerName;
    }
}
