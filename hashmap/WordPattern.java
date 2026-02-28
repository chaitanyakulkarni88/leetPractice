/**
 * LeetCode Problem: 290. Word Pattern
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 *
 * Core Idea:
 * 1. Split string into words.
 * 2. Maintain two maps:
 *      - pattern char → word
 *      - word → pattern char
 * 3. Ensure mapping consistency in both directions.
 */
import java.util.HashMap;
import java.util.Map;

public class WordPattern {

    public static void main(String[] args) {
        WordPattern solution = new WordPattern();

        String pattern = "abc";
        String s = "b c a";

        System.out.println(solution.wordPattern(pattern, s));
    }

    public boolean wordPattern(String pattern, String s) {
        validateInput(pattern, s);

        String[] words = s.split(" ");

        if (words.length != pattern.length()) {
            return false;
        }

        Map<Character, String> charToWord = new HashMap<>();
        Map<String, Character> wordToChar = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);
            String word = words[i];

            if (charToWord.containsKey(ch)) {
                if (!charToWord.get(ch).equals(word)) {
                    return false;
                }
            } else {
                if (wordToChar.containsKey(word)) {
                    return false;
                }
                charToWord.put(ch, word);
                wordToChar.put(word, ch);
            }
        }

        return true;
    }

    private void validateInput(String pattern, String s) {
        if (pattern == null || s == null) {
            throw new IllegalArgumentException("Inputs must not be null.");
        }
    }
}