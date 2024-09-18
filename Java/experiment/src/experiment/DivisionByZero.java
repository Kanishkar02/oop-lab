package experiment;

import java.util.Scanner;

public class DivisionByZero {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter numerator: ");
        double numerator = scanner.nextDouble();
        
        System.out.print("Enter denominator: ");
        double denominator = scanner.nextDouble();
        
        try {
            double result = numerator / denominator;
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Error: Division by zero is not allowed.");
        } finally {
            scanner.close();
        }
    }
}