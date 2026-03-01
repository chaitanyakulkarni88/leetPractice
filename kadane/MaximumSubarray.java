import java.util.*;

public class MaximumSubarray {

    /*
     * LeetCode Problem: 53 - Maximum Subarray
     *
     * Time Complexity  : O(n)
     * Space Complexity : O(1)
     *
     * Core Idea:
     * 1. Use Kadane’s Algorithm.
     * 2. At each index, decide whether to extend current subarray
     *    or start a new subarray.
     * 3. Track global maximum during iteration.
     *
     * Algorithm Pattern: Dynamic Programming (Kadane's Algorithm)
     */

    public static int maxSubArray(int[] nums) {

        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Input array must not be null or empty.");
        }

        int currentMax = nums[0];
        int globalMax = nums[0];

        for (int index = 1; index < nums.length; index++) {

            currentMax = Math.max(nums[index],
                    currentMax + nums[index]);

            globalMax = Math.max(globalMax, currentMax);
        }

        return globalMax;
    }

    public static void main(String[] args) {

        int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] nums2 = {1};
        int[] nums3 = {-1, -2, -3, -4};

        System.out.println("Input 1: " + Arrays.toString(nums1));
        System.out.println("Max Sum : " + maxSubArray(nums1));

        System.out.println("\nInput 2: " + Arrays.toString(nums2));
        System.out.println("Max Sum : " + maxSubArray(nums2));

        System.out.println("\nInput 3: " + Arrays.toString(nums3));
        System.out.println("Max Sum : " + maxSubArray(nums3));
    }
}