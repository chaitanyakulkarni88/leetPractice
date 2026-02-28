/*
 * LeetCode Problem: #6 - Zigzag Conversion
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 *
 * Core Idea:
 * 1. Create StringBuilder for each row.
 * 2. Traverse downwards from row 0 to numRows-1.
 * 3. Then traverse diagonally upwards to row 1.
 * 4. Repeat until all characters are placed.
 * 5. Concatenate all rows.
 *
 * Pattern: Simulation / Row Traversal
 */

public class ZigzagConversion {

    public String convert(String s, int numRows) {

        if (s == null || s.length() == 0 || numRows <= 1 || numRows >= s.length()) {
            return s;
        }

        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int index = 0;
        int n = s.length();

        while (index < n) {

            // Move down
            for (int row = 0; row < numRows && index < n; row++) {
                rows[row].append(s.charAt(index++));
            }

            // Move up diagonally
            for (int row = numRows - 2; row > 0 && index < n; row--) {
                rows[row].append(s.charAt(index++));
            }
        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }

        return result.toString();
    }

    public static void main(String[] args) {

        ZigzagConversion solution = new ZigzagConversion();

        System.out.println(solution.convert("PAYPALISHIRING", 3)); // PAHNAPLSIIGYIR
        System.out.println(solution.convert("PAYPALISHIRING", 4)); // PINALSIGYAHRPI
        System.out.println(solution.convert("A", 1));              // A
    }
}