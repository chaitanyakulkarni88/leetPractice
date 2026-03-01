import java.util.*;

public class LongestPalindromicSubstring {

    /*
     * LeetCode Problem: 5 - Longest Palindromic Substring
     *
     * Time Complexity  : O(n^2)
     * Space Complexity : O(1)
     *
     * Core Idea:
     * 1. A palindrome expands from its center.
     * 2. For each index, expand for:
     *      - Odd length  (center at i)
     *      - Even length (center between i and i+1)
     * 3. Track the maximum length found.
     *
     * Algorithm Pattern: Expand Around Center
     */

    public static String longestPalindrome(String s) {

        if (s == null || s.length() < 2) {
            return s;
        }

        int start = 0;
        int maxLength = 1;

        for (int i = 0; i < s.length(); i++) {

            int len1 = expandFromCenter(s, i, i);       // odd
            int len2 = expandFromCenter(s, i, i + 1);   // even

            int currentMax = Math.max(len1, len2);

            if (currentMax > maxLength) {
                maxLength = currentMax;
                start = i - (currentMax - 1) / 2;
            }
        }

        return s.substring(start, start + maxLength);
    }

    private static int expandFromCenter(String s, int left, int right) {

        while (left >= 0 &&
                right < s.length() &&
                s.charAt(left) == s.charAt(right)) {

            left--;
            right++;
        }

        return right - left - 1;
    }

    public static void main(String[] args) {

        String s1 = "babad";
        String s2 = "cbbd";
        String s3 = "a";
        String s4 = "ac";

        System.out.println("Example 1 → " + longestPalindrome(s1));
        System.out.println("Example 2 → " + longestPalindrome(s2));
        System.out.println("Example 3 → " + longestPalindrome(s3));
        System.out.println("Example 4 → " + longestPalindrome(s4));
    }
}