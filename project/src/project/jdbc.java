package project;

import java.sql.*;
import java.util.Scanner;

public class jdbc {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/transaction";
        String user = "root";
        String password = "kanishkar123456";
        Scanner scanner = new Scanner(System.in);

        try (Connection con = DriverManager.getConnection(url, user, password)) {

            // Displaying choices
            System.out.println("Choose operation: ");
            System.out.println("1. Insert Data");
            System.out.println("2. Update Data");
            System.out.println("3. Delete Data");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Insert data
                    System.out.print("How many records do you want to add? ");
                    int count = scanner.nextInt();

                    for (int i = 0; i < count; i++) {
                        System.out.println("Enter Transaction ID: ");
                        int transactionId = scanner.nextInt();
                        System.out.println("Enter User ID: ");
                        int userId = scanner.nextInt();
                        System.out.println("Enter Amount: ");
                        double amount = scanner.nextDouble();
                        System.out.println("Enter Date (YYYY-MM-DD): ");
                        String date = scanner.next();
                        System.out.println("Enter Payment Method: ");
                        String paymentMethod = scanner.next();
                        System.out.println("Enter Status: ");
                        String status = scanner.next();

                        String insertQuery = "INSERT INTO transactions (transactionId, userId, amount, date, paymentmethod, status) VALUES (?, ?, ?, ?, ?, ?)";
                        try (PreparedStatement pstmt = con.prepareStatement(insertQuery)) {
                            pstmt.setInt(1, transactionId);
                            pstmt.setInt(2, userId);
                            pstmt.setDouble(3, amount);
                            pstmt.setDate(4, Date.valueOf(date));
                            pstmt.setString(5, paymentMethod);
                            pstmt.setString(6, status);
                            pstmt.executeUpdate();
                            System.out.println("Data inserted successfully.");
                        }
                    }
                    break;

                case 2:
                    // Update data
                    System.out.println("Enter Transaction ID to update: ");
                    int transactionId = scanner.nextInt();
                    System.out.println("Enter new Amount: ");
                    double amount = scanner.nextDouble();

                    String updateQuery = "UPDATE transactions SET amount = ? WHERE transactionId = ?";
                    try (PreparedStatement pstmt = con.prepareStatement(updateQuery)) {
                        pstmt.setDouble(1, amount);
                        pstmt.setInt(2, transactionId);
                        pstmt.executeUpdate();
                        System.out.println("Data updated successfully.");
                    }
                    break;

                case 3:
                    // Delete data
                    System.out.println("Enter Transaction ID to delete: ");
                    transactionId = scanner.nextInt();

                    String deleteQuery = "DELETE FROM transactions WHERE transactionId = ?";
                    try (PreparedStatement pstmt = con.prepareStatement(deleteQuery)) {
                        pstmt.setInt(1, transactionId);
                        pstmt.executeUpdate();
                        System.out.println("Data deleted successfully.");
                    }
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

            // Read and display data
            System.out.println("Reading Data...");
            String selectQuery = "SELECT * FROM transactions";
            try (Statement st = con.createStatement();
                 ResultSet rs = st.executeQuery(selectQuery)) {

                while (rs.next()) {
                    System.out.println("Transaction ID: " + rs.getInt("transactionId"));
                    System.out.println("User ID: " + rs.getInt("userId"));
                    System.out.println("Amount: " + rs.getDouble("amount"));
                    System.out.println("Date: " + rs.getDate("date"));
                    System.out.println("Payment Method: " + rs.getString("paymentmethod"));
                    System.out.println("Status: " + rs.getString("status"));
                    System.out.println("--------------------------");
                }
            }

        } catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
        }
    }
}
