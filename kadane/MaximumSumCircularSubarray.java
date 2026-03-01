import java.util.*;

public class MaximumSumCircularSubarray {

    /*
     * LeetCode Problem: 918 - Maximum Sum Circular Subarray
     *
     * Time Complexity  : O(n)
     * Space Complexity : O(1)
     *
     * Core Idea:
     * 1. Normal max subarray → Kadane's algorithm.
     * 2. Circular max = totalSum - minimum subarray sum.
     * 3. Handle all-negative case separately.
     *
     * Algorithm Pattern: Dynamic Programming (Kadane Variant)
     */

    public static int maxSubarraySumCircular(int[] nums) {

        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Input array must not be null or empty.");
        }

        int totalSum = 0;

        int currentMax = nums[0];
        int globalMax = nums[0];

        int currentMin = nums[0];
        int globalMin = nums[0];

        totalSum = nums[0];

        for (int index = 1; index < nums.length; index++) {

            int value = nums[index];

            currentMax = Math.max(value, currentMax + value);
            globalMax = Math.max(globalMax, currentMax);

            currentMin = Math.min(value, currentMin + value);
            globalMin = Math.min(globalMin, currentMin);

            totalSum += value;
        }

        if (globalMax < 0) {
            return globalMax;
        }

        return Math.max(globalMax, totalSum - globalMin);
    }

    public static void main(String[] args) {

        int[] nums1 = {1, -2, 3, -2};
        int[] nums2 = {5, -3, 5};
        int[] nums3 = {-3, -2, -3};

        System.out.println("Input 1: " + Arrays.toString(nums1));
        System.out.println("Max Circular Sum: " + maxSubarraySumCircular(nums1));

        System.out.println("\nInput 2: " + Arrays.toString(nums2));
        System.out.println("Max Circular Sum: " + maxSubarraySumCircular(nums2));

        System.out.println("\nInput 3: " + Arrays.toString(nums3));
        System.out.println("Max Circular Sum: " + maxSubarraySumCircular(nums3));
    }
}