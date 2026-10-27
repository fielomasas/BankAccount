package BankAccount;

import java.util.*;

/**
 * Manages bank accounts and provides operations for adding, retrieving, and listing them.
 */
public class BankAccountManager implements Bank {
    private Map<Integer, BankAccount> accounts;
    private int id;
    private static final int MAX_ACCOUNTS = 100;

    public BankAccountManager() {
        this.accounts = new HashMap<>();
        this.id = 0;
    }

    public void addAccount(BankAccount account) {
        if (account == null) {
            System.out.println("Cannot add a null account");
        }

        if(id >= MAX_ACCOUNTS) {
            System.out.println("Accounts Limit Reached");
            return;
        }

        accounts.put(this.id, account);
        System.out.println("Account added successfully with ID: " + id);
        id++;
    }

    public BankAccount getAccount(int id) {
        return accounts.get(id);
    }

    public void listAccounts() {
        for (Map.Entry<Integer, BankAccount> entry : accounts.entrySet()) {
            BankAccount account = entry.getValue();

            if (account instanceof SavingsAccount savingsAccount) {
                System.out.println("Account ID: " + entry.getKey()
                + ", Account Name: " + savingsAccount.getOwnerName()
                + ", Balance: " + savingsAccount.getBalance());
            }
        }
    }

    public List<Transaction> filterTransactionsAtOrAbove(double amount, List<Transaction> txList) {
        return txList.stream().filter(tx -> tx.getAmount() >= amount).toList();
    }

    public List<Transaction> sortTransactionsByAmount(List<Transaction> txList) {
        return txList.stream().sorted((a, b) -> Double.compare(a.getAmount(), b.getAmount())).toList();
    }
}