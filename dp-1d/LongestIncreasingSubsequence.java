import java.util.*;

public class LongestIncreasingSubsequence {

    /*
     * LeetCode Problem: 300 - Longest Increasing Subsequence
     *
     * Time Complexity  : O(n log n)
     * Space Complexity : O(n)
     *
     * Core Idea:
     * 1. Maintain an array tails[] where:
     *      tails[i] = smallest possible tail of an increasing
     *      subsequence of length i + 1.
     * 2. For each number:
     *      - Binary search in tails.
     *      - Replace or extend.
     * 3. Length of tails = LIS length.
     *
     * Algorithm Pattern: Binary Search + Greedy (Patience Sorting)
     */

    public static int lengthOfLIS(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] tails = new int[nums.length];
        int size = 0;

        for (int num : nums) {

            int left = 0;
            int right = size;

            while (left < right) {

                int mid = left + (right - left) / 2;

                if (tails[mid] < num) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            tails[left] = num;

            if (left == size) {
                size++;
            }
        }

        return size;
    }

    public static void main(String[] args) {

        int[] nums1 = {10, 9, 2, 5, 3, 7, 101, 18};
        int[] nums2 = {0, 1, 0, 3, 2, 3};
        int[] nums3 = {7, 7, 7, 7};

        System.out.println("Example 1 → " + lengthOfLIS(nums1));
        System.out.println("Example 2 → " + lengthOfLIS(nums2));
        System.out.println("Example 3 → " + lengthOfLIS(nums3));
    }
}