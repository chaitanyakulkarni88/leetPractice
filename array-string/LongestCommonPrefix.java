/*
 * LeetCode Problem: #14 - Longest Common Prefix
 *
 * Time Complexity: O(n log n + m)
 *   - Sorting: O(n log n)
 *   - Comparing first & last: O(m)
 *
 * Space Complexity: O(1) (excluding sort overhead)
 *
 * Core Idea:
 * 1. Sort the array lexicographically.
 * 2. Compare the first and last strings only.
 * 3. The common prefix of these two defines the answer.
 * 4. Iterate until characters mismatch.
 *
 * Pattern: Sorting + String Comparison
 */

import java.util.Arrays;

public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {

        if (strs == null || strs.length == 0) {
            return "";
        }

        if (strs.length == 1) {
            return strs[0];
        }

        Arrays.sort(strs);

        String first = strs[0];
        String last = strs[strs.length - 1];

        int minLength = Math.min(first.length(), last.length());
        int index = 0;

        while (index < minLength &&
                first.charAt(index) == last.charAt(index)) {
            index++;
        }

        return first.substring(0, index);
    }

    public static void main(String[] args) {

        LongestCommonPrefix solution = new LongestCommonPrefix();

        String[] strs1 = {"flower", "flow", "flight"};
        System.out.println(solution.longestCommonPrefix(strs1)); // "fl"

        String[] strs2 = {"dog", "racecar", "car"};
        System.out.println(solution.longestCommonPrefix(strs2)); // ""

        String[] strs3 = {"a"};
        System.out.println(solution.longestCommonPrefix(strs3)); // "a"
    }
}