import java.util.*;

public class FindFirstAndLastPosition {

    /*
     * LeetCode Problem: 34 - Find First and Last Position of Element in Sorted Array
     *
     * Time Complexity  : O(log n)
     * Space Complexity : O(1)
     *
     * Core Idea:
     * 1. Perform binary search to find first occurrence (lower bound).
     * 2. Perform binary search to find last occurrence (upper bound).
     * 3. If target not found, return [-1, -1].
     *
     * Algorithm Pattern: Binary Search (Lower & Upper Bound)
     */

    public static int[] searchRange(int[] nums, int target) {

        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }

        int first = findFirst(nums, target);

        if (first == -1) {
            return new int[]{-1, -1};
        }

        int last = findLast(nums, target);

        return new int[]{first, last};
    }

    private static int findFirst(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;
        int result = -1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                result = mid;
                right = mid - 1;  // continue searching left
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    private static int findLast(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;
        int result = -1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                result = mid;
                left = mid + 1;  // continue searching right
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {

        int[] nums1 = {5, 7, 7, 8, 8, 10};
        int[] nums2 = {5, 7, 7, 8, 8, 10};
        int[] nums3 = {};

        System.out.println("Array 1: " + Arrays.toString(nums1));
        System.out.println("Target 8 → " + Arrays.toString(searchRange(nums1, 8)));

        System.out.println("\nArray 2: " + Arrays.toString(nums2));
        System.out.println("Target 6 → " + Arrays.toString(searchRange(nums2, 6)));

        System.out.println("\nArray 3: " + Arrays.toString(nums3));
        System.out.println("Target 0 → " + Arrays.toString(searchRange(nums3, 0)));
    }
}