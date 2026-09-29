public class Account {

  protected double balance;

  // Konstruktor untuk menentukan saldo awal
  public Account(double initBalance) {
      balance = initBalance;
  }

  // Mengambil saldo
  public double getBalance() {
      return balance;
  }

  // Menambahkan saldo
  public boolean deposit(double amount) {
      if (amount > 0) {
          balance = balance + amount;
          return true;
      } else {
          return false;
      }
  }

  // Mengurangi saldo
  public boolean withdraw(double amount) {
      if (amount > 0 && balance >= amount) {
          balance = balance - amount;
          return true;
      } else {
          return false;
      }
  }
}