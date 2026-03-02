import java.util.*;

public class BinarySearch {

    /*
     * Algorithm: Binary Search (Iterative)
     *
     * Time Complexity  : O(log n)
     * Space Complexity : O(1)
     *
     * Core Idea:
     * 1. Maintain search space [left, right].
     * 2. Compute mid safely to avoid overflow.
     * 3. Compare mid value with target.
     * 4. Narrow search space by half each iteration.
     * 5. Return index if found, else -1.
     *
     * Important:
     * - Array must be sorted.
     */

    public static int binarySearch(int[] arr, int target) {

        if (arr == null || arr.length == 0) {
            return -1;
        }

        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid;
            }

            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        int[] arr = {1, 4, 6, 8, 9, 11, 21};

        System.out.println("Index of 11 → " + binarySearch(arr, 11));
        System.out.println("Index of 6  → " + binarySearch(arr, 6));
        System.out.println("Index of 5  → " + binarySearch(arr, 5));
        System.out.println("Index of 1  → " + binarySearch(arr, 1));
        System.out.println("Index of 21 → " + binarySearch(arr, 21));
    }
}