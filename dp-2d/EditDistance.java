import java.util.*;

public class EditDistance {

    /*
     * LeetCode Problem: 72 - Edit Distance
     *
     * Time Complexity  : O(m * n)
     * Space Complexity : O(n)
     *
     * m = length of word1
     * n = length of word2
     *
     * Core Idea:
     * 1. dp[j] represents edit distance between:
     *      word1[0...i) and word2[0...j)
     * 2. If characters match → no extra cost.
     * 3. Else take minimum of:
     *      - Insert
     *      - Delete
     *      - Replace
     * 4. Transition:
     *      dp[j] = min(
     *          dp[j] + 1,        // delete
     *          dp[j - 1] + 1,    // insert
     *          prevDiagonal + 1  // replace
     *      )
     *
     * Algorithm Pattern: 2D DP optimized to 1D
     */

    public static int minDistance(String word1, String word2) {

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
                    dp[j] = Math.min(
                            Math.min(dp[j] + 1, dp[j - 1] + 1),
                            prevDiagonal + 1
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

        System.out.println("Example 1 → " +
                minDistance(word1, word2)); // 3

        System.out.println("Example 2 → " +
                minDistance(word3, word4)); // 5

        System.out.println("Edge Case → " +
                minDistance("", "abc")); // 3
    }
}