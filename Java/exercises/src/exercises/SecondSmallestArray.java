package exercises;

import java.util.Scanner;

public class SecondSmallestArray {
    public static void main(String[] args) {
        int[] numbers = new int[10];  
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter 10 numbers:");
        for (int i = 0; i < 10; i++) {  
            numbers[i] = scanner.nextInt();  
        }
        
        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;
        
        for (int i = 0; i < 10; i++) {
            if (numbers[i] < smallest) {
                secondSmallest = smallest;
                smallest = numbers[i];
            } else if (numbers[i] < secondSmallest && numbers[i] != smallest) {
                secondSmallest = numbers[i];
            }
        }
        
        if (secondSmallest == Integer.MAX_VALUE) {
            System.out.println("There is no second smallest number.");
        } else {
            System.out.println("The second smallest number is: " + secondSmallest);
        }
        
        scanner.close();
    }
}
