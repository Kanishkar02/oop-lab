package exercises;
import java.util.Scanner;

public class SentenceWordSwap {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a sentence: ");
        String input = scanner.nextLine();
        
        String result = swapWords(input);
        System.out.println("Modified sentence: " + result);
        
        scanner.close();
    }

    private static String swapWords(String sentence) {
        String[] words = sentence.split("\\s+");
        int wordCount = words.length;
        if (wordCount >= 2) {
            String temp = words[0];
            words[0] = words[1];
            words[1] = temp;
        }

        // If the word count is odd, move the last word to the front
        if (wordCount % 2 != 0) {
            String lastWord = words[wordCount - 1];
            // Create a new array to rearrange the words
            String[] newWords = new String[wordCount];
            newWords[0] = lastWord; // First position for the last word
            for (int i = 1; i < wordCount; i++) {
                newWords[i] = words[i - 1]; // Shift words
            }
            return String.join(" ", newWords);
        }

        return String.join(" ", words);
    }
}