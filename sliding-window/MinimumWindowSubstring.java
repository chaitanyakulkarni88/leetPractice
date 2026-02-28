/*
 * LeetCode Problem: #76 - Minimum Window Substring
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1) (fixed 128 ASCII array)
 *
 * Core Idea:
 * 1. Build frequency map for characters in t.
 * 2. Expand right pointer to include characters.
 * 3. Track how many required characters are matched.
 * 4. When all characters matched, shrink from left.
 * 5. Update minimum window during shrinking.
 *
 * Pattern: Sliding Window (Frequency Matching)
 */

public class MinimumWindowSubstring {

    public String minWindow(String s, String t) {

        if (s == null || t == null || s.length() < t.length() || t.length() == 0) {
            return "";
        }

        int[] frequency = new int[128];

        for (char c : t.toCharArray()) {
            frequency[c]++;
        }

        int left = 0;
        int matchedCount = 0;
        int minLength = Integer.MAX_VALUE;
        int startIndex = 0;

        for (int right = 0; right < s.length(); right++) {

            char current = s.charAt(right);
            frequency[current]--;

            if (frequency[current] >= 0) {
                matchedCount++;
            }

            while (matchedCount == t.length()) {

                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    startIndex = left;
                }

                char leftChar = s.charAt(left);
                frequency[leftChar]++;

                if (frequency[leftChar] > 0) {
                    matchedCount--;
                }

                left++;
            }
        }

        return minLength == Integer.MAX_VALUE
                ? ""
                : s.substring(startIndex, startIndex + minLength);
    }

    public static void main(String[] args) {

        MinimumWindowSubstring solution = new MinimumWindowSubstring();

        System.out.println(solution.minWindow("ADOBECODEBANC", "ABC")); // "BANC"
        System.out.println(solution.minWindow("a", "a"));              // "a"
        System.out.println(solution.minWindow("aa", "aa"));            // "aa"
        System.out.println(solution.minWindow("a", "aa"));             // ""
    }
}