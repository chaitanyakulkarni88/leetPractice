import java.util.*;

public class MaximalSquare {

    /*
     * LeetCode Problem: 221 - Maximal Square
     *
     * Time Complexity:
     * 2D DP           : O(m * n)
     * Optimized 1D DP : O(m * n)
     *
     * Space Complexity:
     * 2D DP           : O(m * n)
     * Optimized 1D DP : O(n)
     *
     * m = rows
     * n = columns
     *
     * Problem:
     * Given a binary matrix filled with '0' and '1',
     * find the largest square containing only '1's
     * and return its area.
     *
     * Core Idea:
     * Let dp[i][j] represent the side length of the largest
     * square ending at cell (i, j).
     *
     * If matrix[i][j] == '1':
     *
     *      dp[i][j] = min(
     *          dp[i-1][j],    // top
     *          dp[i][j-1],    // left
     *          dp[i-1][j-1]   // diagonal
     *      ) + 1
     *
     * If matrix[i][j] == '0':
     *      dp[i][j] = 0
     *
     * Track the maximum side length and return side².
     *
     * Algorithm Pattern:
     * Grid Dynamic Programming
     */

    /* -----------------------------------------------------
       Approach 1: Simple 2D Dynamic Programming
       ----------------------------------------------------- */

    public static int maximalSquare2D(char[][] matrix) {

        if (matrix == null || matrix.length == 0 ||
                matrix[0].length == 0) {
            return 0;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] dp = new int[rows + 1][cols + 1];

        int maxSide = 0;

        for (int i = 1; i <= rows; i++) {

            for (int j = 1; j <= cols; j++) {

                if (matrix[i - 1][j - 1] == '1') {

                    dp[i][j] = Math.min(
                            Math.min(dp[i - 1][j], dp[i][j - 1]),
                            dp[i - 1][j - 1]
                    ) + 1;

                    maxSide = Math.max(maxSide, dp[i][j]);
                }
            }
        }

        return maxSide * maxSide;
    }

    /* -----------------------------------------------------
       Approach 2: Space Optimized 1D Dynamic Programming
       ----------------------------------------------------- */

    public static int maximalSquare1D(char[][] matrix) {

        if (matrix == null || matrix.length == 0 ||
                matrix[0].length == 0) {
            return 0;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        int[] dp = new int[cols + 1];
        int maxSide = 0;
        int prevDiagonal = 0;

        for (int i = 1; i <= rows; i++) {

            prevDiagonal = 0;

            for (int j = 1; j <= cols; j++) {

                int temp = dp[j];

                if (matrix[i - 1][j - 1] == '1') {

                    dp[j] = Math.min(
                            Math.min(dp[j], dp[j - 1]),
                            prevDiagonal
                    ) + 1;

                    maxSide = Math.max(maxSide, dp[j]);

                } else {

                    dp[j] = 0;
                }

                prevDiagonal = temp;
            }
        }

        return maxSide * maxSide;
    }

    public static void main(String[] args) {

        char[][] matrix1 = {
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        };

        char[][] matrix2 = {
                {'0','1'},
                {'1','0'}
        };

        char[][] matrix3 = {
                {'0'}
        };

        System.out.println("Using 2D DP:");
        System.out.println("Example 1 → " + maximalSquare2D(matrix1));
        System.out.println("Example 2 → " + maximalSquare2D(matrix2));
        System.out.println("Example 3 → " + maximalSquare2D(matrix3));

        System.out.println();

        System.out.println("Using 1D Optimized DP:");
        System.out.println("Example 1 → " + maximalSquare1D(matrix1));
        System.out.println("Example 2 → " + maximalSquare1D(matrix2));
        System.out.println("Example 3 → " + maximalSquare1D(matrix3));
    }
}