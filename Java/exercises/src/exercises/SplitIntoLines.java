package exercises;

import java.util.Scanner;

public class SplitIntoLines {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a single line with three sentences separated by periods:");
        String input = scanner.nextLine();

        String[] lines = input.split("\\.");

        for (int i = 0; i < lines.length; i++) {
            System.out.println("Line " + (i + 1) + ": " + lines[i].trim());
        }

        scanner.close();
    }
}
