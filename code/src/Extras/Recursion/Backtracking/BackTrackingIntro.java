package Extras.Recursion.Backtracking;

import java.util.Arrays;

public class BackTrackingIntro {
    /*
     * for the same maze problem, what if we want to move up and left as well
     *
     * observe that if we just add two more recursive calls for left and up,
     * there would be infinite recursive calls which would result in overflow
     *
     * // 1. mark maze cells that are visited as false so that if we end up
     * at the same cell, we just return from it without getting stuck in a loop
     *
     * // BUT. when a recursive call ends and function gets removed, due to the
     * same reference array, the previous changes (false marks) are still there
     * which affect the normal behaviour of current recursion calls
     *
     * // 2. when going back from a recursion call, the cells marked as false/ visited
     * should be RESTORED, so the new recursion calls have no effect, and they continue as
     * expected
     * */
    public static void main(String[] args) {
        boolean[][] maze = {
                {true, true, true},
                {true, true, true},
                {true, true, true}
        };

        int[][] path = {
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0},
        };
        backtrackPrintPath("", maze, 0, 0, path, 1);
    }

    static void backtrackMaze(String p, boolean[][] maze, int r, int c) {
        if (r == maze.length - 1 && c == maze[0].length - 1) {
            System.out.println(p);
            return;
        }

        if (!maze[r][c]) {
            return;
        }

        // mark this path as visited
        maze[r][c] = false;


        // recursive calls
        if (r < maze.length - 1) {
            backtrackMaze(p + 'D', maze, r + 1, c);
        }
        if (c < maze[0].length - 1) {
            backtrackMaze(p + 'R', maze, r, c + 1);
        }
        if (r > 0) {
            backtrackMaze(p + 'U', maze, r - 1, c);
        }
        if (c > 0) {
            backtrackMaze(p + 'L', maze, r, c - 1);
        }

        // this line is where function will be over
        // before the function gets removed, RESTORE
        // by changing the changes made by function
        maze[r][c] = true;

    }

    static void backtrackPrintPath(String p, boolean[][] maze, int row, int col, int[][] path, int step) {
        // take step variable
        // update path array
        // print in base condition
        // backtrack

        // base condition
        if (row == maze.length - 1 && col == maze[0].length - 1) {
            System.out.println(p);
            // last step will also be included
            path[row][col] = step;
            for (int i = 0; i < path.length; i++) {
                for (int j = 0; j < path[0].length; j++) {
                    System.out.print(path[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println("---------------------------------------");
            return;
        }

        if (!maze[row][col]) {
            return;
        }

        // backtracking init
        maze[row][col] = false;

        //
        path[row][col] = step;

        if (row < maze.length - 1) {
            backtrackPrintPath(p + "D", maze, row + 1, col, path, step + 1);
        }

        if (col < maze[0].length - 1) {
            backtrackPrintPath(p + "R", maze, row, col + 1, path, step + 1);
        }

        if (col > 1) {
            backtrackPrintPath(p + "L", maze, row, col - 1, path, step + 1);
        }

        if (row > 1) {
            backtrackPrintPath(p + "U", maze, row - 1, col, path, step + 1);
        }


        // backtracking end
        maze[row][col] = true;

        //
        path[row][col] = 0;
    }
}
