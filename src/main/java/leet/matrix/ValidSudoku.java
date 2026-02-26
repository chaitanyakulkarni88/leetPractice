package leet.matrix;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
    public static void main(String[] args) {
        ValidSudoku vs = new ValidSudoku();

    }
    public boolean isValidSudoku(char[][] board) {
        Set<String> sudoku = new HashSet<>();
        for(int i=0;i< board.length;i++) {
            for(int j=0;j< board.length;j++) {
                char value = board[i][j];
                if(value != '.') {
                    if(!sudoku.add(value+" in "+i+" row") ||
                            !sudoku.add(value+" in "+j+" column") ||
                            !sudoku.add(value+" in "+i/3+"-"+j/3+" box"))
                        return false;
                }
            }
        }
        return true;
    }
}
