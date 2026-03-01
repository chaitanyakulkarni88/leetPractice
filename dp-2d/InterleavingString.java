import java.util.*;

public class InterleavingString {

    /*
     * LeetCode Problem: 97 - Interleaving String
     *
     * Time Complexity  : O(m * n)
     * Space Complexity : O(n)
     *
     * m = length of s1
     * n = length of s2
     *
     * Core Idea:
     * 1. If lengths don’t match → return false.
     * 2. dp[j] represents whether:
     *      s1[0...i) and s2[0...j) can form s3[0...i+j)
     * 3. Transition:
     *      dp[j] =
     *        (dp[j] && s1[i-1] == s3[i+j-1]) ||
     *        (dp[j-1] && s2[j-1] == s3[i+j-1])
     *
     * Algorithm Pattern: 2D DP optimized to 1D
     */

    public static boolean isInterleave(String s1,
                                       String s2,
                                       String s3) {

        if (s1 == null || s2 == null || s3 == null) {
            throw new IllegalArgumentException("Inputs must not be null.");
        }

        int m = s1.length();
        int n = s2.length();

        if (m + n != s3.length()) {
            return false;
        }

        boolean[] dp = new boolean[n + 1];

        dp[0] = true;

        // Initialize first row (i = 0)
        for (int j = 1; j <= n; j++) {
            dp[j] = dp[j - 1] &&
                    s2.charAt(j - 1) == s3.charAt(j - 1);
        }

        for (int i = 1; i <= m; i++) {

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
        String s3 = "aadbbcbcac";
        String s4 = "aadbbbaccc";

        System.out.println("Example 1 → " +
                isInterleave(s1, s2, s3)); // true

        System.out.println("Example 2 → " +
                isInterleave(s1, s2, s4)); // false

        System.out.println("Edge Case → " +
                isInterleave("", "", "")); // true
    }
}