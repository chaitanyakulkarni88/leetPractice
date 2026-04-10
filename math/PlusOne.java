import java.util.*;

public class PlusOne {

    /*
     * LeetCode Problem: 66 - Plus One
     *
     * Time Complexity  : O(n)
     * Space Complexity : O(1) (excluding output array if expanded)
     *
     * Core Idea:
     * 1. Traverse digits from right to left.
     * 2. If digit < 9 → increment and return.
     * 3. If digit == 9 → set to 0 and carry continues.
     * 4. If all digits were 9 → create new array with leading 1.
     *
     * Algorithm Pattern: Simulation
     */

    public static int[] plusOne(int[] digits) {

        if (digits == null || digits.length == 0) {
            throw new IllegalArgumentException("Input array must not be null or empty.");
        }

        for (int i = digits.length - 1; i >= 0; i--) {

            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }

            digits[i] = 0;
        }

        int[] result = new int[digits.length + 1];
        result[0] = 1;

        return result;
    }

    public static void main(String[] args) {

        int[] digits1 = {1, 2, 3};
        int[] digits2 = {4, 3, 2, 1};
        int[] digits3 = {8, 9};
        int[] digits4 = {9, 9, 9};

        System.out.println("Input 1: " + Arrays.toString(digits1));
        System.out.println("Output  : " + Arrays.toString(plusOne(digits1)));

        System.out.println("\nInput 2: " + Arrays.toString(digits2));
        System.out.println("Output  : " + Arrays.toString(plusOne(digits2)));

        System.out.println("\nInput 3: " + Arrays.toString(digits3));
        System.out.println("Output  : " + Arrays.toString(plusOne(digits3)));

        System.out.println("\nInput 4: " + Arrays.toString(digits4));
        System.out.println("Output  : " + Arrays.toString(plusOne(digits4)));
    }
}