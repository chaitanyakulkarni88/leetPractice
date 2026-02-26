package leet.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinations {

    private static final Map<Character, String> phoneMap = new HashMap<>();

    static {
        phoneMap.put('2', "abc");
        phoneMap.put('3', "def");
        phoneMap.put('4', "ghi");
        phoneMap.put('5', "jkl");
        phoneMap.put('6', "mno");
        phoneMap.put('7', "pqrs");
        phoneMap.put('8', "tuv");
        phoneMap.put('9', "wxyz");
    }

    public static List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<>();

        if (digits == null || digits.length() == 0)
            return result;

        backtrack(digits, 0, new StringBuilder(), result);

        return result;
    }

    private static void backtrack(String digits,
                                  int index,
                                  StringBuilder current,
                                  List<String> result) {

        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        String letters = phoneMap.get(digits.charAt(index));

        for (char c : letters.toCharArray()) {
            current.append(c);
            backtrack(digits, index + 1, current, result);
            current.deleteCharAt(current.length() - 1); // backtrack
        }
    }

    public static void main(String[] args) {

        String digits = "23";

        List<String> combinations = letterCombinations(digits);

        System.out.println("Combinations: " + combinations);
    }
}
