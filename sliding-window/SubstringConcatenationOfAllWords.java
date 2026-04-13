/*
 * LeetCode Problem: #30 - Substring with Concatenation of All Words
 *
 * Time Complexity:
 * - Brute Force: O(n * wordCount * wordLength)
 * - Sliding Window: O(n * wordLength)
 *
 * Space Complexity: O(m)
 *
 * Core Idea:
 *
 * Approach 1: Brute Force (Simple)
 * 1. All words have the same length.
 * 2. Build a frequency map (targetMap) of words.
 * 3. Try every starting index i in the string.
 * 4. For each i:
 *    - Extract wordCount chunks of size wordLength.
 *    - Maintain a temporary map (seen).
 *    - If a word is not in targetMap OR exceeds frequency → break.
 * 5. If all words matched → add index i to result.
 *
 * Approach 2: Sliding Window (Optimized)
 * 1. Since all words have equal length, process string in word-sized chunks.
 * 2. Build a frequency map (targetMap) of words.
 * 3. Iterate over all possible offsets from 0 to wordLength - 1.
 * 4. Use a sliding window:
 *    - Move right pointer in steps of wordLength.
 *    - Track frequencies using windowMap.
 * 5. If a word exceeds allowed frequency:
 *    - Shrink window from left until valid.
 * 6. If number of matched words == total words:
 *    - Record starting index.
 * 7. If an invalid word is found:
 *    - Reset window.
 *
 * Pattern:
 * - Brute Force + HashMap
 * - Sliding Window (Fixed Chunk Size)
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

    public List<Integer> findSubstringSimple(String s, String[] words) {

        List<Integer> result = new ArrayList<>();

        if (s == null || words == null || words.length == 0) {
            return result;
        }

        int wordLength = words[0].length();
        int wordCount = words.length;
        int totalLength = wordLength * wordCount;

        Map<String, Integer> targetMap = new HashMap<>();
        for (String word : words) {
            targetMap.put(word, targetMap.getOrDefault(word, 0) + 1);
        }

        // Try every starting index
        for (int i = 0; i <= s.length() - totalLength; i++) {

            Map<String, Integer> seen = new HashMap<>();
            int j = 0;

            while (j < wordCount) {
                int start = i + j * wordLength;
                String word = s.substring(start, start + wordLength);

                if (!targetMap.containsKey(word)) {
                    break;
                }

                seen.put(word, seen.getOrDefault(word, 0) + 1);

                if (seen.get(word) > targetMap.get(word)) {
                    break;
                }

                j++;
            }

            if (j == wordCount) {
                result.add(i);
            }
        }

        return result;
    }

    public static void main(String[] args) {

        SubstringConcatenationOfAllWords solution =
                new SubstringConcatenationOfAllWords();

        String s = "barfoothefoobarman";
        String[] words = {"foo", "bar"};

        System.out.println(solution.findSubstringSimple(s, words)); // [0, 9]
        System.out.println(solution.findSubstring(s, words)); // [0, 9]
    }
}