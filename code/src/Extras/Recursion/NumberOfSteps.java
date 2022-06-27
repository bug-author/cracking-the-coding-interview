package Extras.Recursion;

// leetcode 1342
public class NumberOfSteps {
    public static void main(String[] args) {
        System.out.println(numberOfSteps(14));
    }

    public static int numberOfSteps(int num) {
        // recursive approach
        return helper(num, 0);
    }

    public static int helper(int num, int numSteps) {
        if (num == 0) {
            return numSteps;
        }

        // num % 2 == 0 -> number is even
        if (num % 2 == 0) {
            return helper(num / 2, numSteps+1);
        } else {
            return helper(num - 1, numSteps+1);
        }
    }
}
