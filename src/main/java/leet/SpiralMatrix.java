package leet;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
        SpiralMatrix sm = new SpiralMatrix();

    }
    public List<Integer> spiralOrder(int[][] matrix) {
        int rowBegin = 0;
        int rowEnd = matrix.length-1;
        int columnBegin = 0;
        int columnEnd = matrix[0].length-1;
        List<Integer> result = new ArrayList<>();

        while(rowBegin<=rowEnd && columnBegin<=columnEnd) {
            for(int j=columnBegin;j<=columnEnd;j++)
                result.add(matrix[rowBegin][j]);
            rowBegin++;
            for(int i=rowBegin;i<=rowEnd;i++)
                result.add(matrix[i][columnEnd]);
            columnEnd--;
            if(rowBegin <= rowEnd) {
                for(int j=columnEnd;j>=columnBegin;j--)
                    result.add(matrix[rowEnd][j]);
            }
            rowEnd--;
            if(columnBegin<=columnEnd) {
                for(int i=rowEnd;i>=rowBegin;i--)
                    result.add(matrix[i][columnBegin]);
            }
            columnBegin++;
        }
        return result;
    }
}
