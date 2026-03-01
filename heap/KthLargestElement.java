import java.util.*;

public class KthLargestElement {

    /*
     * LeetCode Problem: 215 - Kth Largest Element in an Array
     *
     * Time Complexity  : O(n) average, O(n^2) worst-case
     * Space Complexity : O(1)
     *
     * Core Idea:
     * 1. Convert kth largest to (n - k)th smallest index.
     * 2. Use Quickselect (partial QuickSort).
     * 3. Partition around pivot.
     * 4. Recurse only on relevant side.
     *
     * Algorithm Pattern: Quickselect
     */

    public static int findKthLargest(int[] nums, int k) {

        if (nums == null || nums.length == 0 || k <= 0 || k > nums.length) {
            throw new IllegalArgumentException("Invalid input.");
        }

        int targetIndex = nums.length - k;

        return quickSelect(nums, 0, nums.length - 1, targetIndex);
    }

    private static int quickSelect(int[] nums,
                                   int left,
                                   int right,
                                   int targetIndex) {

        while (left <= right) {

            int pivotIndex = partition(nums, left, right);

            if (pivotIndex == targetIndex) {
                return nums[pivotIndex];
            } else if (pivotIndex < targetIndex) {
                left = pivotIndex + 1;
            } else {
                right = pivotIndex - 1;
            }
        }

        throw new IllegalStateException("Unexpected state.");
    }

    private static int partition(int[] nums, int left, int right) {

        int pivot = nums[right];
        int storeIndex = left;

        for (int i = left; i < right; i++) {
            if (nums[i] < pivot) {
                swap(nums, storeIndex, i);
                storeIndex++;
            }
        }

        swap(nums, storeIndex, right);

        return storeIndex;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {

        int[] nums1 = {3, 2, 1, 5, 6, 4};
        int[] nums2 = {3, 2, 3, 1, 2, 4, 5, 5, 6};

        System.out.println("Array 1: " + Arrays.toString(nums1));
        System.out.println("K = 2 → " + findKthLargest(nums1, 2));

        System.out.println("\nArray 2: " + Arrays.toString(nums2));
        System.out.println("K = 4 → " + findKthLargest(nums2, 4));
    }
}