/*
 * LeetCode Problem: #28 - Find the Index of the First Occurrence in a String
 *
 * Time Complexity: O(n * m)
 *   n = haystack length
 *   m = needle length
 *
 * Space Complexity: O(1)
 *
 * Core Idea:
 * 1. Traverse haystack.
 * 2. For each position, check character-by-character match.
 * 3. If full match found, return index.
 * 4. Otherwise continue.
 *
 * Pattern: String Matching (Naive Approach)
 */

public class FirstOccurrenceInString {

    public int strStr(String haystack, String needle) {

        if (haystack == null || needle == null) {
            return -1;
        }

        if (needle.length() == 0) {
            return 0;
        }

        int n = haystack.length();
        int m = needle.length();

        if (m > n) {
            return -1;
        }

        for (int i = 0; i <= n - m; i++) {

            int j = 0;

            while (j < m && haystack.charAt(i + j) == needle.charAt(j)) {
                j++;
            }

            if (j == m) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        FirstOccurrenceInString solution = new FirstOccurrenceInString();

        System.out.println(solution.strStr("leetcode", "code"));  // 4
        System.out.println(solution.strStr("hello", "ll"));       // 2
        System.out.println(solution.strStr("aaaaa", "bba"));      // -1
        System.out.println(solution.strStr("a", ""));             // 0
    }
}