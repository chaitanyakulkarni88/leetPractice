import java.util.*;

public class MaxPointsOnALine {

    /*
     * LeetCode Problem: 149 - Max Points on a Line
     *
     * Time Complexity  : O(n^2)
     * Space Complexity : O(n)
     *
     * Problem:
     * Find the maximum number of points that lie on the same straight line.
     *
     * Key Idea:
     * Fix one point as an anchor and compute slopes with all other points.
     * Points with the same slope lie on the same line.
     *
     * Approaches:
     * 1. Simple Double Slope (easier but floating precision risk)
     * 2. GCD Normalized Slope (correct mathematical solution)
     *
     * Algorithm Pattern:
     * HashMap + Geometry
     */

    /* -----------------------------------------------------
       Approach 1: Simple Double Slope (Easier)
       ----------------------------------------------------- */

    public static int maxPointsSimple(int[][] points) {

        if (points.length <= 2) {
            return points.length;
        }

        int result = 0;

        for (int i = 0; i < points.length; i++) {

            Map<Double, Integer> slopeMap = new HashMap<>();
            int vertical = 0;
            int duplicates = 1;
            int localMax = 0;

            for (int j = i + 1; j < points.length; j++) {

                int x1 = points[i][0];
                int y1 = points[i][1];
                int x2 = points[j][0];
                int y2 = points[j][1];

                if (x1 == x2 && y1 == y2) {
                    duplicates++;
                }
                else if (x1 == x2) {
                    vertical++;
                    localMax = Math.max(localMax, vertical);
                }
                else {

                    double slope = (double)(y2 - y1) / (x2 - x1);

                    slopeMap.put(slope, slopeMap.getOrDefault(slope, 0) + 1);

                    localMax = Math.max(localMax, slopeMap.get(slope));
                }
            }

            result = Math.max(result, localMax + duplicates);
        }

        return result;
    }

    /* -----------------------------------------------------
       Approach 2: GCD Normalized Slope (More Accurate)
       ----------------------------------------------------- */

    public static int maxPointsGCD(int[][] points) {

        if (points.length <= 2) {
            return points.length;
        }

        int result = 0;

        for (int i = 0; i < points.length; i++) {

            Map<String, Integer> slopeMap = new HashMap<>();
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

                slopeMap.put(slope, slopeMap.getOrDefault(slope, 0) + 1);

                localMax = Math.max(localMax, slopeMap.get(slope));
            }

            result = Math.max(result, localMax + duplicates);
        }

        return result;
    }

    /* -----------------------------------------------------
       Utility: GCD Function
       ----------------------------------------------------- */

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

        System.out.println("Using Simple Double Slope:");
        System.out.println("Example 1 → " + maxPointsSimple(points1));
        System.out.println("Example 2 → " + maxPointsSimple(points2));
        System.out.println("Example 3 → " + maxPointsSimple(points3));

        System.out.println();

        System.out.println("Using GCD Normalized Slope:");
        System.out.println("Example 1 → " + maxPointsGCD(points1));
        System.out.println("Example 2 → " + maxPointsGCD(points2));
        System.out.println("Example 3 → " + maxPointsGCD(points3));
    }
}