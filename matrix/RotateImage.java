/**
 * LeetCode Problem: 48. Rotate Image
 *
 * Time Complexity: O(n^2)
 * Space Complexity: O(1)
 *
 * Core Idea:
 * 1. Process matrix layer by layer from outer to inner.
 * 2. For each layer, perform 4-way cyclic swaps.
 * 3. Rotate elements in-place without using extra space.
 */
public class RotateImage {

    public static void main(String[] args) {
        RotateImage solution = new RotateImage();

        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        solution.rotate(matrix);

        printMatrix(matrix);
    }

    public void rotate(int[][] matrix) {
        validateInput(matrix);

        int n = matrix.length;

        for (int layer = 0; layer < n / 2; layer++) {
            int first = layer;
            int last = n - 1 - layer;

            for (int i = first; i < last; i++) {
                int offset = i - first;

                int top = matrix[first][i];

                matrix[first][i] = matrix[last - offset][first];
                matrix[last - offset][first] = matrix[last][last - offset];
                matrix[last][last - offset] = matrix[i][last];
                matrix[i][last] = top;
            }
        }
    }

    private void validateInput(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            throw new IllegalArgumentException("Matrix must not be null or empty.");
        }

        int n = matrix.length;
        for (int[] row : matrix) {
            if (row == null || row.length != n) {
                throw new IllegalArgumentException("Matrix must be square (n x n).");
            }
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