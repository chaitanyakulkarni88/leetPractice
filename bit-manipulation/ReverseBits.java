import java.util.*;

public class ReverseBits {

    /*
     * LeetCode Problem: 190 - Reverse Bits
     *
     * Time Complexity  : O(1)  (always 32 iterations)
     * Space Complexity : O(1)
     *
     * Core Idea:
     * 1. Iterate 32 times (for 32-bit integer).
     * 2. Extract least significant bit using (n & 1).
     * 3. Shift result left and add extracted bit.
     * 4. Unsigned right shift input (n >>> 1).
     *
     * Algorithm Pattern: Bit Manipulation
     */

    public static int reverseBits(int n) {

        int reversed = 0;

        for (int i = 0; i < 32; i++) {

            reversed <<= 1;
            reversed |= (n & 1);
            n >>>= 1;   // unsigned shift
        }

        return reversed;
    }

    private static String toBinary(int n) {
        return String.format("%32s",
                        Integer.toBinaryString(n))
                .replace(' ', '0');
    }

    public static void main(String[] args) {

        int input = 43261596;   // 00000010100101000001111010011100
        int result = reverseBits(input);

        System.out.println("Input  (bin): " + toBinary(input));
        System.out.println("Output (bin): " + toBinary(result));
        System.out.println("Output (dec): " + result);
    }
}