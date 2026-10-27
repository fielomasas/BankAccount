import bankaccount.BankAccount;
import bankaccount.BankAccountManager;
import bankaccount.SavingsAccount;

/** Provides the command-line interface for the bank account application. */
public class App {
    public static void main(String[] args) throws Exception {
        // Hardcoded Test Cases

        System.out.println("Exercise 1 Test Cases");
        System.out.println("\nTest Case 1");
        BankAccount acc1 = new SavingsAccount("Test0");

        System.out.println("\nTest Case 2");
        acc1.deposit(1000.125);

        System.out.println("\nTest Case 3");
        acc1.deposit(0);

        System.out.println("\nTest Case 4");
        acc1.deposit(-500);

        System.out.println("\nTest Case 5");
        acc1.withdraw(500);

        System.out.println("\nTest Case 6");
        acc1.withdraw(1500);

        System.out.println("\nTest Case 7");
        acc1.withdraw(-100);

        System.out.println("\nTest Case 8");
        acc1.freezeAccount();
        acc1.deposit(11500);

        System.out.println("\nTest Case 9");
        acc1.withdraw(500);

        System.out.println("\nTest Case 10");
        acc1.unfreezeAccount();
        acc1.withdraw(100);

        System.out.println("\nExercise 2 Test Cases");
        System.out.println("\nTest Case 1");
        System.out.println(acc1.getTransactionHistory());

        System.out.println("\nTest Case 2");
        BankAccountManager accM1 = new BankAccountManager();

        System.out.println("\nTest Case 3");
        accM1.addAccount(acc1);

        System.out.println("\nTest Case 4");
        accM1.addAccount(new SavingsAccount("Test1"));

        System.out.println("\nTest Case 5");
        accM1.listAccounts();

        System.out.println("\nExercise 3 Test Cases");
        System.out.println("\nTest Case 1");
        acc1.deposit(-500);

        System.out.println("\nTest Case 2");
        acc1.freezeAccount();
        acc1.deposit(11500);
        acc1.unfreezeAccount();

        System.out.println("\nTest Case 3");
        acc1.withdraw(-100);

        System.out.println("\nTest Case 4");
        acc1.withdraw(1500);

        System.out.println("\nTest Case 5");
        acc1.freezeAccount();
        acc1.withdraw(500);

        System.out.println("\nTest Case 6");
        System.out.println(accM1.filterTransactionsAtOrAbove(200, acc1.getTransactionHistory()));

        System.out.println("\nTest Case 7");
        System.out.println(accM1.sortTransactionsByAmount(acc1.getTransactionHistory()));
    }

    
}