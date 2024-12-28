package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.sql.*;

public class TransactionManagementSystem extends Application {

    private Connection connection;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Transaction Management System");

        // Setup layout
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10));
        grid.setVgap(8);
        grid.setHgap(10);

        // Input fields
        TextField transactionIdField = new TextField();
        transactionIdField.setPromptText("Transaction ID");
        GridPane.setConstraints(transactionIdField, 0, 0);

        TextField userIdField = new TextField();
        userIdField.setPromptText("User ID");
        GridPane.setConstraints(userIdField, 0, 1);

        TextField amountField = new TextField();
        amountField.setPromptText("Amount");
        GridPane.setConstraints(amountField, 0, 2);

        TextField dateField = new TextField();
        dateField.setPromptText("Date (YYYY-MM-DD)");
        GridPane.setConstraints(dateField, 0, 3);

        TextField paymentMethodField = new TextField();
        paymentMethodField.setPromptText("Payment Method");
        GridPane.setConstraints(paymentMethodField, 0, 4);

        TextField statusField = new TextField();
        statusField.setPromptText("Status");
        GridPane.setConstraints(statusField, 0, 5);

        // Buttons
        Button insertButton = new Button("Insert");
        Button updateButton = new Button("Update");
        Button deleteButton = new Button("Delete");
        Button viewButton = new Button("View Transactions");

        GridPane.setConstraints(insertButton, 0, 6);
        GridPane.setConstraints(updateButton, 1, 6);
        GridPane.setConstraints(deleteButton, 2, 6);
        GridPane.setConstraints(viewButton, 3, 6);

        // Add event handlers
        insertButton.setOnAction(e -> insertData(transactionIdField, userIdField, amountField, dateField, paymentMethodField, statusField));
        updateButton.setOnAction(e -> updateData(transactionIdField, amountField));
        deleteButton.setOnAction(e -> deleteData(transactionIdField));
        viewButton.setOnAction(e -> viewData());

        grid.getChildren().addAll(transactionIdField, userIdField, amountField, dateField, paymentMethodField, statusField, insertButton, updateButton, deleteButton, viewButton);

        Scene scene = new Scene(grid, 600, 300);
        primaryStage.setScene(scene);
        primaryStage.show();

        // Establish database connection
        connectToDatabase();
    }

    private void connectToDatabase() {
        String url = "jdbc:mysql://localhost:3306/transaction";
        String user = "root";
        String password = "kanishkar123456";

        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Database connected successfully.");
        } catch (SQLException e) {
            showAlert("Connection failed: " + e.getMessage());
        }
    }

    private void insertData(TextField transactionIdField, TextField userIdField, TextField amountField, TextField dateField, TextField paymentMethodField, TextField statusField) {
        String insertQuery = "INSERT INTO transactions (transactionId, userId, amount, date, paymentmethod, status) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(insertQuery)) {
            pstmt.setInt(1, Integer.parseInt(transactionIdField.getText()));
            pstmt.setInt(2, Integer.parseInt(userIdField.getText()));
            pstmt.setDouble(3, Double.parseDouble(amountField.getText()));
            pstmt.setDate(4, Date.valueOf(dateField.getText()));
            pstmt.setString(5, paymentMethodField.getText());
            pstmt.setString(6, statusField.getText());
            pstmt.executeUpdate();
            showAlert("Data inserted successfully.");
            clearFields(transactionIdField, userIdField, amountField, dateField, paymentMethodField, statusField);
        } catch (SQLException e) {
            showAlert("Error: " + e.getMessage());
        } catch (NumberFormatException e) {
            showAlert("Please enter valid numeric values for Transaction ID, User ID, and Amount.");
        } catch (IllegalArgumentException e) {
            showAlert("Please enter a valid date in the format YYYY-MM-DD.");
        }
    }

    private void updateData(TextField transactionIdField, TextField amountField) {
        String updateQuery = "UPDATE transactions SET amount = ? WHERE transactionId = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(updateQuery)) {
            pstmt.setDouble(1, Double.parseDouble(amountField.getText()));
            pstmt.setInt(2, Integer.parseInt(transactionIdField.getText()));
            pstmt.executeUpdate();
            showAlert("Data updated successfully.");
        } catch (SQLException e) {
            showAlert("Error: " + e.getMessage());
        } catch (NumberFormatException e) {
            showAlert("Please enter valid numeric values for Transaction ID and Amount.");
        }
    }

    private void deleteData(TextField transactionIdField) {
        String deleteQuery = "DELETE FROM transactions WHERE transactionId = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(deleteQuery)) {
            pstmt.setInt(1, Integer.parseInt(transactionIdField.getText()));
            pstmt.executeUpdate();
            showAlert("Data deleted successfully.");
        } catch (SQLException e) {
            showAlert("Error: " + e.getMessage());
        } catch (NumberFormatException e) {
            showAlert("Please enter a valid numeric value for Transaction ID.");
        }
    }

    private void viewData() {
        String selectQuery = "SELECT * FROM transactions";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(selectQuery)) {

            StringBuilder result = new StringBuilder("Transactions:\n");
            while (rs.next()) {
                result.append("Transaction ID: ").append(rs.getInt("transactionId"))
                        .append(", User ID: ").append(rs.getInt("userId"))
                        .append(", Amount: ").append(rs.getDouble("amount"))
                        .append(", Date: ").append(rs.getDate("date"))
                        .append(", Payment Method: ").append(rs.getString("paymentmethod"))
                        .append(", Status: ").append(rs.getString("status"))
                        .append("\n");
            }
            showAlert(result.toString());
        } catch (SQLException e) {
            showAlert("Error: " + e.getMessage());
        }
    }

    private void clearFields(TextField... fields) {
        for (TextField field : fields) {
            field.clear();
        }
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
