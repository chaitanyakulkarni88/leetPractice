/*
 * LeetCode Problem: #80 - Remove Duplicates from Sorted Array II
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 * Core Idea:
 * 1. Since array is sorted, duplicates are adjacent.
 * 2. Allow at most two occurrences of each element.
 * 3. Maintain a write pointer.
 * 4. For each element, check if it differs from nums[writeIndex - 2].
 * 5. If different, write it and move pointer.
 *
 * Pattern: Two Pointers (Generalized Duplicate Control)
 */

import java.util.Arrays;

public class RemoveDuplicatesSortedArrayPart2 {

    public int removeDuplicates(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length <= 2) {
            return nums.length;
        }

        int writeIndex = 2;

        for (int readIndex = 2; readIndex < nums.length; readIndex++) {
            if (nums[readIndex] != nums[writeIndex - 2]) {
                nums[writeIndex++] = nums[readIndex];
            }
        }

        return writeIndex;
    }

    public static void main(String[] args) {

        RemoveDuplicatesSortedArrayPart2 solution = new RemoveDuplicatesSortedArrayPart2();

        int[] nums1 = {0, 0, 1, 1, 1, 1, 2, 3, 3};
        int length1 = solution.removeDuplicates(nums1);
        System.out.println("Valid Length: " + length1);
        System.out.println("Modified Array: " + Arrays.toString(Arrays.copyOf(nums1, length1)));

        int[] nums2 = {1, 1, 1, 1};
        int length2 = solution.removeDuplicates(nums2);
        System.out.println("Valid Length: " + length2);
        System.out.println("Modified Array: " + Arrays.toString(Arrays.copyOf(nums2, length2)));

        int[] nums3 = {1, 2, 3};
        int length3 = solution.removeDuplicates(nums3);
        System.out.println("Valid Length: " + length3);
        System.out.println("Modified Array: " + Arrays.toString(Arrays.copyOf(nums3, length3)));
    }
}