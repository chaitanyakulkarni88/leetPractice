import java.util.*;

public class InterleavingString {

    /*
     * LeetCode Problem: 97 - Interleaving String
     *
     * Time Complexity:
     * DFS + Memoization  : O(m * n)
     * Bottom-Up DP       : O(m * n)
     *
     * Space Complexity:
     * DFS + Memoization  : O(m * n)
     * Bottom-Up DP       : O(n)
     *
     * m = length of s1
     * n = length of s2
     *
     * Problem:
     * Determine whether s3 is formed by interleaving s1 and s2.
     *
     * Rules:
     * - Characters from s1 and s2 must maintain their original order.
     * - We must use all characters from s1 and s2.
     *
     * Core Idea:
     * If we have taken:
     *      i characters from s1
     *      j characters from s2
     *
     * Then we must have formed:
     *      i + j characters from s3.
     *
     * DP State:
     *      dp[i][j] = whether
     *      s1[0..i) and s2[0..j) can form s3[0..i+j)
     *
     * Algorithm Patterns:
     * 1. DFS + Memoization (Top-Down DP)
     * 2. Bottom-Up DP (1D space optimization)
     */

    /* -----------------------------------------------------
       Approach 1: DFS + Memoization
       ----------------------------------------------------- */

    public static boolean isInterleaveDFS(String s1, String s2, String s3) {

        if (s1 == null || s2 == null || s3 == null) {
            throw new IllegalArgumentException("Strings must not be null.");
        }

        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        Boolean[][] memo = new Boolean[s1.length() + 1][s2.length() + 1];

        return dfs(s1, s2, s3, 0, 0, memo);
    }

    private static boolean dfs(String s1, String s2, String s3,
                               int i, int j,
                               Boolean[][] memo) {

        if (i == s1.length() && j == s2.length()) {
            return true;
        }

        if (memo[i][j] != null) {
            return memo[i][j];
        }

        int k = i + j;
        boolean ans = false;

        if (i < s1.length() && s1.charAt(i) == s3.charAt(k)) {
            ans = dfs(s1, s2, s3, i + 1, j, memo);
        }

        if (!ans && j < s2.length() && s2.charAt(j) == s3.charAt(k)) {
            ans = dfs(s1, s2, s3, i, j + 1, memo);
        }

        memo[i][j] = ans;
        return ans;
    }

    /* -----------------------------------------------------
       Approach 2: Bottom-Up DP (Space Optimized)
       ----------------------------------------------------- */

    public static boolean isInterleaveDP(String s1, String s2, String s3) {

        if (s1 == null || s2 == null || s3 == null) {
            throw new IllegalArgumentException("Strings must not be null.");
        }

        int m = s1.length();
        int n = s2.length();

        if (m + n != s3.length()) {
            return false;
        }

        boolean[] dp = new boolean[n + 1];

        dp[0] = true;

        // Initialize first row (only using s2)
        for (int j = 1; j <= n; j++) {
            dp[j] = dp[j - 1] &&
                    s2.charAt(j - 1) == s3.charAt(j - 1);
        }

        for (int i = 1; i <= m; i++) {

            // First column (only using s1)
            dp[0] = dp[0] &&
                    s1.charAt(i - 1) == s3.charAt(i - 1);

            for (int j = 1; j <= n; j++) {

                char c = s3.charAt(i + j - 1);

                dp[j] =
                        (dp[j] && s1.charAt(i - 1) == c) ||
                                (dp[j - 1] && s2.charAt(j - 1) == c);
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {

        String s1 = "aabcc";
        String s2 = "dbbca";

        String s3 = "aadbbcbcac";   // true
        String s4 = "aadbbbaccc";   // false

        System.out.println("Using DFS + Memoization:");
        System.out.println("Example 1 → " + isInterleaveDFS(s1, s2, s3));
        System.out.println("Example 2 → " + isInterleaveDFS(s1, s2, s4));

        System.out.println();

        System.out.println("Using Bottom-Up DP:");
        System.out.println("Example 1 → " + isInterleaveDP(s1, s2, s3));
        System.out.println("Example 2 → " + isInterleaveDP(s1, s2, s4));

        System.out.println();

        System.out.println("Edge Case → " +
                isInterleaveDP("", "", ""));
    }
}