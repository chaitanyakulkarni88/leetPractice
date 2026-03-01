import java.util.*;

public class SingleNumberII {

    /*
     * LeetCode Problem: 137 - Single Number II
     *
     * Time Complexity  : O(n)
     * Space Complexity : O(1)
     *
     * Core Idea:
     * 1. Each number appears three times except one.
     * 2. Use two bitmasks (ones, twos) to track bit frequency mod 3.
     * 3. Update states using bitwise operations.
     * 4. 'ones' will contain the final unique number.
     *
     * Algorithm Pattern: Bit Manipulation (Finite State Machine)
     */

    public static int singleNumber(int[] nums) {

        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Input array must not be null or empty.");
        }

        int ones = 0;
        int twos = 0;

        for (int num : nums) {

            ones = (ones ^ num) & ~twos;
            twos = (twos ^ num) & ~ones;
        }

        return ones;
    }

    public static void main(String[] args) {

        int[] nums1 = {2, 2, 3, 2};
        int[] nums2 = {0, 1, 0, 1, 0, 1, 99};
        int[] nums3 = {-2, -2, -2, -5};

        System.out.println("Array 1: " + Arrays.toString(nums1));
        System.out.println("Single Number: " + singleNumber(nums1));

        System.out.println("\nArray 2: " + Arrays.toString(nums2));
        System.out.println("Single Number: " + singleNumber(nums2));

        System.out.println("\nArray 3: " + Arrays.toString(nums3));
        System.out.println("Single Number: " + singleNumber(nums3));
    }
}