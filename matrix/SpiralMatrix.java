/*
 * LeetCode Problem: #54 - Spiral Matrix
 *
 * Time Complexity: O(m * n)
 * Space Complexity: O(1) (excluding output list)
 *
 * Core Idea:
 * 1. Maintain four boundaries:
 *      - top
 *      - bottom
 *      - left
 *      - right
 * 2. Traverse:
 *      left → right
 *      top → bottom
 *      right → left
 *      bottom → top
 * 3. Shrink boundaries after each traversal.
 * 4. Continue until boundaries cross.
 *
 * Pattern: Matrix Boundary Traversal
 */

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> result = new ArrayList<>();

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }

        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        while (top <= bottom && left <= right) {

            // Traverse left to right
            for (int col = left; col <= right; col++) {
                result.add(matrix[top][col]);
            }
            top++;

            // Traverse top to bottom
            for (int row = top; row <= bottom; row++) {
                result.add(matrix[row][right]);
            }
            right--;

            // Traverse right to left
            if (top <= bottom) {
                for (int col = right; col >= left; col--) {
                    result.add(matrix[bottom][col]);
                }
                bottom--;
            }

            // Traverse bottom to top
            if (left <= right) {
                for (int row = bottom; row >= top; row--) {
                    result.add(matrix[row][left]);
                }
                left++;
            }
        }

        return result;
    }

    public static void main(String[] args) {

        SpiralMatrix solution = new SpiralMatrix();

        int[][] matrix1 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        System.out.println(solution.spiralOrder(matrix1));
        // [1,2,3,6,9,8,7,4,5]
    }
}