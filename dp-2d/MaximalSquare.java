import java.util.*;

public class MaximalSquare {

    /*
     * LeetCode Problem: 221 - Maximal Square
     *
     * Time Complexity  : O(m * n)
     * Space Complexity : O(n)
     *
     * Core Idea:
     * 1. dp[j] represents the side length of the largest square
     *    ending at current row and column j.
     * 2. If matrix[i][j] == '1':
     *      dp[j] = min(top, left, top-left) + 1
     * 3. Track maximum side length.
     * 4. Return maxSide * maxSide (area).
     *
     * Algorithm Pattern: Grid DP
     */

    public static int maximalSquare(char[][] matrix) {

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

        System.out.println("Example 1 → " + maximalSquare(matrix1));
        System.out.println("Example 2 → " + maximalSquare(matrix2));
        System.out.println("Example 3 → " + maximalSquare(matrix3));
    }
}