import java.util.*;

public class WordSearch {

    /*
     * LeetCode Problem: 79 - Word Search
     *
     * Time Complexity  : O(m * n * 4^L)
     * Space Complexity : O(L)
     *
     * m = rows, n = columns, L = word length
     *
     * Core Idea:
     * 1. Try starting DFS from every cell.
     * 2. If character matches, explore 4 directions.
     * 3. Mark cell as visited temporarily.
     * 4. Backtrack by restoring the cell.
     *
     * Algorithm Pattern: Backtracking (DFS on Grid)
     */

    public static boolean exist(char[][] board, String word) {

        if (board == null || board.length == 0 ||
                board[0].length == 0 || word == null || word.isEmpty()) {
            return false;
        }

        int rows = board.length;
        int cols = board[0].length;

        if (word.length() > rows * cols) {
            return false;
        }

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {

                if (dfs(board, word, row, col, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean dfs(char[][] board,
                               String word,
                               int row,
                               int col,
                               int index) {

        if (index == word.length()) {
            return true;
        }

        if (row < 0 || col < 0 ||
                row >= board.length || col >= board[0].length ||
                board[row][col] != word.charAt(index)) {
            return false;
        }

        char originalValue = board[row][col];
        board[row][col] = '#';

        boolean found =
                dfs(board, word, row + 1, col, index + 1) ||
                        dfs(board, word, row - 1, col, index + 1) ||
                        dfs(board, word, row, col + 1, index + 1) ||
                        dfs(board, word, row, col - 1, index + 1);

        board[row][col] = originalValue;

        return found;
    }

    public static void main(String[] args) {

        char[][] board = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };

        System.out.println("Exists (ABCCED): " + exist(board, "ABCCED"));
        System.out.println("Exists (SEE): " + exist(board, "SEE"));
        System.out.println("Exists (ABCB): " + exist(board, "ABCB"));
    }
}