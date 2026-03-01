import java.util.*;

public class NQueensII {

    /*
     * LeetCode Problem: 52 - N-Queens II
     *
     * Time Complexity  : O(n!)
     * Space Complexity : O(n)
     *
     * Core Idea:
     * 1. Place one queen per row using backtracking.
     * 2. Track used columns, diagonals, and anti-diagonals.
     * 3. If placing at (row, col) is safe, recurse to next row.
     * 4. Count valid configurations when row == n.
     *
     * Algorithm Pattern: Backtracking
     */

    public static int totalNQueens(int n) {

        if (n <= 0) {
            return 0;
        }

        boolean[] columns = new boolean[n];
        boolean[] diagonals = new boolean[2 * n - 1];      // row - col + (n - 1)
        boolean[] antiDiagonals = new boolean[2 * n - 1];  // row + col

        return backtrack(0, n, columns, diagonals, antiDiagonals);
    }

    private static int backtrack(int row,
                                 int n,
                                 boolean[] columns,
                                 boolean[] diagonals,
                                 boolean[] antiDiagonals) {

        if (row == n) {
            return 1;
        }

        int totalSolutions = 0;

        for (int col = 0; col < n; col++) {

            int diagonalIndex = row - col + (n - 1);
            int antiDiagonalIndex = row + col;

            if (columns[col] || diagonals[diagonalIndex] || antiDiagonals[antiDiagonalIndex]) {
                continue;
            }

            columns[col] = true;
            diagonals[diagonalIndex] = true;
            antiDiagonals[antiDiagonalIndex] = true;

            totalSolutions += backtrack(row + 1,
                    n,
                    columns,
                    diagonals,
                    antiDiagonals);

            columns[col] = false;
            diagonals[diagonalIndex] = false;
            antiDiagonals[antiDiagonalIndex] = false;
        }

        return totalSolutions;
    }

    public static void main(String[] args) {

        int n = 4;

        int totalSolutions = totalNQueens(n);

        System.out.println("N = " + n);
        System.out.println("Total Solutions = " + totalSolutions);
    }
}