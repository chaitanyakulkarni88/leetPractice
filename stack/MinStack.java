/**
 * LeetCode Problem: 155. Min Stack
 *
 * Time Complexity:
 *   push  -> O(1)
 *   pop   -> O(1)
 *   top   -> O(1)
 *   getMin-> O(1)
 *
 * Space Complexity: O(n)
 *
 * Core Idea:
 * 1. Maintain two stacks:
 *      - main stack for values
 *      - min stack to track current minimum
 * 2. Push to min stack when new value ≤ current min.
 * 3. Pop from main stack and min stack when popped value equals current min.
 */
import java.util.ArrayDeque;
import java.util.Deque;

public class MinStack {

    private Deque<Integer> stack;
    private Deque<Integer> minStack;

    public static void main(String[] args) {
        MinStack minStack = new MinStack();

        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);

        System.out.println(minStack.getMin()); // -3
        minStack.pop();
        System.out.println(minStack.top());    // 0
        System.out.println(minStack.getMin()); // -2
    }

    public MinStack() {
        stack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
    }

    public void push(int value) {
        stack.push(value);

        if (minStack.isEmpty() || value <= minStack.peek()) {
            minStack.push(value);
        }
    }

    public void pop() {
        validateNotEmpty();

        int removed = stack.pop();

        if (removed == minStack.peek()) {
            minStack.pop();
        }
    }

    public int top() {
        validateNotEmpty();
        return stack.peek();
    }

    public int getMin() {
        if (minStack.isEmpty()) {
            throw new IllegalStateException("Stack is empty.");
        }
        return minStack.peek();
    }

    private void validateNotEmpty() {
        if (stack.isEmpty()) {
            throw new IllegalStateException("Stack is empty.");
        }
    }
}