package LeetCode75.Day10;

public class ClimbingStairs {
    public int climbStairs(int n) {
        // int[] memo = new int[n+1];
        // return helperMemoization(n, memo);
        return helperTabulation(n);
    }

    public int helperMemoization(int n, int[] memo) {
        // base
        if (n == 0) return 1;
        if (n < 0) return 0;

        // memo
        if (memo[n] > 0) return memo[n];

        int cp = helperMemoization(n - 1, memo) + helperMemoization(n - 2, memo);
        memo[n] = cp;
        return cp;
    }

    public int helperTabulation(int n) {
        /*
        tabulation -> iteration
        memoization -> recursive

        // steps for tabulation
        1. Storage and meaning
        2. Direction (left or right acc to size of problem)
        3. Travel and Solve

        https://www.youtube.com/watch?v=A6mOASLl2Dg
        */

        int[] dp = new int[n + 1];

        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                dp[i] = dp[i - 1];
            } else {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
        }

        return dp[n];
    }
}
