import java.util.*;

public class AddBinary {

    /*
     * LeetCode Problem: 67 - Add Binary
     *
     * Time Complexity  : O(max(m, n))
     * Space Complexity : O(max(m, n))
     *
     * Core Idea:
     * 1. Traverse both strings from right to left.
     * 2. Add corresponding bits along with carry.
     * 3. Append result bit (sum % 2).
     * 4. Update carry (sum / 2).
     * 5. Reverse final result.
     *
     * Algorithm Pattern: Two Pointers / Simulation
     */

    public static String addBinary(String a, String b) {

        if (a == null || b == null) {
            throw new IllegalArgumentException("Input strings must not be null.");
        }

        int pointerA = a.length() - 1;
        int pointerB = b.length() - 1;
        int carry = 0;

        StringBuilder result = new StringBuilder();

        while (pointerA >= 0 || pointerB >= 0 || carry != 0) {

            int sum = carry;

            if (pointerA >= 0) {
                sum += a.charAt(pointerA--) - '0';
            }

            if (pointerB >= 0) {
                sum += b.charAt(pointerB--) - '0';
            }

            result.append(sum % 2);
            carry = sum / 2;
        }

        return result.reverse().toString();
    }

    public static void main(String[] args) {

        String a1 = "11";
        String b1 = "1";

        String a2 = "1010";
        String b2 = "1011";

        String a3 = "0";
        String b3 = "0";

        System.out.println(a1 + " + " + b1 + " = " + addBinary(a1, b1));
        System.out.println(a2 + " + " + b2 + " = " + addBinary(a2, b2));
        System.out.println(a3 + " + " + b3 + " = " + addBinary(a3, b3));
    }
}