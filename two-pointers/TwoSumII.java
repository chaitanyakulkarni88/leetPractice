/*
 * LeetCode Problem: #167 - Two Sum II (Input Array Is Sorted)
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 * Core Idea:
 * 1. Use two pointers: left at start, right at end.
 * 2. If sum > target, move right pointer left.
 * 3. If sum < target, move left pointer right.
 * 4. If equal, return 1-based indices.
 *
 * Pattern: Two Pointers (Opposite Direction)
 */

import java.util.Arrays;

public class TwoSumII {

    public int[] twoSum(int[] numbers, int target) {

        if (numbers == null || numbers.length < 2) {
            return new int[0];
        }

        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {

            int sum = numbers[left] + numbers[right];

            if (sum == target) {
                return new int[]{left + 1, right + 1};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return new int[0];
    }

    public static void main(String[] args) {

        TwoSumII solution = new TwoSumII();

        int[] nums = {2, 4, 7, 11, 15};
        int target = 9;

        System.out.println(Arrays.toString(solution.twoSum(nums, target)));
    }
}