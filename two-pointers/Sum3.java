/*
 * LeetCode Problem: #15 - 3Sum
 *
 * Time Complexity: O(n^2)
 * Space Complexity: O(1) (excluding output list)
 *
 * Core Idea:
 * 1. Sort the array.
 * 2. Fix one element (i).
 * 3. Use two pointers (left, right) to find pairs summing to -nums[i].
 * 4. Skip duplicate values for i, left, and right.
 * 5. Collect unique triplets.
 *
 * Pattern: Sorting + Two Pointers
 */

import java.util.*;

public class Sum3 {

    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        if (nums == null || nums.length < 3) {
            return result;
        }

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {

            // Skip duplicate anchors
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {

                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {

                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Skip duplicates for left
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }

                    // Skip duplicates for right
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    left++;
                    right--;

                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {

        Sum3 solution = new Sum3();

        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(solution.threeSum(nums));
    }
}