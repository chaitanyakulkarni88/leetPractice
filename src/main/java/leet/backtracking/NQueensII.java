package leet.backtracking;

public class NQueensII {

    public static int totalNQueens(int n) {

        boolean[] cols = new boolean[n];
        boolean[] diag = new boolean[2 * n];
        boolean[] antiDiag = new boolean[2 * n];

        return backtrack(0, n, cols, diag, antiDiag);
    }

    private static int backtrack(int row,
                                 int n,
                                 boolean[] cols,
                                 boolean[] diag,
                                 boolean[] antiDiag) {

        if (row == n) {
            return 1; // Found valid arrangement
        }

        int count = 0;

        for (int col = 0; col < n; col++) {

            int d = row - col + n;
            int ad = row + col;

            if (cols[col] || diag[d] || antiDiag[ad]) continue;

            cols[col] = true;
            diag[d] = true;
            antiDiag[ad] = true;

            count += backtrack(row + 1, n, cols, diag, antiDiag);

            cols[col] = false;
            diag[d] = false;
            antiDiag[ad] = false;
        }

        return count;
    }

    public static void main(String[] args) {

        int n = 4;

        System.out.println("Total N-Queens solutions for n=4: "
                + totalNQueens(n));
    }
}
