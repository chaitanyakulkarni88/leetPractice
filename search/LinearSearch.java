import java.util.*;

public class LinearSearch {

    /*
     * Algorithm: Linear Search
     *
     * Time Complexity  : O(n)
     * Space Complexity : O(1)
     *
     * Core Idea:
     * 1. Traverse array sequentially.
     * 2. Compare each element with target.
     * 3. Return index if found.
     * 4. If not found, return -1.
     *
     * Works on both sorted and unsorted arrays.
     */

    public static int linearSearch(int[] arr, int target) {

        if (arr == null || arr.length == 0) {
            return -1;
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }

        return -1;
    }

    /*
     * Optimized Linear Search (Sorted Array)
     *
     * Additional Optimization:
     * - If current element exceeds target,
     *   we can stop early.
     */

    public static int sortedLinearSearch(int[] arr, int target) {

        if (arr == null || arr.length == 0) {
            return -1;
        }

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == target) {
                return i;
            }

            if (arr[i] > target) {
                break;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        int[] arr1 = {4, 1, 8, 5, 2, 3};
        int[] arr2 = {1, 4, 6, 8, 9, 11, 21};

        System.out.println("Unsorted Search (5) → " +
                linearSearch(arr1, 5));

        System.out.println("Sorted Search (6) → " +
                sortedLinearSearch(arr2, 6));

        System.out.println("Sorted Search (7) → " +
                sortedLinearSearch(arr2, 7));
    }
}