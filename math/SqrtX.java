import java.util.*;

public class SqrtX {

    /*
     * LeetCode Problem: 69 - Sqrt(x)
     *
     * Time Complexity  : O(log n)
     * Space Complexity : O(1)
     *
     * Core Idea:
     * 1. Use binary search between 1 and x.
     * 2. Avoid overflow by comparing mid <= x / mid.
     * 3. Track the floor value of square root.
     * 4. Return the largest mid such that mid * mid <= x.
     *
     * Algorithm Pattern: Binary Search
     */

    public static int mySqrt(int x) {

        if (x < 0) {
            throw new IllegalArgumentException("Input must be non-negative.");
        }

        if (x == 0 || x == 1) {
            return x;
        }

        int left = 1;
        int right = x;
        int result = 0;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (mid <= x / mid) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {

        int[] testCases = {0, 1, 4, 8, 16, 2147395599};

        for (int x : testCases) {
            System.out.println("Sqrt(" + x + ") = " + mySqrt(x));
        }
    }
}