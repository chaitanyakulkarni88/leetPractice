/*
 * LeetCode Problem: #55 - Jump Game
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 * Core Idea:
 * 1. Track the farthest index reachable so far.
 * 2. If current index exceeds reachable range, return false.
 * 3. Update farthest reach using max(currentReach, i + nums[i]).
 * 4. If loop completes, last index is reachable.
 *
 * Pattern: Greedy / Farthest Reach Tracking
 */

public class JumpGame {

    public boolean canJump(int[] nums) {

        if (nums == null || nums.length == 0) {
            return false;
        }

        if (nums.length == 1) {
            return true;
        }

        int farthestReach = 0;

        for (int i = 0; i < nums.length; i++) {

            if (i > farthestReach) {
                return false;
            }

            farthestReach = Math.max(farthestReach, i + nums[i]);

            if (farthestReach >= nums.length - 1) {
                return true;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        JumpGame solution = new JumpGame();

        int[] nums1 = {2, 3, 1, 1, 4};
        System.out.println("Can Jump: " + solution.canJump(nums1));

        int[] nums2 = {3, 2, 1, 0, 4};
        System.out.println("Can Jump: " + solution.canJump(nums2));

        int[] nums3 = {0, 1};
        System.out.println("Can Jump: " + solution.canJump(nums3));

        int[] nums4 = {0};
        System.out.println("Can Jump: " + solution.canJump(nums4));
    }
}