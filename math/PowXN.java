import java.util.*;

public class PowXN {

    /*
     * LeetCode Problem: 50 - Pow(x, n)
     *
     * Time Complexity  : O(log n)
     * Space Complexity : O(1)
     *
     * Core Idea:
     * 1. Use Binary Exponentiation (Exponentiation by Squaring).
     * 2. If n is negative → convert to positive using long.
     * 3. Repeatedly square the base.
     * 4. Multiply result when current bit of exponent is 1.
     *
     * Algorithm Pattern: Divide and Conquer / Fast Power
     */

    public static double myPow(double x, int n) {

        long exponent = n;

        if (exponent < 0) {
            x = 1 / x;
            exponent = -exponent;
        }

        double result = 1.0;

        while (exponent > 0) {

            if ((exponent & 1) == 1) {
                result *= x;
            }

            x *= x;
            exponent >>= 1;
        }

        return result;
    }

    public static void main(String[] args) {

        System.out.println("2^10 = " + myPow(2.0, 10));
        System.out.println("2^-2 = " + myPow(2.0, -2));
        System.out.println("2^0 = " + myPow(2.0, 0));
        System.out.println("(-2)^3 = " + myPow(-2.0, 3));
        System.out.println("2^Integer.MIN_VALUE = " +
                myPow(2.0, Integer.MIN_VALUE));
    }
}