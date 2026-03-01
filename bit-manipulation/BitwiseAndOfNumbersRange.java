import java.util.*;

public class BitwiseAndOfNumbersRange {

    /*
     * LeetCode Problem: 201 - Bitwise AND of Numbers Range
     *
     * Time Complexity  : O(1)  (at most 32 iterations)
     * Space Complexity : O(1)
     *
     * Core Idea:
     * 1. Find common left prefix of left and right.
     * 2. Right-shift both numbers until they become equal.
     * 3. Count number of shifts.
     * 4. Left-shift back to restore common prefix.
     *
     * Algorithm Pattern: Bit Manipulation
     */

    public static int rangeBitwiseAnd(int left, int right) {

        int shiftCount = 0;

        while (left < right) {
            left >>= 1;
            right >>= 1;
            shiftCount++;
        }

        return left << shiftCount;
    }

    public static void main(String[] args) {

        int left1 = 5, right1 = 7;     // 101,110,111 → 100
        int left2 = 0, right2 = 0;
        int left3 = 1, right3 = 2147483647;

        System.out.println("Range [5,7] → " +
                rangeBitwiseAnd(left1, right1));

        System.out.println("Range [0,0] → " +
                rangeBitwiseAnd(left2, right2));

        System.out.println("Range [1,2147483647] → " +
                rangeBitwiseAnd(left3, right3));
    }
}