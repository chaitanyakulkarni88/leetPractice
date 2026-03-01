import java.util.*;

public class ClimbingStairs {

    /*
     * LeetCode Problem: 70 - Climbing Stairs
     *
     * Time Complexity  : O(n)
     * Space Complexity : O(1)
     *
     * Core Idea:
     * 1. To reach step i:
     *      ways[i] = ways[i-1] + ways[i-2]
     * 2. This forms Fibonacci sequence.
     * 3. Use two variables instead of full DP array.
     *
     * Algorithm Pattern: Dynamic Programming (Fibonacci)
     */

    public static int climbStairs(int n) {

        if (n <= 0) {
            throw new IllegalArgumentException("Number of steps must be positive.");
        }

        if (n <= 2) {
            return n;
        }

        int oneStepBefore = 2;  // ways to reach step 2
        int twoStepsBefore = 1; // ways to reach step 1

        for (int i = 3; i <= n; i++) {

            int current = oneStepBefore + twoStepsBefore;
            twoStepsBefore = oneStepBefore;
            oneStepBefore = current;
        }

        return oneStepBefore;
    }

    public static void main(String[] args) {

        System.out.println("n = 1 → " + climbStairs(1));
        System.out.println("n = 2 → " + climbStairs(2));
        System.out.println("n = 3 → " + climbStairs(3));
        System.out.println("n = 5 → " + climbStairs(5));
        System.out.println("n = 10 → " + climbStairs(10));
    }
}