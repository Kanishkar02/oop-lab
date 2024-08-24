package exercises;

import java.util.Scanner;

public class RemoveVowels {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter a string:");
        String input = scanner.nextLine();

        String result = removeVowels(input);

        System.out.println("String after removing vowels: " + result);
        
        scanner.close();
    }

    public static String removeVowels(String str) {
        String vowels = "AEIOUaeiou";
        StringBuilder result = new StringBuilder();

        for (char c : str.toCharArray()) {
            if (vowels.indexOf(c) == -1) {
                result.append(c);
            }
        }

        return result.toString();
    }
}

