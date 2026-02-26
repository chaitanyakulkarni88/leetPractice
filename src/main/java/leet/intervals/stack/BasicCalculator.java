package leet.intervals.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class BasicCalculator {
    public int calculate(String s) {
        Deque<Integer> stack = new ArrayDeque<>();

        int currentSign = 1;

        int result = 0;

        int length = s.length();

        for (int i = 0; i < length; i++) {
            char currentChar = s.charAt(i);

            if (Character.isDigit(currentChar)) {
                int startIndex = i;
                int number = 0;

                while (startIndex < length && Character.isDigit(s.charAt(startIndex))) {
                    number = number * 10 + (s.charAt(startIndex) - '0');
                    startIndex++;
                }

                result += currentSign * number;

                i = startIndex - 1;

            } else if (currentChar == '+') {
                currentSign = 1;

            } else if (currentChar == '-') {
                currentSign = -1;

            } else if (currentChar == '(') {
                stack.push(result);
                stack.push(currentSign);

                result = 0;
                currentSign = 1;

            } else if (currentChar == ')') {
                result = stack.pop() * result + stack.pop();
            }
        }

        return result;
    }

    public static void main(String[] args) {
        BasicCalculator bc = new BasicCalculator();
        int result = bc.calculate("(1+(4+5+2)-3)+(6+8)");
    }
}
