import java.util.HashSet;
import java.util.Set;

/**
 * LeetCode Problem: 73. Set Matrix Zeroes
 *
 * Time Complexity: O(m * n)
 * Space Complexity: O(m + n)
 *
 * Core Idea:
 * 1. First pass: record rows and columns that contain zero.
 * 2. Second pass: set matrix[i][j] to zero if its row or column is marked.
 * 3. Uses additional sets to track zero positions.
 */
public class SetMatrixZeroes {

    public static void main(String[] args) {
        SetMatrixZeroes solution = new SetMatrixZeroes();

        int[][] matrix = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };

        solution.setZeroes(matrix);
        printMatrix(matrix);
    }

    public void setZeroes(int[][] matrix) {
        validateInput(matrix);

        int rows = matrix.length;
        int cols = matrix[0].length;

        Set<Integer> zeroRows = new HashSet<>();
        Set<Integer> zeroCols = new HashSet<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    zeroRows.add(i);
                    zeroCols.add(j);
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (zeroRows.contains(i) || zeroCols.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    private void validateInput(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            throw new IllegalArgumentException("Matrix must not be null or empty.");
        }
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}