package exercises;

import java.util.Scanner;

public class StoreIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = new int[10];

        System.out.println("Enter 10 integers:");

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = scanner.nextInt();
        }

        System.out.println("You entered:");
        for (int number : numbers) {
            System.out.println(number);
        }

        scanner.close();
    }
}
