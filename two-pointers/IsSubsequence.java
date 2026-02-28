/*
 * LeetCode Problem: #392 - Is Subsequence
 *
 * Time Complexity: O(n)
 *   n = length of t
 *
 * Space Complexity: O(1)
 *
 * Core Idea:
 * 1. Use two pointers.
 * 2. Traverse string t.
 * 3. When characters match, move pointer of s.
 * 4. If pointer of s reaches end, s is subsequence.
 *
 * Pattern: Two Pointers / Sequential Matching
 */

public class IsSubsequence {

    public boolean isSubsequence(String s, String t) {

        if (s == null || t == null) {
            return false;
        }

        if (s.length() == 0) {
            return true;
        }

        if (s.length() > t.length()) {
            return false;
        }

        int pointerS = 0;
        int pointerT = 0;

        while (pointerT < t.length() && pointerS < s.length()) {

            if (s.charAt(pointerS) == t.charAt(pointerT)) {
                pointerS++;
            }

            pointerT++;
        }

        return pointerS == s.length();
    }

    public static void main(String[] args) {

        IsSubsequence solution = new IsSubsequence();

        System.out.println(solution.isSubsequence("abc", "ahbgdc")); // true
        System.out.println(solution.isSubsequence("axc", "ahbgdc")); // false
        System.out.println(solution.isSubsequence("", "ahbgdc"));    // true
    }
}