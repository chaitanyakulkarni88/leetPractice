import java.util.*;

public class LetterCombinations {

    /*
     * LeetCode Problem: 17 - Letter Combinations of a Phone Number
     *
     * Time Complexity  : O(4^n)
     * Space Complexity : O(n)
     *
     * Core Idea:
     * 1. Use backtracking to generate combinations one digit at a time.
     * 2. For each digit, iterate over its mapped characters.
     * 3. Append character → recurse → remove character (backtrack).
     *
     * Algorithm Pattern: Backtracking
     */

    private static final Map<Character, String> DIGIT_TO_LETTERS = Map.of(
            '2', "abc",
            '3', "def",
            '4', "ghi",
            '5', "jkl",
            '6', "mno",
            '7', "pqrs",
            '8', "tuv",
            '9', "wxyz"
    );

    public static List<String> letterCombinations(String digits) {

        if (digits == null || digits.isEmpty()) {
            return Collections.emptyList();
        }

        List<String> combinations = new ArrayList<>();
        StringBuilder current = new StringBuilder();

        backtrack(digits, 0, current, combinations);

        return combinations;
    }

    private static void backtrack(String digits,
                                  int position,
                                  StringBuilder current,
                                  List<String> combinations) {

        if (position == digits.length()) {
            combinations.add(current.toString());
            return;
        }

        char digit = digits.charAt(position);
        String letters = DIGIT_TO_LETTERS.get(digit);

        if (letters == null) {
            throw new IllegalArgumentException("Invalid digit found: " + digit);
        }

        for (int index = 0; index < letters.length(); index++) {
            current.append(letters.charAt(index));
            backtrack(digits, position + 1, current, combinations);
            current.deleteCharAt(current.length() - 1);
        }
    }

    public static void main(String[] args) {

        String digits = "23";
        List<String> result = letterCombinations(digits);

        System.out.println("Input  : " + digits);
        System.out.println("Output : " + result);
    }
}