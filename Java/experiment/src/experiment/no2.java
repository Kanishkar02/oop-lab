package experiment;
import java.util.Scanner;

public class no2{

    public static void main(String[] args) {
        int count = 0;  
        Scanner scanner = new Scanner(System.in);  

        System.out.println("Enter number to check:");
        int n = scanner.nextInt(); 

        if (n < 2) {
            System.out.println("Not a prime number");
        } else {
            for (int i = 1; i <= n; i++) {
                if (n % i == 0) {
                    count += 1;
                }
            }

            if (count > 2) {
                System.out.println("Not a prime number");
            } else {
                System.out.println("It is a prime number");
            }
        }

        scanner.close();  
    }
}
