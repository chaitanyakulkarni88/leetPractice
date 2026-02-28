/**
 * LeetCode Problem: 383. Ransom Note
 *
 * Time Complexity: O(n + m)
 * Space Complexity: O(1)
 *
 * Core Idea:
 * 1. Count character frequencies from magazine.
 * 2. Decrease count while scanning ransomNote.
 * 3. If any character count becomes negative, return false.
 */
public class RansomNote {

    public static void main(String[] args) {
        RansomNote solution = new RansomNote();

        String ransomNote = "aab";
        String magazine = "baa";

        System.out.println(solution.canConstruct(ransomNote, magazine));
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        validateInput(ransomNote, magazine);

        if (magazine.length() < ransomNote.length()) {
            return false;
        }

        int[] frequency = new int[26];

        for (char c : magazine.toCharArray()) {
            frequency[c - 'a']++;
        }

        for (char c : ransomNote.toCharArray()) {
            if (--frequency[c - 'a'] < 0) {
                return false;
            }
        }

        return true;
    }

    private void validateInput(String ransomNote, String magazine) {
        if (ransomNote == null || magazine == null) {
            throw new IllegalArgumentException("Input strings must not be null.");
        }
    }
}