/**
 * LeetCode Problem: 452. Minimum Number of Arrows to Burst Balloons
 *
 * Time Complexity: O(n log n)
 * Space Complexity: O(1)
 *
 * Core Idea:
 * 1. Sort balloons by their end coordinate.
 * 2. Shoot first arrow at the end of first balloon.
 * 3. If next balloon starts after current arrow position,
 *    shoot a new arrow.
 */
import java.util.Arrays;
import java.util.Comparator;

public class MinimumNumberArrowsBurstBalloons {

    public static void main(String[] args) {
        MinimumNumberArrowsBurstBalloons solution =
                new MinimumNumberArrowsBurstBalloons();

        int[][] points = {
                {10, 16}, {2, 8}, {1, 6}, {7, 12}
        };

        System.out.println(solution.findMinArrowShots(points));
    }

    public int findMinArrowShots(int[][] points) {
        validateInput(points);

        if (points.length == 0) {
            return 0;
        }

        Arrays.sort(points, Comparator.comparingInt(a -> a[1]));

        int arrows = 1;
        int arrowPosition = points[0][1];

        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > arrowPosition) {
                arrows++;
                arrowPosition = points[i][1];
            }
        }

        return arrows;
    }

    private void validateInput(int[][] points) {
        if (points == null) {
            throw new IllegalArgumentException("Points must not be null.");
        }
    }
}