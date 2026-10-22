import BankAccount.BankAccount;
import BankAccount.BankAccountManager;
import BankAccount.SavingsAccount;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        // Dynamic Case Testing

        // BankAccount currAccount = null;
        // Scanner sc = new Scanner(System.in);
        // boolean isRunning = true, hasAccount = false;
        // int choice;

        // while(isRunning) {
        //     if(!hasAccount) {
        //         printMenuNoAccount();

        //         System.out.print("Enter action: ");
        //         choice = sc.nextInt();
        //         sc.nextLine();

        //         switch (choice) {
        //             case 1:
        //                 System.out.print("Enter Name for the account: ");
        //                 String name = sc.nextLine();
        //                 currAccount = new SavingsAccount(name);
        //                 hasAccount = true;
        //                 break;
        //             case 2:
        //                 isRunning = false;
        //                 break;
        //             default:
        //                 System.out.println("Invalid Action. Please enter a valid number.");
        //                 break;
        //         }
        //     } else {
        //         printMenuWithAccount(currAccount.getOwnerName());

        //         System.out.print("Enter action: ");
        //         choice = sc.nextInt();

        //         double amount;

        //         switch (choice) {
        //             case 1:
        //                 // Deposit
        //                 System.out.print("Enter amount to deposit: ");
        //                 amount = sc.nextDouble();
        //                 currAccount.deposit(amount);
        //                 break;
        //             case 2:
        //                 // Withdraw
        //                 System.out.print("Enter amount to withdraw: ");
        //                 amount = sc.nextDouble();
        //                 currAccount.withdraw(amount);
        //                 break;
        //             case 3:
        //                 // Status
        //                 System.out.print("Account Status: ");
        //                 if(currAccount.isFrozen()) {
        //                     System.out.println("Frozen");
        //                 } else {
        //                     System.out.println("Unfrozen");
        //                 }
        //                 break;
        //             case 4:
        //                 // Freeze/Unfreeze
        //                 if(currAccount.isFrozen()) {
        //                     currAccount.unfreezeAccount();
        //                 } else {
        //                     currAccount.freezeAccount();
        //                 }
        //                 break;
        //             case 5:
        //                 // Log Out
        //                 hasAccount = false;
        //                 break;
        //             default:
        //                 System.out.println("Invalid Action. Please enter a valid number.");
        //                 break;
        //         }
                
        //     }
        // }

        // sc.close();

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
    }

    public static void printMenuNoAccount() {
        System.out.println("""
        - - -  MENU - - -
        1. Create Account
        2. Exit
        - - - - - - - - -
        """);
    }

    public static void printMenuWithAccount(String name) {
        System.out.printf("""
        - - -  MENU - - -
        Hi! %s
        1. Deposit
        2. Withdraw
        3. Status
        4. Freeze/Unfreeze
        5. Log Out
        - - - - - - - - -
        """, name);
    }
}
