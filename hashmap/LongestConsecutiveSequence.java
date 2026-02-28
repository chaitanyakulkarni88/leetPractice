/**
 * LeetCode Problem: 128. Longest Consecutive Sequence
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 *
 * Core Idea:
 * 1. Insert all numbers into a HashSet.
 * 2. Only start counting when (num - 1) is NOT present.
 * 3. Expand forward while consecutive numbers exist.
 * 4. Track maximum sequence length.
 */
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    public static void main(String[] args) {
        LongestConsecutiveSequence solution = new LongestConsecutiveSequence();

        int[] nums = {100, 4, 200, 1, 3, 2};

        System.out.println(solution.longestConsecutive(nums));
    }

    public int longestConsecutive(int[] nums) {
        validateInput(nums);

        if (nums.length == 0) {
            return 0;
        }

        Set<Integer> numberSet = new HashSet<>();

        for (int num : nums) {
            numberSet.add(num);
        }

        int longest = 0;

        for (int num : numberSet) {

            if (!numberSet.contains(num - 1)) {

                int current = num;
                int streak = 1;

                while (numberSet.contains(current + 1)) {
                    current++;
                    streak++;
                }

                longest = Math.max(longest, streak);
            }
        }

        return longest;
    }

    private void validateInput(int[] nums) {
        if (nums == null) {
            throw new IllegalArgumentException("Input array must not be null.");
        }
    }
}