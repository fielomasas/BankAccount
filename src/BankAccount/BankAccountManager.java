package BankAccount;

import java.util.HashMap;
import java.util.Map;

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
            System.out.println("Account ID: " + entry.getKey()
            + ", Account Name: " + account.getOwnerName()
            + ", Balance: " + account.getBalance());
        }
    }
}
