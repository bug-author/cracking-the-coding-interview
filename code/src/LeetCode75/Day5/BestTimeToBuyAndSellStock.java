package LeetCode75.Day5;

// leetcode 121
public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        int[] prices2 = {7, 6, 4, 3, 1};

//        System.out.println(maxProfitGreedy(prices1));
//        System.out.println(maxProfitGreedy(prices2));

        System.out.println(maxProfit(prices1));
        System.out.println(maxProfit(prices2));
    }

    public static int maxProfit(int[] prices) {
        // sliding window/ 2 pointers technique
        int maxP = 0;
        int profit = 0;
        int left = 0;
        int right = 1;

        while (right < prices.length) {
            if (prices[left] > prices[right]) {
                left = right;
                right += 1;
            } else {
                profit = prices[right] - prices[left];
                maxP = Math.max(profit, maxP);
                right += 1;
            }
        }
        return maxP;
    }

    public static int maxProfitGreedy(int[] prices) {
        // greedy approach
        int maxProfit = 0;
        int buyCheapest = 100000;
        int profit = 0;

        for (int i = 0; i < prices.length; i++) {
            buyCheapest = Math.min(buyCheapest, prices[i]);
            profit = prices[i] - buyCheapest;
            maxProfit = Math.max(profit, maxProfit);
        }

        return maxProfit;
    }

}
