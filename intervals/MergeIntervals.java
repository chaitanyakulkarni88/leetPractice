/**
 * LeetCode Problem: 56. Merge Intervals
 *
 * Time Complexity: O(n log n)
 * Space Complexity: O(n)
 *
 * Core Idea:
 * 1. Sort intervals by start time.
 * 2. Initialize first interval as current.
 * 3. If next interval overlaps, merge.
 * 4. Otherwise, add to result and update current.
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {

    public static void main(String[] args) {
        MergeIntervals solution = new MergeIntervals();

        int[][] intervals = {
                {1, 3}, {2, 6}, {8, 10}, {8, 9},
                {9, 11}, {15, 18}, {2, 4}, {16, 17}
        };

        int[][] merged = solution.merge(intervals);

        for (int[] interval : merged) {
            System.out.println(Arrays.toString(interval));
        }
    }

    public int[][] merge(int[][] intervals) {
        validateInput(intervals);

        if (intervals.length <= 1) {
            return intervals;
        }

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        List<int[]> merged = new ArrayList<>();
        int[] current = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            int[] next = intervals[i];

            if (next[0] <= current[1]) {
                current[1] = Math.max(current[1], next[1]);
            } else {
                merged.add(current);
                current = next;
            }
        }

        merged.add(current);

        return merged.toArray(new int[merged.size()][]);
    }

    private void validateInput(int[][] intervals) {
        if (intervals == null) {
            throw new IllegalArgumentException("Intervals must not be null.");
        }
    }
}