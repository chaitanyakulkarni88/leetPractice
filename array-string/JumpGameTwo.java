/*
 * LeetCode Problem: #45 - Jump Game II
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 * Core Idea:
 * 1. Treat the problem like BFS levels.
 * 2. Track current coverage range (farthest reachable).
 * 3. When reaching the end of current jump range,
 *    increase jump count and update range.
 * 4. Stop once coverage reaches destination.
 *
 * Pattern: Greedy / Level-Based Traversal
 */

public class JumpGameTwo {

    public int jump(int[] nums) {

        if (nums == null || nums.length <= 1) {
            return 0;
        }

        int totalJumps = 0;
        int currentEnd = 0;
        int farthestReach = 0;

        for (int i = 0; i < nums.length - 1; i++) {

            farthestReach = Math.max(farthestReach, i + nums[i]);

            if (i == currentEnd) {
                totalJumps++;
                currentEnd = farthestReach;
            }
        }

        return totalJumps;
    }

    public static void main(String[] args) {

        JumpGameTwo solution = new JumpGameTwo();

        int[] nums1 = {2, 3, 1, 1, 4};
        System.out.println("Min Jumps: " + solution.jump(nums1));

        int[] nums2 = {1, 2};
        System.out.println("Min Jumps: " + solution.jump(nums2));

        int[] nums3 = {1};
        System.out.println("Min Jumps: " + solution.jump(nums3));
    }
}