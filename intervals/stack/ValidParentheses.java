/**
 * LeetCode Problem: 20. Valid Parentheses
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 *
 * Core Idea:
 * 1. Use a stack to track expected closing brackets.
 * 2. Push expected closing bracket for every opening bracket.
 * 3. If mismatch or stack empty on closing bracket → invalid.
 * 4. Valid if stack is empty at the end.
 */
import java.util.ArrayDeque;
import java.util.Deque;

public class ValidParentheses {

    public static void main(String[] args) {
        ValidParentheses solution = new ValidParentheses();

        String s = "()";
        System.out.println(solution.isValid(s));
    }

    public boolean isValid(String s) {
        validateInput(s);

        if (s.length() % 2 != 0) {
            return false;
        }

        Deque<Character> stack = new ArrayDeque<>();

        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                stack.push(')');
            } else if (ch == '{') {
                stack.push('}');
            } else if (ch == '[') {
                stack.push(']');
            } else {
                if (stack.isEmpty() || stack.pop() != ch) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    private void validateInput(String s) {
        if (s == null) {
            throw new IllegalArgumentException("Input string must not be null.");
        }
    }
}