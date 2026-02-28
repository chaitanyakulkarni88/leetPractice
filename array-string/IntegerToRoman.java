/*
 * LeetCode Problem: #12 - Integer to Roman
 *
 * Time Complexity: O(1)
 *   (Maximum Roman length is bounded; loop runs fixed 13 times)
 *
 * Space Complexity: O(1)
 *
 * Core Idea:
 * 1. Store Roman numeral values including subtractive cases.
 * 2. Iterate through values from largest to smallest.
 * 3. While num >= value, append symbol and subtract value.
 * 4. Build result using StringBuilder.
 *
 * Pattern: Greedy / Value Mapping
 */

public class IntegerToRoman {

    private static final int[] VALUES = {
            1000, 900, 500, 400,
            100, 90, 50, 40,
            10, 9, 5, 4, 1
    };

    private static final String[] SYMBOLS = {
            "M", "CM", "D", "CD",
            "C", "XC", "L", "XL",
            "X", "IX", "V", "IV", "I"
    };

    public String intToRoman(int num) {

        if (num <= 0) {
            return "";
        }

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < VALUES.length; i++) {
            while (num >= VALUES[i]) {
                result.append(SYMBOLS[i]);
                num -= VALUES[i];
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {

        IntegerToRoman solution = new IntegerToRoman();

        System.out.println(solution.intToRoman(3));     // III
        System.out.println(solution.intToRoman(58));    // LVIII
        System.out.println(solution.intToRoman(1994));  // MCMXCIV
        System.out.println(solution.intToRoman(3749));  // MMMDCCXLIX
    }
}