import java.util.*;

public class GenerateParentheses {

    /*
     * LeetCode Problem: 22 - Generate Parentheses
     *
     * Time Complexity  : O(4^n / √n)  (Catalan number growth)
     * Space Complexity : O(n)         (recursion depth)
     *
     * Core Idea:
     * 1. Use backtracking to build valid parentheses strings.
     * 2. Add '(' if openCount < n.
     * 3. Add ')' only if closeCount < openCount.
     * 4. Add to result when length reaches 2 * n.
     *
     * Algorithm Pattern: Backtracking
     */

    public static List<String> generateParenthesis(int n) {

        if (n <= 0) {
            return Collections.emptyList();
        }

        List<String> result = new ArrayList<>();
        StringBuilder current = new StringBuilder();

        backtrack(n, 0, 0, current, result);

        return result;
    }

    private static void backtrack(int n,
                                  int openCount,
                                  int closeCount,
                                  StringBuilder current,
                                  List<String> result) {

        if (current.length() == 2 * n) {
            result.add(current.toString());
            return;
        }

        if (openCount < n) {
            current.append('(');
            backtrack(n, openCount + 1, closeCount, current, result);
            current.deleteCharAt(current.length() - 1);
        }

        if (closeCount < openCount) {
            current.append(')');
            backtrack(n, openCount, closeCount + 1, current, result);
            current.deleteCharAt(current.length() - 1);
        }
    }

    public static void main(String[] args) {

        int n = 3;

        List<String> combinations = generateParenthesis(n);

        System.out.println("n = " + n);
        System.out.println("Valid Parentheses:");
        System.out.println(combinations);
    }
}