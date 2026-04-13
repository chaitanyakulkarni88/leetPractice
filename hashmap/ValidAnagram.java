/**
 * LeetCode Problem: 242. Valid Anagram
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 * Core Idea:
 * 1. If lengths differ, return false.
 * 2. Count characters from first string.
 * 3. Decrease count while scanning second string.
 * 4. If any count becomes negative, return false.
 */
public class ValidAnagram {

    public static void main(String[] args) {
        ValidAnagram solution = new ValidAnagram();

        String s1 = "anagram";
        String t1 = "nagaram";

        System.out.println(solution.isAnagram(s1, t1));

        String s2 = "rat";
        String t2 = "car";

        System.out.println(solution.isAnagram(s2, t2));
    }

    public boolean isAnagram(String s, String t) {
        validateInput(s, t);

        if (s.length() != t.length()) {
            return false;
        }

        int[] frequency = new int[26];

        for (char c : s.toCharArray()) {
            frequency[c - 'a']++;
        }

        for (char c : t.toCharArray()) {
            if (--frequency[c - 'a'] < 0) {
                return false;
            }
        }

        return true;
    }

    private void validateInput(String s, String t) {
        if (s == null || t == null) {
            throw new IllegalArgumentException("Input strings must not be null.");
        }
    }
}