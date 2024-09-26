package exercises;

import java.util.Scanner;

public class PrimePositionCharacter{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        
        System.out.print("Characters at prime positions: ");
        for (int i = 1; i < input.length(); i++) { // Start from index 1 (2nd character)
            if (isPrime(i + 1)) { // Check if the position (1-based) is prime
                System.out.print(input.charAt(i));
            }
        }
        
        scanner.close();
    }

    private static boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}