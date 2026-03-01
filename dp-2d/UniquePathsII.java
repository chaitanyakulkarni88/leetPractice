import java.util.*;

public class UniquePathsII {

    /*
     * LeetCode Problem: 63 - Unique Paths II
     *
     * Time Complexity  : O(m * n)
     * Space Complexity : O(n)
     *
     * Core Idea:
     * 1. Use DP where dp[j] represents number of ways to reach cell (i, j).
     * 2. If obstacle found → dp[j] = 0.
     * 3. Otherwise:
     *      dp[j] += dp[j - 1]
     *    (ways from top + ways from left).
     * 4. Process grid row by row.
     *
     * Algorithm Pattern: Dynamic Programming (Grid)
     */

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {

        if (obstacleGrid == null || obstacleGrid.length == 0 ||
                obstacleGrid[0].length == 0) {
            return 0;
        }

        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;

        int[] dp = new int[cols];

        dp[0] = obstacleGrid[0][0] == 1 ? 0 : 1;

        for (int row = 0; row < rows; row++) {

            for (int col = 0; col < cols; col++) {

                if (obstacleGrid[row][col] == 1) {
                    dp[col] = 0;
                } else if (col > 0) {
                    dp[col] += dp[col - 1];
                }
            }
        }

        return dp[cols - 1];
    }

    public static void main(String[] args) {

        int[][] grid1 = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };

        int[][] grid2 = {
                {0, 1},
                {0, 0}
        };

        int[][] grid3 = {
                {1}
        };

        System.out.println("Example 1 → " + uniquePathsWithObstacles(grid1));
        System.out.println("Example 2 → " + uniquePathsWithObstacles(grid2));
        System.out.println("Example 3 → " + uniquePathsWithObstacles(grid3));
    }
}