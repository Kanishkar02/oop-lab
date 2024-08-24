package exercises;

import java.util.Scanner;

public class singleline {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a line of text:");
        String userInput = scanner.nextLine(); 
        System.out.println("You entered: " + userInput);
        scanner.close(); 
    }
}
