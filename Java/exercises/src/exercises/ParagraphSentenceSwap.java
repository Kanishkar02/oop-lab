package exercises;
import java.util.Scanner;

public class ParagraphSentenceSwap {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a paragraph: ");
        String input = scanner.nextLine();
        
        String result = swapSentences(input);
        System.out.println("Modified paragraph: " + result);
        
        scanner.close();
    }

    private static String swapSentences(String paragraph) {
        String[] sentences = paragraph.split("(?<=[.!?])\\s*"); // Split by sentence endings
        int sentenceCount = sentences.length;

        // Swap the first two sentences if there are at least two sentences
        if (sentenceCount >= 2) {
            String temp = sentences[0];
            sentences[0] = sentences[1];
            sentences[1] = temp;
        }

        // If the sentence count is odd, move the last sentence to the front
        if (sentenceCount % 2 != 0) {
            String lastSentence = sentences[sentenceCount - 1];
            // Create a new array to rearrange the sentences
            String[] newSentences = new String[sentenceCount];
            newSentences[0] = lastSentence; // First position for the last sentence
            for (int i = 1; i < sentenceCount; i++) {
                newSentences[i] = sentences[i - 1]; // Shift sentences
            }
            return String.join(" ", newSentences);
        }

        return String.join(" ", sentences);
    }
}