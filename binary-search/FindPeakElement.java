import java.util.*;

public class FindPeakElement {

    /*
     * LeetCode Problem: 162 - Find Peak Element
     *
     * Time Complexity  : O(log n)
     * Space Complexity : O(1)
     *
     * Core Idea:
     * 1. Use binary search on the slope.
     * 2. If nums[mid] > nums[mid + 1], peak is on left (including mid).
     * 3. Otherwise, peak is on right.
     * 4. Continue until left == right.
     *
     * Algorithm Pattern: Binary Search (on Answer Space)
     */

    public static int findPeakElement(int[] nums) {

        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Input array must not be null or empty.");
        }

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    public static void main(String[] args) {

        int[] nums1 = {1, 2, 3, 1};
        int[] nums2 = {1, 2, 1, 3, 5, 6, 4};
        int[] nums3 = {1};

        System.out.println("Array 1: " + Arrays.toString(nums1));
        System.out.println("Peak Index: " + findPeakElement(nums1));

        System.out.println("\nArray 2: " + Arrays.toString(nums2));
        System.out.println("Peak Index: " + findPeakElement(nums2));

        System.out.println("\nArray 3: " + Arrays.toString(nums3));
        System.out.println("Peak Index: " + findPeakElement(nums3));
    }
}