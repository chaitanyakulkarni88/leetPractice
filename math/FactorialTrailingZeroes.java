import java.util.*;

public class FactorialTrailingZeroes {

    /*
     * LeetCode Problem: 172 - Factorial Trailing Zeroes
     *
     * Time Complexity  : O(log n)
     * Space Complexity : O(1)
     *
     * Core Idea:
     * 1. Trailing zeros are produced by factors of 10.
     * 2. 10 = 2 × 5.
     * 3. In n!, there are more 2s than 5s.
     * 4. Count number of factors of 5.
     * 5. Add n/5 + n/25 + n/125 + ...
     *
     * Algorithm Pattern: Mathematical Observation
     */

    public static int trailingZeroes(int n) {

        if (n < 0) {
            throw new IllegalArgumentException("Input must be non-negative.");
        }

        int count = 0;

        while (n > 0) {
            n /= 5;
            count += n;
        }

        return count;
    }

    public static void main(String[] args) {

        int n1 = 3;
        int n2 = 5;
        int n3 = 25;
        int n4 = 100;

        System.out.println("Trailing zeroes of 3!   → " + trailingZeroes(n1));
        System.out.println("Trailing zeroes of 5!   → " + trailingZeroes(n2));
        System.out.println("Trailing zeroes of 25!  → " + trailingZeroes(n3));
        System.out.println("Trailing zeroes of 100! → " + trailingZeroes(n4));
    }
}