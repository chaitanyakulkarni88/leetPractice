import java.util.*;

public class NumberOfOneBits {

    /*
     * LeetCode Problem: 191 - Number of 1 Bits
     *
     * Time Complexity  : O(k)
     * Space Complexity : O(1)
     *
     * k = number of set bits
     *
     * Core Idea:
     * 1. Use Brian Kernighan’s algorithm.
     * 2. Repeatedly remove the lowest set bit using:
     *        n = n & (n - 1)
     * 3. Count how many times we can do this.
     *
     * Algorithm Pattern: Bit Manipulation
     */

    public static int hammingWeight(int n) {

        int count = 0;

        while (n != 0) {
            n &= (n - 1);
            count++;
        }

        return count;
    }

    private static String toBinary(int n) {
        return String.format("%32s",
                        Integer.toBinaryString(n))
                .replace(' ', '0');
    }

    public static void main(String[] args) {

        int n1 = 11;     // 00000000000000000000000000001011
        int n2 = 128;    // 00000000000000000000000010000000
        int n3 = -3;     // 11111111111111111111111111111101

        System.out.println("Input 1: " + toBinary(n1));
        System.out.println("Set Bits: " + hammingWeight(n1));

        System.out.println("\nInput 2: " + toBinary(n2));
        System.out.println("Set Bits: " + hammingWeight(n2));

        System.out.println("\nInput 3: " + toBinary(n3));
        System.out.println("Set Bits: " + hammingWeight(n3));
    }
}