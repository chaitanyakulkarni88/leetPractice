package leet;

class GameOfLife {
    public void gameOfLife(int[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int liveNeighbors = countLiveNeighbors(board, row, col, rows, cols);

                if (board[row][col] == 1 && (liveNeighbors < 2 || liveNeighbors > 3)) {
                    board[row][col] = 2;
                }

                if (board[row][col] == 0 && liveNeighbors == 3) {
                    board[row][col] = -1;
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

        for (int neighborRow = row - 1; neighborRow <= row + 1; neighborRow++) {
            for (int neighborCol = col - 1; neighborCol <= col + 1; neighborCol++) {
                if (neighborRow < 0 || neighborRow >= rows ||
                        neighborCol < 0 || neighborCol >= cols ||
                        (neighborRow == row && neighborCol == col)) {
                    continue;
                }

                if (board[neighborRow][neighborCol] > 0) {
                    liveCount++;
                }
            }
        }

        return liveCount;
    }

    public static void main(String[] args) {
        GameOfLife gof = new GameOfLife();
        int[][] board = {
                {0, 1, 0},
                {0, 0, 1},
                {1, 1, 1},
                {0, 0, 0}
        };
        gof.gameOfLife(board);
    }

}
