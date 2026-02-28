/**
 * LeetCode Problem: 1. Two Sum
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 *
 * Core Idea:
 * 1. Iterate through array once.
 * 2. For each number, compute complement = target - current.
 * 3. If complement exists in map, return indices.
 * 4. Otherwise, store current number with its index.
 */
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        TwoSum solution = new TwoSum();

        int[] nums = {2, 7, 11, 1};
        int target = 9;

        int[] result = solution.twoSum(nums, target);
        System.out.println(Arrays.toString(result));
    }

    public int[] twoSum(int[] nums, int target) {
        validateInput(nums);

        Map<Integer, Integer> indexMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (indexMap.containsKey(complement)) {
                return new int[]{indexMap.get(complement), i};
            }

            indexMap.put(nums[i], i);
        }

        throw new IllegalArgumentException("No two sum solution exists.");
    }

    private void validateInput(int[] nums) {
        if (nums == null || nums.length < 2) {
            throw new IllegalArgumentException("Input array must contain at least two elements.");
        }
    }
}