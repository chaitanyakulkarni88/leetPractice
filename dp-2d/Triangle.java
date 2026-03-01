import java.util.*;

public class Triangle {

    /*
     * LeetCode Problem: 120 - Triangle
     *
     * Time Complexity  : O(n^2)
     * Space Complexity : O(n)
     *
     * Core Idea:
     * 1. Use bottom-up dynamic programming.
     * 2. Start from last row and move upward.
     * 3. For each cell:
     *      dp[j] = min(dp[j], dp[j + 1]) + triangle[i][j]
     * 4. Final answer will be at dp[0].
     *
     * Algorithm Pattern: Dynamic Programming (Bottom-Up)
     */

    public static int minimumTotal(List<List<Integer>> triangle) {

        if (triangle == null || triangle.isEmpty()) {
            return 0;
        }

        int n = triangle.size();
        int[] dp = new int[n];

        List<Integer> lastRow = triangle.get(n - 1);
        for (int i = 0; i < lastRow.size(); i++) {
            dp[i] = lastRow.get(i);
        }

        for (int row = n - 2; row >= 0; row--) {

            List<Integer> currentRow = triangle.get(row);

            for (int col = 0; col <= row; col++) {
                dp[col] = Math.min(dp[col], dp[col + 1]) + currentRow.get(col);
            }
        }

        return dp[0];
    }

    public static void main(String[] args) {

        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(2));
        triangle.add(Arrays.asList(3, 4));
        triangle.add(Arrays.asList(6, 5, 7));
        triangle.add(Arrays.asList(4, 1, 8, 3));

        System.out.println("Minimum Path Sum → " + minimumTotal(triangle));

        List<List<Integer>> triangle2 = new ArrayList<>();
        triangle2.add(Arrays.asList(-10));

        System.out.println("Minimum Path Sum → " + minimumTotal(triangle2));
    }
}