/*
 * LeetCode Problem: #30 - Substring with Concatenation of All Words
 *
 * Time Complexity: O(n * wordLength)
 * Space Complexity: O(m)
 *
 * Core Idea:
 * 1. All words have same length.
 * 2. Precompute frequency map of words.
 * 3. Slide window in steps of wordLength.
 * 4. Maintain a current window frequency map.
 * 5. When count exceeds, shrink from left.
 * 6. If window size == total words, record index.
 *
 * Pattern: Sliding Window (Fixed Chunk Size)
 */

import java.util.*;

public class SubstringConcatenationOfAllWords {

    public List<Integer> findSubstring(String s, String[] words) {

        List<Integer> result = new ArrayList<>();

        if (s == null || words == null || words.length == 0) {
            return result;
        }

        int wordLength = words[0].length();
        int wordCount = words.length;
        int totalLength = wordLength * wordCount;

        if (s.length() < totalLength) {
            return result;
        }

        Map<String, Integer> targetMap = new HashMap<>();
        for (String word : words) {
            targetMap.put(word, targetMap.getOrDefault(word, 0) + 1);
        }

        // Try all possible offsets
        for (int offset = 0; offset < wordLength; offset++) {

            int left = offset;
            int count = 0;
            Map<String, Integer> windowMap = new HashMap<>();

            for (int right = offset; right + wordLength <= s.length(); right += wordLength) {

                String word = s.substring(right, right + wordLength);

                if (targetMap.containsKey(word)) {

                    windowMap.put(word, windowMap.getOrDefault(word, 0) + 1);
                    count++;

                    // If word appears too many times, shrink window
                    while (windowMap.get(word) > targetMap.get(word)) {
                        String leftWord = s.substring(left, left + wordLength);
                        windowMap.put(leftWord, windowMap.get(leftWord) - 1);
                        left += wordLength;
                        count--;
                    }

                    if (count == wordCount) {
                        result.add(left);
                    }

                } else {
                    // Reset window
                    windowMap.clear();
                    count = 0;
                    left = right + wordLength;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {

        SubstringConcatenationOfAllWords solution =
                new SubstringConcatenationOfAllWords();

        String s = "barfoothefoobarman";
        String[] words = {"foo", "bar"};

        System.out.println(solution.findSubstring(s, words)); // [0, 9]
    }
}