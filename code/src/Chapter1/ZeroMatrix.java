package Chapter1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class ZeroMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
//        System.out.println(matrix.length); // ROWS
//        System.out.println(matrix[0].length); // COLS

//        setZeroesBF(matrix);
        setZeros(matrix);
    }

    // leetcode 73
    public static void setZeroesBF(int[][] matrix) {
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

    public static void setZeros(int[][] matrix){
        // optimized
        // leetcode -> 1ms faster than 96%
        // check first row and first col
        boolean isFirstRowZero = false;
        boolean isFirstColZero = false;

        // iterate first col
        for (int i=0; i < matrix.length; i++){
            if (matrix[i][0] == 0){
                isFirstColZero = true;
                break;
            }
        }

        // iterate first row
        for (int i=0; i < matrix[0].length; i++){
            if (matrix[0][i] == 0){
                isFirstRowZero = true;
                break;
            }
        }

        // iterate rest of the array
        for (int i=1; i < matrix.length; i++){
            for (int j=1; j < matrix[0].length; j++){
                if (matrix[i][j] == 0){
                    // set first entry in that col zero
                    matrix[0][j] = 0;

                    // set first entry in that row zero
                    matrix[i][0] = 0;
                }
            }
        }

        // set stuff equal to zero
        // iterate first    row and set zeros based on first row
        for (int i=1; i < matrix[0].length; i++){
            if (matrix[0][i] == 0){
                // make col zero
                for (int x=0; x < matrix.length; x++){
                    matrix[x][i] = 0;
                }
            }
        }

        // make row zero based on values in first col
        for (int i=1; i < matrix.length; i++){
            if (matrix[i][0] == 0){
                // make row zero
                for (int x=0; x < matrix[0].length; x++){
                    matrix[i][x] = 0;
                }
            }
        }

        if (isFirstRowZero){
            // make row zero
            for (int x=0; x < matrix[0].length; x++){
                matrix[0][x] = 0;
            }
        }

        if (isFirstColZero){
            // make col zero
            for (int i=0; i < matrix.length; i++){
                matrix[i][0] = 0;
            }
        }

        System.out.println(Arrays.deepToString(matrix));
    }
}
