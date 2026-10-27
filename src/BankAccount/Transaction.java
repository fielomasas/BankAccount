package bankaccount;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/** Represents a bank account transaction. */
public class Transaction {
  private String type;
  private double amount;
  private LocalDateTime timeStamp;

  /**
   * Generates a transaction 
   * @param type being the type of transaction
   * @param amount being the amount being transacted
   */
  public Transaction(String type, double amount) {
    this.type = type;
    this.amount = amount;
    this.timeStamp = LocalDateTime.now();
  }

  /**
   * @return the amount to be handled in the transaction
   */
  public double getAmount() {
    return amount;
  }

  public String toString() {
    DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    return "[type = " + this.type + ", amount = " 
      + this.amount + ", time_stamp = " 
      + this.timeStamp.format(format) 
      + "]\n";
  }
}
