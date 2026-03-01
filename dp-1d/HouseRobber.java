import java.util.*;

public class HouseRobber {

    /*
     * LeetCode Problem: 198 - House Robber
     *
     * Time Complexity  : O(n)
     * Space Complexity : O(1)
     *
     * Core Idea:
     * 1. At each house, choose:
     *      - Rob current + two houses before
     *      - Skip current (take previous max)
     * 2. Recurrence:
     *      dp[i] = max(dp[i-1], dp[i-2] + nums[i])
     * 3. Use two variables instead of full DP array.
     *
     * Algorithm Pattern: Dynamic Programming
     */

    public static int rob(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        int prevTwo = nums[0];                           // dp[i-2]
        int prevOne = Math.max(nums[0], nums[1]);        // dp[i-1]

        for (int i = 2; i < nums.length; i++) {

            int current = Math.max(prevOne, prevTwo + nums[i]);
            prevTwo = prevOne;
            prevOne = current;
        }

        return prevOne;
    }

    public static void main(String[] args) {

        int[] nums1 = {1, 2, 3, 1};
        int[] nums2 = {2, 7, 9, 3, 1};
        int[] nums3 = {2};
        int[] nums4 = {2, 1};

        System.out.println("Example 1 → " + rob(nums1));
        System.out.println("Example 2 → " + rob(nums2));
        System.out.println("Example 3 → " + rob(nums3));
        System.out.println("Example 4 → " + rob(nums4));
    }
}