import java.util.*;

public class MinimumPathSum {

    /*
     * LeetCode Problem: 64 - Minimum Path Sum
     *
     * Time Complexity  : O(m * n)
     * Space Complexity : O(n)
     *
     * Core Idea:
     * 1. Use dynamic programming.
     * 2. dp[j] represents minimum path sum to reach cell (i, j).
     * 3. For each cell:
     *      dp[j] = min(dp[j], dp[j - 1]) + grid[i][j]
     * 4. Process row by row.
     *
     * Algorithm Pattern: Dynamic Programming (Grid)
     */

    public static int minPathSum(int[][] grid) {

        if (grid == null || grid.length == 0 ||
                grid[0].length == 0) {
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length;

        int[] dp = new int[cols];

        dp[0] = grid[0][0];

        for (int col = 1; col < cols; col++) {
            dp[col] = dp[col - 1] + grid[0][col];
        }

        for (int row = 1; row < rows; row++) {

            dp[0] += grid[row][0];

            for (int col = 1; col < cols; col++) {
                dp[col] = Math.min(dp[col], dp[col - 1]) + grid[row][col];
            }
        }

        return dp[cols - 1];
    }

    public static void main(String[] args) {

        int[][] grid1 = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };

        int[][] grid2 = {
                {1, 2, 3},
                {4, 5, 6}
        };

        System.out.println("Example 1 → " + minPathSum(grid1));
        System.out.println("Example 2 → " + minPathSum(grid2));
    }
}