package leet.backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(n, 0, 0, new StringBuilder(), result);
        return result;
    }

    private static void backtrack(int n,
                                  int open,
                                  int close,
                                  StringBuilder current,
                                  List<String> result) {

        if (current.length() == 2 * n) {
            result.add(current.toString());
            return;
        }

        // Add '(' if we still can
        if (open < n) {
            current.append('(');
            backtrack(n, open + 1, close, current, result);
            current.deleteCharAt(current.length() - 1);
        }

        // Add ')' if valid
        if (close < open) {
            current.append(')');
            backtrack(n, open, close + 1, current, result);
            current.deleteCharAt(current.length() - 1);
        }
    }

    public static void main(String[] args) {

        int n = 3;

        List<String> combinations = generateParenthesis(n);

        System.out.println("Valid Parentheses:");
        System.out.println(combinations);
    }
}
