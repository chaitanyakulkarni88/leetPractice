/**
 * LeetCode Problem: 224. Basic Calculator
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 *
 * Core Idea:
 * 1. Maintain current result and sign.
 * 2. On '(', push current result and sign onto stack.
 * 3. On ')', combine with previous context.
 * 4. Process digits as multi-digit numbers.
 */
import java.util.ArrayDeque;
import java.util.Deque;

public class BasicCalculator {

    public static void main(String[] args) {
        BasicCalculator solution = new BasicCalculator();

        String expression1 = "2-1+2";

        System.out.println(solution.calculate(expression1));

        String expression2 = "(1+(4+5+2)-3)+(6+8)";

        System.out.println(solution.calculate(expression2));
    }

    public int calculate(String s) {
        validateInput(s);

        Deque<Integer> stack = new ArrayDeque<>();

        int result = 0;
        int sign = 1;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                int number = 0;

                while (i < n && Character.isDigit(s.charAt(i))) {
                    number = number * 10 + (s.charAt(i) - '0');
                    i++;
                }

                result += sign * number;
                i--; // Adjust because loop will increment

            } else if (ch == '+') {
                sign = 1;

            } else if (ch == '-') {
                sign = -1;

            } else if (ch == '(') {
                stack.push(result);
                stack.push(sign);

                result = 0;
                sign = 1;

            } else if (ch == ')') {
                int prevSign = stack.pop();
                int prevResult = stack.pop();

                result = prevResult + prevSign * result;
            }
        }

        return result;
    }

    private void validateInput(String s) {
        if (s == null) {
            throw new IllegalArgumentException("Expression must not be null.");
        }
    }
}