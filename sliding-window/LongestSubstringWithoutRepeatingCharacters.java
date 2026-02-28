/*
 * LeetCode Problem: #3 - Longest Substring Without Repeating Characters
 *
 * Time Complexity: O(n)
 * Space Complexity: O(min(n, charset))
 *
 * Core Idea:
 * 1. Use sliding window with two pointers.
 * 2. Maintain a HashSet of characters in current window.
 * 3. Expand right pointer.
 * 4. If duplicate found, shrink from left.
 * 5. Track maximum window size.
 *
 * Pattern: Sliding Window (Unique Constraint)
 */

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {

        if (s == null || s.length() == 0) {
            return 0;
        }

        Set<Character> window = new HashSet<>();

        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {

            while (window.contains(s.charAt(right))) {
                window.remove(s.charAt(left));
                left++;
            }

            window.add(s.charAt(right));
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {

        LongestSubstringWithoutRepeatingCharacters solution =
                new LongestSubstringWithoutRepeatingCharacters();

        System.out.println(solution.lengthOfLongestSubstring("abcabcbb")); // 3
        System.out.println(solution.lengthOfLongestSubstring("bbbbb"));    // 1
        System.out.println(solution.lengthOfLongestSubstring("pwwkew"));   // 3
    }
}