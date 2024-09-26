package exercises;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SentenceCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a paragraph: ");
        String input = scanner.nextLine();
        String[] sentences = input.split("[.!?]\\s*");
        Map<String, Integer> sentenceCountMap = new HashMap<>();
        
        for (String sentence : sentences) {
            
            sentence = sentence.trim();
            if (!sentence.isEmpty()) {
                sentenceCountMap.put(sentence, sentenceCountMap.getOrDefault(sentence, 0) + 1);
            }
        }
        
        System.out.println("Sentence occurrences:");
        for (Map.Entry<String, Integer> entry : sentenceCountMap.entrySet()) {
            System.out.println("\"" + entry.getKey() + "\": " + entry.getValue());
        }
        
        scanner.close();
    }
}