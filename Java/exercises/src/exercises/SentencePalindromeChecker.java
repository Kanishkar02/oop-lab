package exercises;

import java.util.Scanner;

public class SentencePalindromeChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String sentence = scanner.nextLine();
        boolean isPalindrome = checkPalindrome(sentence);
        System.out.println(isPalindrome);
    }

    public static boolean checkPalindrome(String sentence) {
        String cleanedSentence = sentence.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int length = cleanedSentence.length();

        for (int i = 0; i < length / 2; i++) {
            if (cleanedSentence.charAt(i) != cleanedSentence.charAt(length - i - 1)) {
                return false;
            }
        }
        return true;
    }
}

