/*
 * LeetCode Problem: #151 - Reverse Words in a String
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 *
 * Core Idea:
 * 1. Traverse string from end.
 * 2. Skip trailing spaces.
 * 3. Identify each word boundary.
 * 4. Append words in reverse order.
 * 5. Ensure single space separation.
 *
 * Pattern: Reverse Traversal / String Parsing
 */

public class ReverseWordsInString {

    public String reverseWords(String s) {

        if (s == null || s.length() == 0) {
            return "";
        }

        StringBuilder result = new StringBuilder();
        int index = s.length() - 1;

        while (index >= 0) {

            // Skip spaces
            while (index >= 0 && s.charAt(index) == ' ') {
                index--;
            }

            if (index < 0) break;

            int end = index;

            // Find start of word
            while (index >= 0 && s.charAt(index) != ' ') {
                index--;
            }

            result.append(s, index + 1, end + 1).append(" ");
        }

        return result.toString().trim();
    }

    public static void main(String[] args) {

        ReverseWordsInString solution = new ReverseWordsInString();

        System.out.println(solution.reverseWords("the sky is blue"));
        System.out.println(solution.reverseWords("  hello world  "));
        System.out.println(solution.reverseWords("a good   example"));
        System.out.println(solution.reverseWords("    "));
    }
}