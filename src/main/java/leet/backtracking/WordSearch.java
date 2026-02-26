package leet.backtracking;

public class WordSearch {

    public static boolean exist(char[][] board, String word) {

        int rows = board.length;
        int cols = board[0].length;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {

                if (dfs(board, word, r, c, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean dfs(char[][] board,
                               String word,
                               int r,
                               int c,
                               int index) {

        if (index == word.length()) {
            return true;
        }

        if (r < 0 || c < 0 ||
                r >= board.length || c >= board[0].length ||
                board[r][c] != word.charAt(index)) {
            return false;
        }

        char temp = board[r][c];
        board[r][c] = '#';  // mark visited

        boolean found =
                dfs(board, word, r + 1, c, index + 1) ||
                        dfs(board, word, r - 1, c, index + 1) ||
                        dfs(board, word, r, c + 1, index + 1) ||
                        dfs(board, word, r, c - 1, index + 1);

        board[r][c] = temp;  // restore (backtrack)

        return found;
    }

    public static void main(String[] args) {

        char[][] board = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };

        System.out.println("Exists (ABCCED): " +
                exist(board, "ABCCED"));  // true

        System.out.println("Exists (SEE): " +
                exist(board, "SEE"));     // true

        System.out.println("Exists (ABCB): " +
                exist(board, "ABCB"));    // false
    }
}
