import java.util.*;

public class Combinations {

    /*
     * LeetCode Problem: 77 - Combinations
     *
     * Time Complexity  : O(C(n, k) * k)
     * Space Complexity : O(k) (excluding output)
     *
     * Core Idea:
     * 1. Use backtracking to build combinations incrementally.
     * 2. Start from a given number and explore increasing sequences.
     * 3. Add combination when size reaches k.
     * 4. Prune search when remaining numbers are insufficient.
     *
     * Algorithm Pattern: Backtracking
     */

    public static List<List<Integer>> combine(int n, int k) {

        if (n <= 0 || k <= 0 || k > n) {
            return Collections.emptyList();
        }

        List<List<Integer>> result = new ArrayList<>();
        backtrack(n, k, 1, new ArrayList<>(), result);

        return result;
    }

    private static void backtrack(int n,
                                  int k,
                                  int start,
                                  List<Integer> current,
                                  List<List<Integer>> result) {

        if (current.size() == k) {
            result.add(new ArrayList<>(current));
            return;
        }

        /*
         * Optimization (Pruning):
         * If we need (k - current.size()) more elements,
         * ensure enough numbers remain to fill the combination.
         */
        int remainingNeeded = k - current.size();

        for (int number = start;
             number <= n - remainingNeeded + 1;
             number++) {

            current.add(number);
            backtrack(n, k, number + 1, current, result);
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {

        int n = 4;
        int k = 2;

        List<List<Integer>> combinations = combine(n, k);

        System.out.println("n = " + n + ", k = " + k);
        System.out.println("Combinations:");
        System.out.println(combinations);
    }
}