package exercises;

import java.util.Scanner;

public class AlternateCaps {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter a word:");
        String input = scanner.nextLine();

        String result = alternateCaps(input);

        System.out.println("String with alternate capitalization: " + result);

        scanner.close();
    }

    public static String alternateCaps(String str) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (i % 2 == 0) {
                result.append(Character.toUpperCase(c));
            } else {
                result.append(Character.toLowerCase(c));
            }
        }

        return result.toString();
    }
}

