package Extras.Recursion.Maze;
// similar to leetcode 62 -> Time Limit Exceeded on LeetCode ~ requires Dynamic Programming

import javax.xml.xpath.XPathEvaluationResult;

public class NumberOfPaths {
    public static void main(String[] args) {
        System.out.println(numPaths(3, 3));
        printPaths("", 3, 3);
    }

    static int numPaths(int row, int col) {
        // base condition
        if (row == 1 || col == 1) {
            return 1;
        }

        // recursive calls
        int first = numPaths(row - 1, col);
        int second = numPaths(row, col - 1);
        return first + second;
    }

    static void printPaths(String p, int r, int c) {
        // base condition
        if (r == 1 && c == 1) {
            System.out.println(p);
            return;
        }

        if (r != 1) {
            printPaths(p + "D ", r - 1, c);
        }
        if (c != 1) {
            printPaths(p + "R ", r, c - 1);
        }
    }
}
