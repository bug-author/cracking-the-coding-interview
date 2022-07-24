package Extras.Recursion.Backtracking;

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
        backtrackMaze("", maze, 0, 0);
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
}
