import java.util.*;

public class SearchInsertPosition {

    /*
     * LeetCode Problem: 35 - Search Insert Position
     *
     * Time Complexity  : O(log n)
     * Space Complexity : O(1)
     *
     * Core Idea:
     * 1. Use binary search.
     * 2. If target found → return index.
     * 3. If not found → return left pointer (insertion position).
     *
     * Algorithm Pattern: Binary Search
     */

    public static int searchInsert(int[] nums, int target) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }

    public static void main(String[] args) {

        int[] nums = {1, 3, 5, 6};

        System.out.println("Array: " + Arrays.toString(nums));

        System.out.println("Insert position of 5: " + searchInsert(nums, 5));
        System.out.println("Insert position of 2: " + searchInsert(nums, 2));
        System.out.println("Insert position of 7: " + searchInsert(nums, 7));
        System.out.println("Insert position of 0: " + searchInsert(nums, 0));
    }
}