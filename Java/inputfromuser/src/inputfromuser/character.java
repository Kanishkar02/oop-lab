package inputfromuser;

import java.util.Scanner;

public class character {
	public static void main(String [] args) {
		Scanner o = new Scanner(System.in);
	System.out.println("Enter a character:");
	char Char=o.next().charAt(0);
	System.out.println("You Entered:"+Char);
	}

}
