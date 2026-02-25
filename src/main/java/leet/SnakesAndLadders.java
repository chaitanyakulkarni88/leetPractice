package leet;

import java.util.LinkedList;
import java.util.Queue;

public class SnakesAndLadders {

    public static int snakesAndLadders(int[][] board) {

        int n = board.length;
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n * n + 1];

        queue.offer(1);
        visited[1] = true;

        int moves = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int curr = queue.poll();

                if (curr == n * n) return moves;

                for (int dice = 1; dice <= 6 && curr + dice <= n * n; dice++) {

                    int next = curr + dice;
                    int[] pos = getPosition(next, n);
                    int row = pos[0];
                    int col = pos[1];

                    if (board[row][col] != -1) {
                        next = board[row][col];
                    }

                    if (!visited[next]) {
                        visited[next] = true;
                        queue.offer(next);
                    }
                }
            }

            moves++;
        }

        return -1;
    }

    private static int[] getPosition(int num, int n) {

        int row = n - 1 - (num - 1) / n;
        int col = (num - 1) % n;

        if (((n - 1 - row) % 2) == 1) {
            col = n - 1 - col;
        }

        return new int[]{row, col};
    }

    public static void main(String[] args) {

        int[][] board = {
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, 35, -1, -1, 13, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, 15, -1, -1, -1, -1}
        };

        System.out.println("Minimum moves: " +
                snakesAndLadders(board));
    }
}