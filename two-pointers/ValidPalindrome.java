/*
 * LeetCode Problem: #125 - Valid Palindrome
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 * Core Idea:
 * 1. Use two pointers (left and right).
 * 2. Skip non-alphanumeric characters.
 * 3. Compare lowercase characters.
 * 4. If mismatch, return false.
 * 5. If pointers meet, return true.
 *
 * Pattern: Two Pointers / Character Filtering
 */

public class ValidPalindrome {

    public static boolean isPalindrome(String s) {

        if (s == null) {
            return false;
        }

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {

            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }

            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            if (Character.toLowerCase(s.charAt(left)) !=
                    Character.toLowerCase(s.charAt(right))) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {

        System.out.println(isPalindrome("A man, a plan, a canal: Panama")); // true
        System.out.println(isPalindrome("race a car"));                     // false
        System.out.println(isPalindrome(" "));                              // true
    }
}