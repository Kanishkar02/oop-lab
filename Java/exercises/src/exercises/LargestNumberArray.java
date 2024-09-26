package exercises;
import java.util.Scanner;

public class LargestNumberArray {
    public static void main(String[] args) {
        int[] numbers = new int[10];  
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter 10 numbers:");
        for (int i = 0; i < 10; i++) {
            numbers[i] = scanner.nextInt();  
        }
        
        int largest = numbers[0];  
        
        for (int i = 1; i < 10; i++) {
            if (numbers[i] > largest) {
                largest = numbers[i];
            }
        }
        
        System.out.println("The largest number is: " + largest);
        
        scanner.close(); 
    }
}
