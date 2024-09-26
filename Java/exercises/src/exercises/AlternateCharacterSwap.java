package exercises;
import java.util.Scanner;

public class AlternateCharacterSwap {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        
        String swappedString = swapAlternateCharacters(input);
        System.out.println("String after swapping alternate characters: " + swappedString);
        
        scanner.close();
    }

    private static String swapAlternateCharacters(String str) {
        StringBuilder swapped = new StringBuilder();
        
        for (int i = 0; i < str.length(); i += 2) {
            if (i + 1 < str.length()) {
                swapped.append(str.charAt(i + 1)); // Append the next character first
            }
            swapped.append(str.charAt(i)); // Append the current character
        }

        // If the string length is odd, move the last character to the front
        if (str.length() % 2 != 0) {
            char lastChar = swapped.charAt(swapped.length() - 1);
            swapped.deleteCharAt(swapped.length() - 1); // Remove the last character
            swapped.insert(0, lastChar); // Insert it at the front
        }
        
        return swapped.toString();
    }
}