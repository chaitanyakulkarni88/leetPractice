import java.util.*;

public class SingleNumber {

    /*
     * LeetCode Problem: 136 - Single Number
     *
     * Time Complexity  : O(n)
     * Space Complexity : O(1)
     *
     * Core Idea:
     * 1. Use XOR operation.
     * 2. a ^ a = 0
     * 3. a ^ 0 = a
     * 4. XOR all elements → duplicates cancel out.
     *
     * Algorithm Pattern: Bit Manipulation
     */

    public static int singleNumber(int[] nums) {

        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Input array must not be null or empty.");
        }

        int result = 0;

        for (int num : nums) {
            result ^= num;
        }

        return result;
    }

    public static void main(String[] args) {

        int[] nums1 = {2, 2, 1};
        int[] nums2 = {4, 1, 2, 1, 2};
        int[] nums3 = {1};

        System.out.println("Array 1: " + Arrays.toString(nums1));
        System.out.println("Single Number: " + singleNumber(nums1));

        System.out.println("\nArray 2: " + Arrays.toString(nums2));
        System.out.println("Single Number: " + singleNumber(nums2));

        System.out.println("\nArray 3: " + Arrays.toString(nums3));
        System.out.println("Single Number: " + singleNumber(nums3));
    }
}