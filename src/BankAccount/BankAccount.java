package bankaccount;

import customexception.AccountFrozenException;
import customexception.InsufficientFundsException;
import customexception.InvalidAmountException;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents an bank account with balance and transaction controls.
 */
public class BankAccount {
    private double balance;
    private double roundedAmount;
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

    /**
     * Method that allows depositing in a BankAccount
     */
    public void deposit(double amount) 
        throws InvalidAmountException, AccountFrozenException {
        try {
            if(isFrozen()) {
                throw(new AccountFrozenException(
                    "Account is FROZEN. Unable to transact."
                ));
            }
            
            if (amount <= 0) {
                throw(new InvalidAmountException(
                    "Invalid amount. Must be greater than 0."
                ));
            }

            roundedAmount = roundAmount(amount);
            System.out.printf("Amount deposited: %.2f%n", amount);
            balance += roundedAmount;
            System.out.printf("Current Balance: %.2f%n", getBalance());
            transactionHistory.add(new Transaction("Deposit", amount));
        } catch (AccountFrozenException | InvalidAmountException e){
            System.out.println(e.getMessage());
        }
    }

    public void withdraw(double amount) 
        throws InvalidAmountException, InsufficientFundsException, 
        AccountFrozenException {
        try {
            if(isFrozen()) {
                throw(new AccountFrozenException(
                    "Account is FROZEN. Unable to transact."
                ));
            }

            if (roundedAmount <= 0) {
                throw(new InvalidAmountException(
                    "Invalid amount. Must be greater than 0"
                ));
            }

            if (roundedAmount > balance) {
                throw(new InsufficientFundsException(
                    "Insufficient balance."
                ));
            }

            roundedAmount = roundAmount(amount);
            System.out.printf("Amount withdrawn: %.2f%n", amount);
            balance -= roundedAmount;
            System.out.printf("Current Balance: %.2f%n", getBalance());
            transactionHistory.add(new Transaction("Withdraw", amount));
        } catch (AccountFrozenException 
            | InvalidAmountException e){
            System.out.println(e.getMessage());
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage() 
            + "\nCurrent balance: " + balance);
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
