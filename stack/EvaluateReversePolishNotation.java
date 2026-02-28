/**
 * LeetCode Problem: 150. Evaluate Reverse Polish Notation
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 *
 * Core Idea:
 * 1. Use a stack to store operands.
 * 2. Push numbers onto stack.
 * 3. When operator encountered, pop two operands.
 * 4. Apply operation and push result back.
 */
import java.util.ArrayDeque;
import java.util.Deque;

public class EvaluateReversePolishNotation {

    public static void main(String[] args) {
        EvaluateReversePolishNotation solution =
                new EvaluateReversePolishNotation();

        String[] tokens = {
                "10","6","9","3","+","-11","*","/","*","17","+","5","+"
        };

        int result = solution.evalRPN(tokens);
        System.out.println(result);
    }

    public int evalRPN(String[] tokens) {
        validateInput(tokens);

        Deque<Integer> stack = new ArrayDeque<>();

        for (String token : tokens) {

            if (isOperator(token)) {

                if (stack.size() < 2) {
                    throw new IllegalArgumentException("Invalid RPN expression.");
                }

                int second = stack.pop();
                int first = stack.pop();

                stack.push(applyOperation(first, second, token));

            } else {
                stack.push(Integer.parseInt(token));
            }
        }

        if (stack.size() != 1) {
            throw new IllegalArgumentException("Invalid RPN expression.");
        }

        return stack.pop();
    }

    private boolean isOperator(String token) {
        return token.equals("+") ||
                token.equals("-") ||
                token.equals("*") ||
                token.equals("/");
    }

    private int applyOperation(int a, int b, String operator) {
        switch (operator) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/": return a / b; // Java truncates toward zero
            default:
                throw new IllegalArgumentException("Unknown operator: " + operator);
        }
    }

    private void validateInput(String[] tokens) {
        if (tokens == null || tokens.length == 0) {
            throw new IllegalArgumentException("Tokens must not be null or empty.");
        }
    }
}