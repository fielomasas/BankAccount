package BankAccount;

import CustomExceptions.AccountFrozenException;
import CustomExceptions.InsufficientFundsException;
import CustomExceptions.InvalidAmountException;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents an bank account with balance and transaction controls.
 */
public class BankAccount {
    private double balance, roundedAmount;
    private boolean isFrozen;
    private List<Transaction> transactionHistory;

    /**
     * Creates an unfrozen account with a zero balance.
     */
    public BankAccount() {
        this.balance = 0;
        this.isFrozen = false;
        this.transactionHistory = new ArrayList<Transaction>();
    }

    public void deposit(double amount) throws InvalidAmountException, AccountFrozenException {
        try {
            if(isFrozen()) {
                throw(new AccountFrozenException("Account is FROZEN. Unable to transact."));
            }
            
            if (amount <= 0) {
                throw(new InvalidAmountException("Invalid amount. Must be greater than 0."));
            }

            roundedAmount = roundAmount(amount);
            balance += roundedAmount;
            System.out.printf("Amount deposited: %.2f%n", amount);
            System.out.printf("Current Balance: %.2f%n", getBalance());
            transactionHistory.add(new Transaction("Deposit", amount));
        } catch (AccountFrozenException e){
            e.getMessage();
        } catch (InvalidAmountException e) {
            e.getMessage();
        }
    }

    public void withdraw(double amount) throws InvalidAmountException, InsufficientFundsException, AccountFrozenException {
        try {
            roundedAmount = roundAmount(amount);

            if(isFrozen()) {
                throw(new AccountFrozenException("Account is FROZEN. Unable to transact."));
            }

            if (roundedAmount <= 0) {
                throw(new InvalidAmountException("Invalid amount. Must be greater than 0"));
            }

            if (roundedAmount > balance) {
                throw(new InsufficientFundsException("Insufficient balance."));
            }

            balance -= roundedAmount;
            System.out.printf("Amount withdrawn: %.2f%n", amount);
            System.out.printf("Current Balance: %.2f%n", getBalance());
            transactionHistory.add(new Transaction("Withdraw", amount));
        } catch (AccountFrozenException e){
            e.getMessage();
        } catch (InvalidAmountException e) {
            e.getMessage();
        } catch (InsufficientFundsException e) {
            e.getMessage();
        }
    }

    public List<Transaction> getTransactionHistory() {
        return new ArrayList<>(transactionHistory);
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

    public double roundAmount(double amount) {
        return Math.round(amount * 100.00) / 100.0;
    }
}
