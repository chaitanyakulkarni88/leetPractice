import java.util.*;

public class PalindromeNumber {

    /*
     * LeetCode Problem: 9 - Palindrome Number
     *
     * Time Complexity  : O(log10(n))
     * Space Complexity : O(1)
     *
     * Core Idea:
     * 1. Negative numbers are not palindromes.
     * 2. Reverse only half of the number.
     * 3. Stop when reversedHalf >= remainingHalf.
     * 4. Compare halves (handle odd digit case).
     *
     * Algorithm Pattern: Mathematical Manipulation
     */

    public static boolean isPalindrome(int x) {

        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int reversedHalf = 0;

        while (x > reversedHalf) {
            reversedHalf = reversedHalf * 10 + x % 10;
            x /= 10;
        }

        return x == reversedHalf || x == reversedHalf / 10;
    }

    public static void main(String[] args) {

        int n1 = 121;
        int n2 = -121;
        int n3 = 10;
        int n4 = 12321;

        System.out.println(n1 + " → " + isPalindrome(n1));
        System.out.println(n2 + " → " + isPalindrome(n2));
        System.out.println(n3 + " → " + isPalindrome(n3));
        System.out.println(n4 + " → " + isPalindrome(n4));
    }
}