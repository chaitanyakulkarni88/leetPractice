/*
 * LeetCode Problem: #27 - Remove Element
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 * Core Idea:
 * 1. Use a write pointer to track position of valid elements.
 * 2. Iterate through the array.
 * 3. If element != val, copy it to write pointer.
 * 4. Return total count of valid elements.
 *
 * Pattern: Two Pointers (Overwrite / Slow-Fast Pointer)
 */

import java.util.Arrays;

public class RemoveElement {

    public int removeElement(int[] nums, int val) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int writeIndex = 0;

        for (int num : nums) {
            if (num != val) {
                nums[writeIndex++] = num;
            }
        }

        return writeIndex;
    }

    public static void main(String[] args) {

        RemoveElement solution = new RemoveElement();

        int[] nums1 = {0, 1, 2, 2, 3, 0, 4, 2};
        int length1 = solution.removeElement(nums1, 2);
        System.out.println("New Length: " + length1);
        System.out.println("Modified Array: " + Arrays.toString(Arrays.copyOf(nums1, length1)));

        int[] nums2 = {2, 2, 2};
        int length2 = solution.removeElement(nums2, 2);
        System.out.println("New Length: " + length2);
        System.out.println("Modified Array: " + Arrays.toString(Arrays.copyOf(nums2, length2)));

        int[] nums3 = {};
        int length3 = solution.removeElement(nums3, 1);
        System.out.println("New Length: " + length3);
    }
}