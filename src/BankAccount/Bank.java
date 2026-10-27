package bankaccount;

/** Represents a bank that manages bank accounts. */
public interface Bank {
  void addAccount(BankAccount acc);
  BankAccount getAccount(int id);
}
