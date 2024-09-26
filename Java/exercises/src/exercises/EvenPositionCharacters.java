package exercises;
import java.util.Scanner;

public class EvenPositionCharacters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        
        System.out.print("Characters at even positions: ");
        for (int i = 0; i < input.length(); i++) {
            if (i % 2 != 0) { // Check if the index is odd (0-based indexing)
                System.out.print(input.charAt(i));
            }
        }
        
        scanner.close();
    }
}