package LeetCode75.Day10;

public class FibonacciNumbers {
    public int fib(int n) {
        // dp bottom up
        // tabulation
        if (n < 2) return n;

        int[] dp = new int[n + 1];

        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
}
