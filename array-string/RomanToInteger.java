/*
 * LeetCode Problem: #13 - Roman to Integer
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 * Core Idea:
 * 1. Map each Roman symbol to its integer value.
 * 2. Traverse from right to left.
 * 3. If current value < next value, subtract it.
 * 4. Otherwise, add it.
 * 5. Accumulate result.
 *
 * Pattern: String Traversal / Subtractive Logic
 */

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

    private static final Map<Character, Integer> ROMAN_MAP = new HashMap<>();

    static {
        ROMAN_MAP.put('I', 1);
        ROMAN_MAP.put('V', 5);
        ROMAN_MAP.put('X', 10);
        ROMAN_MAP.put('L', 50);
        ROMAN_MAP.put('C', 100);
        ROMAN_MAP.put('D', 500);
        ROMAN_MAP.put('M', 1000);
    }

    public int romanToInt(String s) {

        if (s == null || s.length() == 0) {
            return 0;
        }

        int total = ROMAN_MAP.get(s.charAt(s.length() - 1));

        for (int i = s.length() - 2; i >= 0; i--) {

            int current = ROMAN_MAP.get(s.charAt(i));
            int next = ROMAN_MAP.get(s.charAt(i + 1));

            if (current < next) {
                total -= current;
            } else {
                total += current;
            }
        }

        return total;
    }

    public static void main(String[] args) {

        RomanToInteger solution = new RomanToInteger();

        System.out.println(solution.romanToInt("III"));       // 3
        System.out.println(solution.romanToInt("LVIII"));     // 58
        System.out.println(solution.romanToInt("MCMXCIV"));   // 1994
    }
}