package exercises;


import java.util.Scanner;

public class EvenNumbersArray {
  public static void main(String[] args) {
      int[] numbers = new int[10];  
      Scanner scanner = new Scanner(System.in);
      
      System.out.println("Enter 10 numbers:");
      for (int i = 0; i < 10; i++) {
          numbers[i] = scanner.nextInt();  
      }
      
      System.out.println("Even numbers:");
      for (int i = 0; i < 10; i++) {
          if (numbers[i] % 2 == 0) {  
          }              System.out.print(numbers[i] + " ");  
      }
  }
}