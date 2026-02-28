/*
 * LeetCode Problem: #209 - Minimum Size Subarray Sum
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 * Core Idea:
 * 1. Use sliding window technique.
 * 2. Expand right pointer to increase sum.
 * 3. When sum >= target, shrink from left.
 * 4. Track minimum window length.
 * 5. If no valid window found, return 0.
 *
 * Pattern: Sliding Window (Variable Size)
 */

public class MinimumSizeSubarraySum {

    public int minSubArrayLen(int target, int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int left = 0;
        int currentSum = 0;
        int minLength = Integer.MAX_VALUE;

        for (int right = 0; right < nums.length; right++) {

            currentSum += nums[right];

            while (currentSum >= target) {
                minLength = Math.min(minLength, right - left + 1);
                currentSum -= nums[left];
                left++;
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    public static void main(String[] args) {

        MinimumSizeSubarraySum solution = new MinimumSizeSubarraySum();

        int[] nums1 = {2,3,1,2,4,3};
        System.out.println(solution.minSubArrayLen(7, nums1)); // 2

        int[] nums2 = {1,4,4};
        System.out.println(solution.minSubArrayLen(4, nums2)); // 1

        int[] nums3 = {1,1,1,1};
        System.out.println(solution.minSubArrayLen(10, nums3)); // 0
    }
}