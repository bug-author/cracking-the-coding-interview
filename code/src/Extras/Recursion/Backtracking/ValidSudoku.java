package Extras.Recursion.Backtracking;
// LeetCode 36
public class ValidSudoku {
    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

        System.out.println(isValidSudoku(board));
    }

    public static boolean isValidSudoku(char[][] board) {
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (board[r][c] != '.') {
                    // validate
                    // check row
                    // check col
                    // check submatrix
                    if (!helper(board, r, c, board[r][c])) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    static boolean helper(char[][] board, int row, int col, char choice) {
        for (int i = 0; i < board.length; i++) {
            // row
            if (board[row][i] == choice && i != col) {
                return false;
            }
            // col
            if (board[i][col] == choice && i != row) {
                return false;
            }
        }

        // submatrix
        int sqrt = (int) Math.sqrt(board.length);
        int rowStart = row - row % sqrt;
        int colStart = col - col % sqrt;
        for (int r = rowStart; r < rowStart + sqrt; r++) {
            for (int c = colStart; c < colStart + sqrt; c++) {
                if (board[r][c] == choice && r != row && c != col) {
                    return false;
                }
            }
        }

        return true;
    }

}
