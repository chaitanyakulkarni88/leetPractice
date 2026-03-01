import java.util.*;

public class Permutations {

    /*
     * LeetCode Problem: 46 - Permutations
     *
     * Time Complexity  : O(n! * n)
     * Space Complexity : O(n) (excluding output)
     *
     * Core Idea:
     * 1. Use backtracking to build permutations incrementally.
     * 2. Track used elements with a boolean array.
     * 3. Add permutation when its size equals input length.
     * 4. Backtrack by unmarking and removing last element.
     *
     * Algorithm Pattern: Backtracking
     */

    public static List<List<Integer>> permute(int[] nums) {

        if (nums == null || nums.length == 0) {
            return Collections.emptyList();
        }

        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];

        backtrack(nums, used, new ArrayList<>(), result);

        return result;
    }

    private static void backtrack(int[] nums,
                                  boolean[] used,
                                  List<Integer> current,
                                  List<List<Integer>> result) {

        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int index = 0; index < nums.length; index++) {

            if (used[index]) {
                continue;
            }

            used[index] = true;
            current.add(nums[index]);

            backtrack(nums, used, current, result);

            current.remove(current.size() - 1);
            used[index] = false;
        }
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3};

        List<List<Integer>> permutations = permute(nums);

        System.out.println("Input  : " + Arrays.toString(nums));
        System.out.println("Output : " + permutations);
    }
}