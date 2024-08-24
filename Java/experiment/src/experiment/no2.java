package experiment;
import java.util.Scanner;

public class no2{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = scanner.nextInt();
        
        if (num > 1) {
            boolean isPrime = true;
            for (int i = 2; i < num; i++) {
                if (num % i == 0) {
                	System.out.println(num + " is not a prime number.");
                   
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                System.out.println(num + " is a prime number.");
            }
        } else {
            System.out.println(num + " is not a prime number.");
        }
        
      
        scanner.close();
    }
}

	     
	    		
	    		 
	    		 
	    		 
	    	 

	 
	 


