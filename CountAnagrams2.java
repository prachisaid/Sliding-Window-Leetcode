import java.util.HashMap;
import java.util.Map;

public class CountAnagrams2 {
    public static void main(String[] args) {
        
    }

    private static boolean isAnagram(Map<Character, Integer> word1CharCount, Map<Character, Integer> word2CharCount) {
        for(char c : word1CharCount.keySet()) {
            if(word1CharCount.get(c) != word2CharCount.get(c)) {
                return false;
            }
        }
        return true;
    }

    private static int countOccurrenceOfAnagram(String text, String word) {
        int n = text.length();
        int k = word.length();
        int count = 0;

        // Calculate the count of each character for the given word
        Map<Character, Integer> wordCharCount = new HashMap<>();
        for(int i = 0; i < k; i++) {
            char c = word.charAt(i);
            wordCharCount.put(c, wordCharCount.getOrDefault(c, 0)+1);
        }

        // Stores the characrer count for the current substring (current window)
        Map<Character, Integer> substrCharCount = new HashMap<>();
        int windowStart = 0;
        for(int windowEnd = 0; windowEnd < n; windowEnd++) {
            char c = text.charAt(windowEnd);
            substrCharCount.put(c, substrCharCount.getOrDefault(c, 0) + 1); // Include the next char in the window

            if(windowEnd-windowStart+1 == k) { // We've hit the window size. Calculate result and Slide the window
                if(isAnagram(wordCharCount, substrCharCount)) {
                    count++;
                }

                // Reduce count for the char at windowStart since we are sliding the window now
                substrCharCount.put(text.charAt(windowStart), substrCharCount.get(text.charAt(windowStart)) - 1);
                windowStart++; // Slide the window ahead
            }
        }
        return count;
    }
}
