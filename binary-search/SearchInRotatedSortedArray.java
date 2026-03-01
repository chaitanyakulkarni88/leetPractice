import java.util.*;

public class SearchInRotatedSortedArray {

    /*
     * LeetCode Problem: 33 - Search in Rotated Sorted Array
     *
     * Time Complexity  : O(log n)
     * Space Complexity : O(1)
     *
     * Core Idea:
     * 1. Use modified binary search.
     * 2. At each step, determine which half is sorted.
     * 3. Check if target lies within sorted half.
     * 4. Narrow search space accordingly.
     *
     * Algorithm Pattern: Modified Binary Search
     */

    public static int search(int[] nums, int target) {

        if (nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            // Left half is sorted
            if (nums[left] <= nums[mid]) {

                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            // Right half is sorted
            else {

                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        int[] nums1 = {4, 5, 6, 7, 0, 1, 2};
        int[] nums2 = {4, 5, 6, 7, 0, 1, 2};
        int[] nums3 = {1};
        int[] nums4 = {3, 1};

        System.out.println("Array 1: " + Arrays.toString(nums1));
        System.out.println("Search 0 → " + search(nums1, 0));

        System.out.println("\nArray 2: " + Arrays.toString(nums2));
        System.out.println("Search 3 → " + search(nums2, 3));

        System.out.println("\nArray 3: " + Arrays.toString(nums3));
        System.out.println("Search 0 → " + search(nums3, 0));

        System.out.println("\nArray 4: " + Arrays.toString(nums4));
        System.out.println("Search 1 → " + search(nums4, 1));
    }
}