/*
 * LeetCode Problem: #26 - Remove Duplicates from Sorted Array
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 * Core Idea:
 * 1. Since array is sorted, duplicates are adjacent.
 * 2. Maintain a write pointer for unique elements.
 * 3. Compare current element with last unique element.
 * 4. If different, write it and move pointer.
 * 5. Return count of unique elements.
 *
 * Pattern: Two Pointers (Slow-Fast Pointer)
 */

import java.util.Arrays;

public class RemoveDuplicatesSortedArray {

    public int removeDuplicates(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int writeIndex = 1;

        for (int readIndex = 1; readIndex < nums.length; readIndex++) {
            if (nums[readIndex] != nums[writeIndex - 1]) {
                nums[writeIndex++] = nums[readIndex];
            }
        }

        return writeIndex;
    }

    public static void main(String[] args) {

        RemoveDuplicatesSortedArray solution = new RemoveDuplicatesSortedArray();

        int[] nums1 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int length1 = solution.removeDuplicates(nums1);
        System.out.println("Unique Count: " + length1);
        System.out.println("Modified Array: " + Arrays.toString(Arrays.copyOf(nums1, length1)));

        int[] nums2 = {1, 1, 1, 1};
        int length2 = solution.removeDuplicates(nums2);
        System.out.println("Unique Count: " + length2);
        System.out.println("Modified Array: " + Arrays.toString(Arrays.copyOf(nums2, length2)));

        int[] nums3 = {1, 2, 3, 4};
        int length3 = solution.removeDuplicates(nums3);
        System.out.println("Unique Count: " + length3);
        System.out.println("Modified Array: " + Arrays.toString(Arrays.copyOf(nums3, length3)));

        int[] nums4 = {};
        int length4 = solution.removeDuplicates(nums4);
        System.out.println("Unique Count: " + length4);
    }
}