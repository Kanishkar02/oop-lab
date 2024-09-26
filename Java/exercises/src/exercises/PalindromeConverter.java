package exercises;

import java.util.Scanner;

public class PalindromeConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a word: ");
        String word = scanner.nextLine();
        if (isPalindrome(word)) {
            System.out.println(true);
        } else {
            String palindromeWord = makePalindrome(word);
            System.out.println(palindromeWord);
        }
    }

    
    public static boolean isPalindrome(String word) {
        int length = word.length();

        for (int i = 0; i < length / 2; i++) {
            if (word.charAt(i) != word.charAt(length - i - 1)) {
                return false;
            }
        }
        return true;
    }

   
    public static String makePalindrome(String word) {
        int length = word.length();
        StringBuilder sb = new StringBuilder(word);

        
        for (int i = length - 2; i >= 0; i--) {
            sb.append(word.charAt(i));
        }

        return sb.toString();
    }
}
