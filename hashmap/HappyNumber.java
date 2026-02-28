/**
 * LeetCode Problem: 202. Happy Number
 *
 * Time Complexity: O(log n)
 * Space Complexity: O(log n)
 *
 * Core Idea:
 * 1. Repeatedly replace number with sum of squares of its digits.
 * 2. If result becomes 1 → happy number.
 * 3. If a value repeats → cycle detected → not happy.
 */
import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

    public static void main(String[] args) {
        HappyNumber solution = new HappyNumber();

        int n = 2;
        System.out.println(solution.isHappy(n));
    }

    public boolean isHappy(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Input must be a positive integer.");
        }

        Set<Integer> seen = new HashSet<>();

        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            n = getNext(n);
        }

        return n == 1;
    }

    private int getNext(int n) {
        int sum = 0;

        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }

        return sum;
    }
}