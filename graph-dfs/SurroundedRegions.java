/**
 * LeetCode Problem: 130. Surrounded Regions
 *
 * Time Complexity: O(m × n)
 * Space Complexity: O(m × n)
 *
 * Core Idea:
 * 1. Start BFS from boundary 'O's.
 * 2. Mark them as temporary safe ('T').
 * 3. Flip remaining 'O' to 'X'.
 * 4. Restore 'T' back to 'O'.
 */
import java.util.ArrayDeque;
import java.util.Queue;

public class SurroundedRegions {

    private static final int[][] DIRECTIONS = {
            {1, 0}, {-1, 0},
            {0, 1}, {0, -1}
    };

    public static void solve(char[][] board) {

        if (board == null || board.length == 0) {
            return;
        }

        int rows = board.length;
        int cols = board[0].length;

        // 1. Mark boundary-connected regions
        for (int r = 0; r < rows; r++) {
            if (board[r][0] == 'O') bfs(board, r, 0);
            if (board[r][cols - 1] == 'O') bfs(board, r, cols - 1);
        }

        for (int c = 0; c < cols; c++) {
            if (board[0][c] == 'O') bfs(board, 0, c);
            if (board[rows - 1][c] == 'O') bfs(board, rows - 1, c);
        }

        // 2. Flip and restore
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {

                if (board[r][c] == 'O') {
                    board[r][c] = 'X';
                } else if (board[r][c] == 'T') {
                    board[r][c] = 'O';
                }
            }
        }
    }

    private static void bfs(char[][] board, int r, int c) {

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{r, c});
        board[r][c] = 'T';

        while (!queue.isEmpty()) {

            int[] cell = queue.poll();

            for (int[] dir : DIRECTIONS) {

                int newR = cell[0] + dir[0];
                int newC = cell[1] + dir[1];

                if (isValid(board, newR, newC)) {
                    board[newR][newC] = 'T';
                    queue.offer(new int[]{newR, newC});
                }
            }
        }
    }

    private static boolean isValid(char[][] board, int r, int c) {
        return r >= 0 && r < board.length
                && c >= 0 && c < board[0].length
                && board[r][c] == 'O';
    }
}