/*
 * LeetCode Problem: #36 - Valid Sudoku
 *
 * Time Complexity: O(1)
 *   (Board size fixed at 9x9)
 *
 * Space Complexity: O(1)
 *
 * Core Idea:
 * 1. Use a HashSet to track constraints:
 *      - Digit in row
 *      - Digit in column
 *      - Digit in 3x3 box
 * 2. If any duplicate constraint detected → invalid.
 *
 * Pattern: Hashing / Constraint Validation
 */

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {

        if (board == null || board.length != 9 || board[0].length != 9) {
            return false;
        }

        Set<String> seen = new HashSet<>();

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {

                char value = board[row][col];

                if (value == '.') {
                    continue;
                }

                String rowKey = value + " in row " + row;
                String colKey = value + " in col " + col;
                String boxKey = value + " in box " + (row / 3) + "-" + (col / 3);

                if (!seen.add(rowKey) ||
                        !seen.add(colKey) ||
                        !seen.add(boxKey)) {
                    return false;
                }
            }
        }

        return true;
    }
}