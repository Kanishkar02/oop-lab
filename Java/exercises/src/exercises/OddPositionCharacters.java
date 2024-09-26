package exercises;

import java.util.Scanner;

public class OddPositionCharacters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        
        System.out.print("Characters at odd positions: ");
        for (int i = 0; i < input.length(); i++) {
            if (i % 2 == 0) { // Check if the index is even (0-based indexing)
                System.out.print(input.charAt(i));
            }
        }
        
        scanner.close();
    }
}