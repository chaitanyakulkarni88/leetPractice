/**
 * LeetCode Problem: 200. Number of Islands
 *
 * Time Complexity: O(m × n)
 * Space Complexity: O(m × n) worst-case
 *
 * Core Idea:
 * 1. Traverse grid.
 * 2. When '1' is found, increment count.
 * 3. Use BFS/DFS to mark entire island as visited.
 */
import java.util.ArrayDeque;
import java.util.Queue;

public class NumberOfIslands {

    private static final int[][] DIRECTIONS = {
            {1, 0}, {-1, 0},
            {0, 1}, {0, -1}
    };

    public static int numIslands(char[][] grid) {

        if (grid == null || grid.length == 0) {
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length;
        int islandCount = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {

                if (grid[r][c] == '1') {
                    islandCount++;
                    bfs(grid, r, c);
                }
            }
        }

        return islandCount;
    }

    private static void bfs(char[][] grid, int r, int c) {

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{r, c});
        grid[r][c] = '0';

        while (!queue.isEmpty()) {

            int[] cell = queue.poll();

            for (int[] dir : DIRECTIONS) {

                int newR = cell[0] + dir[0];
                int newC = cell[1] + dir[1];

                if (isValid(grid, newR, newC)) {
                    queue.offer(new int[]{newR, newC});
                    grid[newR][newC] = '0';
                }
            }
        }
    }

    private static boolean isValid(char[][] grid, int r, int c) {
        return r >= 0 && r < grid.length
                && c >= 0 && c < grid[0].length
                && grid[r][c] == '1';
    }
}