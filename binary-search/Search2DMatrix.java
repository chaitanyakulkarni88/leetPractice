import java.util.*;

public class Search2DMatrix {

    /*
     * LeetCode Problem: 74 - Search a 2D Matrix
     *
     * Time Complexity  : O(log(m * n))
     * Space Complexity : O(1)
     *
     * Core Idea:
     * 1. Treat matrix as a flattened sorted array.
     * 2. Apply binary search from 0 to m*n - 1.
     * 3. Convert mid index back to row and column.
     *
     * Algorithm Pattern: Binary Search
     */

    public static boolean searchMatrix(int[][] matrix, int target) {

        if (matrix == null || matrix.length == 0 ||
                matrix[0].length == 0) {
            return false;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        int left = 0;
        int right = rows * cols - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            int row = mid / cols;
            int col = mid % cols;

            int value = matrix[row][col];

            if (value == target) {
                return true;
            }

            if (value < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };

        System.out.println("Target 3  → " + searchMatrix(matrix, 3));
        System.out.println("Target 13 → " + searchMatrix(matrix, 13));
        System.out.println("Target 60 → " + searchMatrix(matrix, 60));
        System.out.println("Target 1  → " + searchMatrix(matrix, 1));
    }
}