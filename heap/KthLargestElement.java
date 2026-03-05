import java.util.*;

public class KthLargestElement {

    /*
     * LeetCode Problem: 215 - Kth Largest Element in an Array
     *
     * Time Complexity:
     * Quickselect : O(n) average, O(n^2) worst-case
     * Min Heap    : O(n log k)
     *
     * Space Complexity:
     * Quickselect : O(1)
     * Min Heap    : O(k)
     *
     * Problem:
     * Find the kth largest element in an unsorted array.
     *
     * Core Idea:
     * Convert kth largest to (n - k)th smallest element
     * and use Quickselect (partial QuickSort).
     *
     * Algorithm Patterns:
     * 1. Quickselect (selection algorithm)
     * 2. Min Heap (Top-K pattern)
     */

    /* -----------------------------------------------------
       Approach 1: Quickselect (Optimal Average Case)
       ----------------------------------------------------- */

    public static int findKthLargestQuickselect(int[] nums, int k) {

        if (nums == null || nums.length == 0 ||
                k <= 0 || k > nums.length) {
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
            }
            else if (pivotIndex < targetIndex) {
                left = pivotIndex + 1;
            }
            else {
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

    /* -----------------------------------------------------
       Approach 2: Min Heap (Simpler Alternative)
       ----------------------------------------------------- */

    public static int findKthLargestHeap(int[] nums, int k) {

        if (nums == null || nums.length == 0 ||
                k <= 0 || k > nums.length) {
            throw new IllegalArgumentException("Invalid input.");
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {

            minHeap.offer(num);

            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        return minHeap.peek();
    }

    private static void swap(int[] nums, int i, int j) {

        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {

        int[] nums1 = {3, 2, 1, 5, 6, 4};
        int[] nums2 = {3, 2, 3, 1, 2, 4, 5, 5, 6};

        System.out.println("Using Quickselect:");
        System.out.println("Array 1 → " +
                findKthLargestQuickselect(nums1.clone(), 2));
        System.out.println("Array 2 → " +
                findKthLargestQuickselect(nums2.clone(), 4));

        System.out.println();

        System.out.println("Using Min Heap:");
        System.out.println("Array 1 → " +
                findKthLargestHeap(nums1, 2));
        System.out.println("Array 2 → " +
                findKthLargestHeap(nums2, 4));
    }
}