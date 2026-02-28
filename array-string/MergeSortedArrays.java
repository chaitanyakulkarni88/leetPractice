/*
 * LeetCode Problem: #88 - Merge Sorted Array
 *
 * Time Complexity: O(m + n)
 * Space Complexity: O(1)
 *
 * Core Idea:
 * 1. Use three pointers starting from the end of valid elements.
 * 2. Compare elements from nums1 and nums2.
 * 3. Place the larger element at the write position.
 * 4. Continue until one array is exhausted.
 * 5. Copy remaining nums2 elements if any.
 *
 * Pattern: Two Pointers (Backward Merge)
 */

import java.util.Arrays;

public class MergeSortedArrays {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        if (n == 0) return;

        int writeIndex = m + n - 1;
        int pointer1 = m - 1;
        int pointer2 = n - 1;

        while (pointer1 >= 0 && pointer2 >= 0) {
            if (nums1[pointer1] > nums2[pointer2]) {
                nums1[writeIndex--] = nums1[pointer1--];
            } else {
                nums1[writeIndex--] = nums2[pointer2--];
            }
        }

        while (pointer2 >= 0) {
            nums1[writeIndex--] = nums2[pointer2--];
        }
    }

    public static void main(String[] args) {

        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));

        int[] nums3 = {0};
        int[] nums4 = {1};
        merge(nums3, 0, nums4, 1);
        System.out.println(Arrays.toString(nums3));
    }
}