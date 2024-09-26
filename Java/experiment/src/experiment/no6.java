package experiment;

//Program done by 2117230020096
public class no6 {

 interface Account {
     void deposit(double amount);
     void withdraw(double amount);
     double getBalance();
 }

 static class BankAccount implements Account {
     private double balance;

     public BankAccount(double initialBalance) {
         this.balance = initialBalance;
     }

     @Override
     public void deposit(double amount) {
         if (amount > 0) {
             balance += amount;
         }
     }

     @Override
     public void withdraw(double amount) {
         if (amount > 0 && amount <= balance) {
             balance -= amount;
         }
     }

     @Override
     public double getBalance() {
         return balance;
     }
 }

 public static void main(String[] args) {
     BankAccount account = new BankAccount(1000.00);
     account.deposit(500.00);
     account.withdraw(200.00);
     System.out.println("Current Balance: $" + account.getBalance());
 }
}
