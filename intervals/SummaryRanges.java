/**
 * LeetCode Problem: 228. Summary Ranges
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1) (excluding output list)
 *
 * Core Idea:
 * 1. Iterate through the sorted array.
 * 2. Track the start of a range.
 * 3. Expand while numbers are consecutive.
 * 4. Add either a single number or range to result.
 */
import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {

    public static void main(String[] args) {
        SummaryRanges solution = new SummaryRanges();

        int[] nums = {0, 2, 3, 4, 6, 8, 9};

        System.out.println(solution.summaryRanges(nums));
    }

    public List<String> summaryRanges(int[] nums) {
        validateInput(nums);

        List<String> result = new ArrayList<>();

        if (nums.length == 0) {
            return result;
        }

        int start = nums[0];

        for (int i = 1; i <= nums.length; i++) {

            if (i == nums.length || nums[i] != nums[i - 1] + 1) {

                if (start == nums[i - 1]) {
                    result.add(String.valueOf(start));
                } else {
                    result.add(start + "->" + nums[i - 1]);
                }

                if (i < nums.length) {
                    start = nums[i];
                }
            }
        }

        return result;
    }

    private void validateInput(int[] nums) {
        if (nums == null) {
            throw new IllegalArgumentException("Input array must not be null.");
        }
    }
}