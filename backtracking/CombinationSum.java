import java.util.*;

public class CombinationSum {

    /*
     * LeetCode Problem: 39 - Combination Sum
     *
     * Time Complexity  : O(2^t)  (t = target, exponential in worst case)
     * Space Complexity : O(t)    (recursion depth)
     *
     * Core Idea:
     * 1. Sort candidates to enable pruning.
     * 2. Use backtracking to explore combinations.
     * 3. If candidate exceeds remaining target, stop further exploration.
     * 4. Reuse same element by passing current index again.
     *
     * Algorithm Pattern: Backtracking
     */

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {

        if (candidates == null || candidates.length == 0 || target <= 0) {
            return Collections.emptyList();
        }

        Arrays.sort(candidates);

        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), result);

        return result;
    }

    private static void backtrack(int[] candidates,
                                  int remainingTarget,
                                  int startIndex,
                                  List<Integer> current,
                                  List<List<Integer>> result) {

        if (remainingTarget == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int index = startIndex; index < candidates.length; index++) {

            int candidate = candidates[index];

            if (candidate > remainingTarget) {
                break; // pruning due to sorted array
            }

            current.add(candidate);

            backtrack(candidates,
                    remainingTarget - candidate,
                    index,  // reuse allowed
                    current,
                    result);

            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {

        int[] candidates = {2, 3, 6, 7};
        int target = 7;

        List<List<Integer>> combinations = combinationSum(candidates, target);

        System.out.println("Candidates: " + Arrays.toString(candidates));
        System.out.println("Target    : " + target);
        System.out.println("Output    : " + combinations);
    }
}