package leet;

import java.util.LinkedList;
import java.util.Queue;

public class SurroundedRegions {

    public static void solve(char[][] board) {

        if (board == null || board.length == 0) return;

        int rows = board.length;
        int cols = board[0].length;

        for (int r = 0; r < rows; r++) {
            if (board[r][0] == 'O') bfs(board, r, 0);
            if (board[r][cols - 1] == 'O') bfs(board, r, cols - 1);
        }

        for (int c = 0; c < cols; c++) {
            if (board[0][c] == 'O') bfs(board, 0, c);
            if (board[rows - 1][c] == 'O') bfs(board, rows - 1, c);
        }

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

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{r, c});
        board[r][c] = 'T';

        int[][] directions = {
                {1, 0}, {-1, 0},
                {0, 1}, {0, -1}
        };

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();

            for (int[] dir : directions) {
                int newR = cell[0] + dir[0];
                int newC = cell[1] + dir[1];

                if (newR >= 0 && newR < board.length &&
                        newC >= 0 && newC < board[0].length &&
                        board[newR][newC] == 'O') {

                    board[newR][newC] = 'T';
                    queue.offer(new int[]{newR, newC});
                }
            }
        }
    }

    public static void main(String[] args) {

        char[][] board = {
                {'X','X','X','X'},
                {'X','O','O','X'},
                {'X','X','O','X'},
                {'X','O','X','X'}
        };

        solve(board);

        System.out.println("Board after solving:");
        for (char[] row : board) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
}
