package exercises;
import java.util.Scanner;

public class MinMaxSumArray {
    public static void main(String[] args) {
        int[] numbers = new int[10];  
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter 10 numbers:");
        for (int i = 0; i < 10; i++) {
            numbers[i] = scanner.nextInt();  
        }
        
        int min = numbers[0];
        int max = numbers[0];
        
        for (int i = 1; i < 10; i++) {
            if (numbers[i] < min) {
                min = numbers[i];
            }
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }
        
        int sum = min + max;
        
        System.out.println("The minimum number is: " + min);
        System.out.println("The maximum number is: " + max);
        System.out.println("The sum of the minimum and maximum numbers is: " + sum);
        
        scanner.close(); // 
    }
}
