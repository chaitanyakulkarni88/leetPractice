import java.util.*;

public class MaxPointsOnALine {

    /*
     * LeetCode Problem: 149 - Max Points on a Line
     *
     * Time Complexity  : O(n^2)
     * Space Complexity : O(n)
     *
     * Core Idea:
     * 1. Fix one point as anchor.
     * 2. Compute slope with every other point.
     * 3. Normalize slope using GCD (dy/gcd, dx/gcd).
     * 4. Count frequency of each slope.
     * 5. Handle duplicates separately.
     *
     * Algorithm Pattern: Hashing + Mathematical Normalization
     */

    public static int maxPoints(int[][] points) {

        if (points == null || points.length == 0) {
            return 0;
        }

        if (points.length <= 2) {
            return points.length;
        }

        int maxPoints = 0;

        for (int i = 0; i < points.length; i++) {

            Map<String, Integer> slopeCount = new HashMap<>();
            int duplicates = 1;
            int localMax = 0;

            for (int j = i + 1; j < points.length; j++) {

                int dx = points[j][0] - points[i][0];
                int dy = points[j][1] - points[i][1];

                if (dx == 0 && dy == 0) {
                    duplicates++;
                    continue;
                }

                int gcd = gcd(dx, dy);
                dx /= gcd;
                dy /= gcd;

                String slope = dy + "/" + dx;

                slopeCount.put(slope, slopeCount.getOrDefault(slope, 0) + 1);
                localMax = Math.max(localMax, slopeCount.get(slope));
            }

            maxPoints = Math.max(maxPoints, localMax + duplicates);
        }

        return maxPoints;
    }

    private static int gcd(int a, int b) {
        if (b == 0) {
            return Math.abs(a);
        }
        return gcd(b, a % b);
    }

    public static void main(String[] args) {

        int[][] points1 = {{1,1}, {2,2}, {3,3}};
        int[][] points2 = {{1,1}, {3,2}, {5,3}, {4,1}, {2,3}, {1,4}};
        int[][] points3 = {{0,0}, {0,0}, {0,0}};

        System.out.println("Example 1 → " + maxPoints(points1));
        System.out.println("Example 2 → " + maxPoints(points2));
        System.out.println("Example 3 → " + maxPoints(points3));
    }
}