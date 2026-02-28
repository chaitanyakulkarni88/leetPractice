/*
 * LeetCode Problem: #189 - Rotate Array
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 * Core Idea:
 * 1. Normalize k using k % n.
 * 2. Reverse entire array.
 * 3. Reverse first k elements.
 * 4. Reverse remaining n-k elements.
 *
 * Pattern: Array Reversal / In-place Transformation
 */

import java.util.Arrays;

public class RotateArray {

    public void rotate(int[] nums, int k) {

        if (nums == null || nums.length <= 1) {
            return;
        }

        int n = nums.length;
        k = ((k % n) + n) % n;

        if (k == 0) {
            return;
        }

        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    private void reverse(int[] nums, int left, int right) {

        while (left < right) {
            int temp = nums[left];
            nums[left++] = nums[right];
            nums[right--] = temp;
        }
    }

    public static void main(String[] args) {

        RotateArray solution = new RotateArray();

        int[] nums1 = {-1, -100, 3, 99};
        solution.rotate(nums1, 5);
        System.out.println("Rotated: " + Arrays.toString(nums1));

        int[] nums2 = {1, 2, 3, 4, 5, 6, 7};
        solution.rotate(nums2, 3);
        System.out.println("Rotated: " + Arrays.toString(nums2));

        int[] nums3 = {1};
        solution.rotate(nums3, 10);
        System.out.println("Rotated: " + Arrays.toString(nums3));
    }
}