/**
 * LeetCode Problem: 57. Insert Interval
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 *
 * Core Idea:
 * 1. Add all intervals that end before newInterval starts.
 * 2. Merge overlapping intervals with newInterval.
 * 3. Add remaining intervals.
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {

    public static void main(String[] args) {
        InsertInterval solution = new InsertInterval();

        int[][] intervals = {{1, 5}};
        int[] newInterval = {6, 8};

        int[][] result = solution.insert(intervals, newInterval);

        for (int[] interval : result) {
            System.out.println(Arrays.toString(interval));
        }
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        validateInput(intervals, newInterval);

        List<int[]> result = new ArrayList<>();
        int i = 0;
        int n = intervals.length;

        while (i < n && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }

        int start = newInterval[0];
        int end = newInterval[1];

        while (i < n && intervals[i][0] <= end) {
            start = Math.min(start, intervals[i][0]);
            end = Math.max(end, intervals[i][1]);
            i++;
        }

        result.add(new int[]{start, end});

        while (i < n) {
            result.add(intervals[i]);
            i++;
        }

        return result.toArray(new int[result.size()][]);
    }

    private void validateInput(int[][] intervals, int[] newInterval) {
        if (intervals == null || newInterval == null) {
            throw new IllegalArgumentException("Input must not be null.");
        }
    }
}