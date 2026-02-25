package leet;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {

    public static int numIslands(char[][] grid) {

        if (grid == null || grid.length == 0) return 0;

        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {

                if (grid[r][c] == '1') {
                    count++;
                    bfs(grid, r, c);
                }
            }
        }

        return count;
    }

    private static void bfs(char[][] grid, int r, int c) {

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{r, c});
        grid[r][c] = '0'; // mark visited

        int[][] directions = {
                {1, 0}, {-1, 0},
                {0, 1}, {0, -1}
        };

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();

            for (int[] dir : directions) {
                int newR = cell[0] + dir[0];
                int newC = cell[1] + dir[1];

                if (newR >= 0 && newR < grid.length &&
                        newC >= 0 && newC < grid[0].length &&
                        grid[newR][newC] == '1') {

                    queue.offer(new int[]{newR, newC});
                    grid[newR][newC] = '0'; // mark visited
                }
            }
        }
    }

    public static void main(String[] args) {

        char[][] grid = {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };

        System.out.println("Number of Islands: " + numIslands(grid));
    }
}
