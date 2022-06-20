package Chapter1;

import java.util.Arrays;

public class RotateMatrix {
    // leetcode 48
    public static void main(String[] args) {
        int[][] mat =  {{1,2,3}, {4,5,6}, {7,8,9}};
        prettyPrintMatrix(mat);
        System.out.println("\n");
        rotateMatrix(mat);
        prettyPrintMatrix(mat);
    }

    static void rotateMatrix(int[][] matrix){
        // first take transpose
        // then swap
        for (int row = 0; row < matrix.length; row++){
            for (int col = row; col < matrix[0].length; col++){
                // transpose
                int temp = 0;
                temp = matrix[row][col];
                matrix[row][col] = matrix[col][row];
                matrix[col][row] = temp;
            }
        }

        int colTotal = matrix[0].length;
        for (int i=0; i < matrix.length; i++){
            for (int j=0; j < colTotal/2; j++){
                // swap first with last
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][colTotal-j-1];
                matrix[i][colTotal-j-1] = temp;
            }
        }


    }

    static int[][] transpose(int[][] matrix) {
        int[][] mat = new int[matrix[0].length][matrix.length];

        for (int i=0; i < matrix.length; i++){
            for (int j=0; j < matrix[0].length; j++){
                mat[j][i] = matrix[i][j];
            }
        }
        return mat;
    }

    static void swap(int[][] mat){
        for (int row = 0; row < mat.length; row++) {
            for (int col = 0; col < mat[0].length; col++) {
                if (row == col){
                    int temp = 0;
                    temp = mat[row][col];
                    mat[row][col] = col;
                    mat[col][row] = temp;
                }
            }

        }
    }
    static void prettyPrintMatrix(int[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
