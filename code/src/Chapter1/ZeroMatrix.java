package Chapter1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class ZeroMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        System.out.println(matrix.length); // ROWS
        System.out.println(matrix[0].length); // COLS

        setZeroes(matrix);
    }

    // leetcode 73
    public static void setZeroes(int[][] matrix) {
        // brute force solution 2ms faster than 43%
        ArrayList<Integer> rows = new ArrayList(matrix.length);
        ArrayList<Integer> cols = new ArrayList(matrix[0].length);

        for(int row=0; row < matrix.length; row++){
            for (int col=0; col < matrix[row].length; col++){
                if (matrix[row][col] == 0){
                    rows.add(row);
                    cols.add(col);
                }
            }
        }
        for (int r: rows){
            for(int i=0; i < matrix[r].length; i++){
                matrix[r][i] = 0;
            }
        }

        for (int c: cols){
            for(int i=0; i < matrix.length; i++){
                matrix[i][c] = 0;
            }
        }
        System.out.println(Arrays.deepToString(matrix));
    }


}
