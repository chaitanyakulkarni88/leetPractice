import java.util.*;

public class EditDistance {

    /*
     * LeetCode Problem: 72 - Edit Distance
     *
     * Time Complexity:
     * 2D DP           : O(m * n)
     * Optimized 1D DP : O(m * n)
     *
     * Space Complexity:
     * 2D DP           : O(m * n)
     * Optimized 1D DP : O(n)
     *
     * m = length of word1
     * n = length of word2
     *
     * Problem:
     * Find the minimum number of operations required to convert
     * word1 into word2.
     *
     * Allowed Operations:
     * 1. Insert
     * 2. Delete
     * 3. Replace
     *
     * DP Idea:
     * dp[i][j] represents the minimum operations required to convert:
     *
     *      word1[0..i) → word2[0..j)
     *
     * Transition:
     *
     * If characters match:
     *      dp[i][j] = dp[i-1][j-1]
     *
     * Else:
     *      dp[i][j] = 1 + min(
     *          dp[i-1][j],    // delete
     *          dp[i][j-1],    // insert
     *          dp[i-1][j-1]   // replace
     *      )
     *
     * Algorithm Pattern:
     * Dynamic Programming (String Transformation)
     */

    /* -----------------------------------------------------
       Approach 1: Simple 2D Dynamic Programming
       ----------------------------------------------------- */

    public static int minDistance2D(String word1, String word2) {

        if (word1 == null || word2 == null) {
            throw new IllegalArgumentException("Inputs must not be null.");
        }

        int m = word1.length();
        int n = word2.length();

        int[][] dp = new int[m + 1][n + 1];

        // Base cases
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }

        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= m; i++) {

            for (int j = 1; j <= n; j++) {

                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {

                    dp[i][j] = dp[i - 1][j - 1];

                } else {

                    dp[i][j] = 1 + Math.min(
                            Math.min(dp[i - 1][j], dp[i][j - 1]),
                            dp[i - 1][j - 1]
                    );
                }
            }
        }

        return dp[m][n];
    }

    /* -----------------------------------------------------
       Approach 2: Space Optimized 1D Dynamic Programming
       ----------------------------------------------------- */

    public static int minDistance1D(String word1, String word2) {

        if (word1 == null || word2 == null) {
            throw new IllegalArgumentException("Inputs must not be null.");
        }

        int m = word1.length();
        int n = word2.length();

        int[] dp = new int[n + 1];

        for (int j = 0; j <= n; j++) {
            dp[j] = j;
        }

        for (int i = 1; i <= m; i++) {

            int prevDiagonal = dp[0];
            dp[0] = i;

            for (int j = 1; j <= n; j++) {

                int temp = dp[j];

                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {

                    dp[j] = prevDiagonal;

                } else {

                    dp[j] = 1 + Math.min(
                            Math.min(dp[j], dp[j - 1]),
                            prevDiagonal
                    );
                }

                prevDiagonal = temp;
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {

        String word1 = "horse";
        String word2 = "ros";

        String word3 = "intention";
        String word4 = "execution";

        System.out.println("Using 2D DP:");
        System.out.println("Example 1 → " + minDistance2D(word1, word2)); // 3
        System.out.println("Example 2 → " + minDistance2D(word3, word4)); // 5

        System.out.println();

        System.out.println("Using 1D Optimized DP:");
        System.out.println("Example 1 → " + minDistance1D(word1, word2)); // 3
        System.out.println("Example 2 → " + minDistance1D(word3, word4)); // 5

        System.out.println();

        System.out.println("Edge Case → " +
                minDistance1D("", "abc")); // 3
    }
}