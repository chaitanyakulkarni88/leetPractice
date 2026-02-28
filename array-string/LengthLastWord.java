/*
 * LeetCode Problem: #58 - Length of Last Word
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 * Core Idea:
 * 1. Start from end of string.
 * 2. Skip trailing spaces.
 * 3. Count characters until next space or start of string.
 * 4. Return count.
 *
 * Pattern: Reverse String Traversal
 */

public class LengthLastWord {

    public int lengthOfLastWord(String s) {

        if (s == null || s.length() == 0) {
            return 0;
        }

        int length = 0;
        int index = s.length() - 1;

        // Skip trailing spaces
        while (index >= 0 && s.charAt(index) == ' ') {
            index--;
        }

        // Count characters of last word
        while (index >= 0 && s.charAt(index) != ' ') {
            length++;
            index--;
        }

        return length;
    }

    public static void main(String[] args) {

        LengthLastWord solution = new LengthLastWord();

        System.out.println(solution.lengthOfLastWord("Hello World")); // 5
        System.out.println(solution.lengthOfLastWord("   fly me   to   the moon  ")); // 4
        System.out.println(solution.lengthOfLastWord("a")); // 1
        System.out.println(solution.lengthOfLastWord("    ")); // 0
    }
}