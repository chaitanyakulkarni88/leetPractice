/**
 * LeetCode Problem: 289. Game of Life
 *
 * Time Complexity: O(m * n)
 * Space Complexity: O(1)
 *
 * Core Idea:
 * 1. Traverse board and count live neighbors for each cell.
 * 2. Encode state transitions in-place:
 *      - 2  → live → dead
 *      - -1 → dead → live
 * 3. Second pass converts encoded values to final states.
 */
public class GameOfLife {

    public static void main(String[] args) {
        GameOfLife solution = new GameOfLife();

        int[][] board = {
                {0, 1, 0},
                {0, 0, 1},
                {1, 1, 1},
                {0, 0, 0}
        };

        solution.gameOfLife(board);
        printBoard(board);
    }

    public void gameOfLife(int[][] board) {
        validateInput(board);

        int rows = board.length;
        int cols = board[0].length;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {

                int liveNeighbors = countLiveNeighbors(board, row, col, rows, cols);

                if (board[row][col] == 1 && (liveNeighbors < 2 || liveNeighbors > 3)) {
                    board[row][col] = 2;      // Live → Dead
                } else if (board[row][col] == 0 && liveNeighbors == 3) {
                    board[row][col] = -1;     // Dead → Live
                }
            }
        }

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (board[row][col] == 2) {
                    board[row][col] = 0;
                } else if (board[row][col] == -1) {
                    board[row][col] = 1;
                }
            }
        }
    }

    private int countLiveNeighbors(int[][] board, int row, int col, int rows, int cols) {
        int liveCount = 0;

        for (int r = row - 1; r <= row + 1; r++) {
            for (int c = col - 1; c <= col + 1; c++) {

                if (r < 0 || r >= rows || c < 0 || c >= cols || (r == row && c == col)) {
                    continue;
                }

                if (board[r][c] == 1 || board[r][c] == 2) {
                    liveCount++;
                }
            }
        }

        return liveCount;
    }

    private void validateInput(int[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            throw new IllegalArgumentException("Board must not be null or empty.");
        }
    }

    private static void printBoard(int[][] board) {
        for (int[] row : board) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
}