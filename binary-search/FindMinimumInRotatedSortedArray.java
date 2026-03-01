import java.util.*;

public class FindMinimumInRotatedSortedArray {

    /*
     * LeetCode Problem: 153 - Find Minimum in Rotated Sorted Array
     *
     * Time Complexity  : O(log n)
     * Space Complexity : O(1)
     *
     * Core Idea:
     * 1. Use binary search to locate rotation pivot.
     * 2. If mid element > right element, minimum is on right.
     * 3. Otherwise, minimum is at mid or on left.
     * 4. Continue until left == right.
     *
     * Algorithm Pattern: Binary Search (Pivot Detection)
     */

    public static int findMin(int[] nums) {

        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Input array must not be null or empty.");
        }

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return nums[left];
    }

    public static void main(String[] args) {

        int[] nums1 = {3, 4, 5, 1, 2};
        int[] nums2 = {4, 5, 6, 7, 0, 1, 2};
        int[] nums3 = {11, 13, 15, 17};
        int[] nums4 = {2, 1};

        System.out.println("Array 1: " + Arrays.toString(nums1));
        System.out.println("Minimum: " + findMin(nums1));

        System.out.println("\nArray 2: " + Arrays.toString(nums2));
        System.out.println("Minimum: " + findMin(nums2));

        System.out.println("\nArray 3: " + Arrays.toString(nums3));
        System.out.println("Minimum: " + findMin(nums3));

        System.out.println("\nArray 4: " + Arrays.toString(nums4));
        System.out.println("Minimum: " + findMin(nums4));
    }
}