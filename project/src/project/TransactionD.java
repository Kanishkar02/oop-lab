package project;
import java.util.Scanner;

class Transaction {
    private int transactionId;
    private int userId;
    private double amount;
    private String date;
    private String paymentmethod;
    private String status;

    public Transaction(int transactionId, int userId, double amount, String date, String paymentmethod, String status) {
        this.transactionId = transactionId;
        this.userId = userId;
        this.amount = amount;
        this.date = date;
        this.paymentmethod = paymentmethod;
        this.status = status;
    }

    public void display() {
        System.out.println("Transaction Id: " + transactionId);
        System.out.println("User Id: " + userId);
        System.out.println("Amount: " + amount);
        System.out.println("Date: " + date);
        System.out.println("Payment Method: " + paymentmethod);
        System.out.println("Status: " + status);
        System.out.println();
    }
}

public class TransactionD {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of transactions: ");
        int numTransactions = scanner.nextInt();
        scanner.nextLine(); 

        Transaction[] transactions = new Transaction[numTransactions];

        for (int i = 0; i < numTransactions; i++) {
            System.out.println("Enter details for transaction " + (i + 1) + ":");
            
            System.out.print("Transaction Id: ");
            int transactionId = scanner.nextInt();
            
            System.out.print("User Id: ");
            int userId = scanner.nextInt();
            
            System.out.print("Amount: ");
            double amount = scanner.nextDouble();
            scanner.nextLine();
            
            System.out.print("Date (YYYY-MM-DD): ");
            String date = scanner.nextLine();
            
            System.out.print("Payment Method: ");
            String paymentmethod = scanner.nextLine();
            
            System.out.print("Status: ");
            String status = scanner.nextLine();
            
            transactions[i] = new Transaction(transactionId, userId, amount, date, paymentmethod, status);
        }

        System.out.println("\nTransaction Details:");
        for (Transaction transaction : transactions) {
            transaction.display();
        }

        scanner.close();
    }
}
