/**
 * LeetCode Problem: 909. Snakes and Ladders
 *
 * Time Complexity: O(n²)
 * Space Complexity: O(n²)
 *
 * Core Idea:
 * 1. Treat board squares as graph nodes (1 to n²).
 * 2. From each square, try dice rolls (1 to 6).
 * 3. Use BFS to find minimum number of moves.
 * 4. Apply snake/ladder jump if present.
 */
import java.util.ArrayDeque;
import java.util.Queue;

public class SnakesAndLadders {

    public static int snakesAndLadders(int[][] board) {

        int n = board.length;

        if (n == 0) return -1;
        if (n == 1) return 0;

        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[n * n + 1];

        queue.offer(1);
        visited[1] = true;

        int moves = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {

                int curr = queue.poll();

                if (curr == n * n) {
                    return moves;
                }

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
}