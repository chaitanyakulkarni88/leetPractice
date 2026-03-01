import java.util.*;

public class BestTimeToBuyAndSellStockIV {

    /*
     * LeetCode Problem: 188 - Best Time to Buy and Sell Stock IV
     *
     * Time Complexity  : O(k * n)
     * Space Complexity : O(k)
     *
     * Core Idea:
     * 1. If k >= n/2 → behaves like unlimited transactions.
     * 2. Otherwise:
     *      buy[t]  = max profit after t-th buy
     *      sell[t] = max profit after t-th sell
     * 3. For each price:
     *      buy[t]  = max(buy[t], sell[t-1] - price)
     *      sell[t] = max(sell[t], buy[t] + price)
     *
     * Algorithm Pattern: DP + State Machine
     */

    public static int maxProfit(int k, int[] prices) {

        if (prices == null || prices.length == 0 || k == 0) {
            return 0;
        }

        int n = prices.length;

        // Optimization: unlimited transactions case
        if (k >= n / 2) {
            return unlimitedTransactions(prices);
        }

        int[] buy = new int[k + 1];
        int[] sell = new int[k + 1];

        Arrays.fill(buy, Integer.MIN_VALUE);

        for (int price : prices) {

            for (int t = 1; t <= k; t++) {

                buy[t] = Math.max(buy[t], sell[t - 1] - price);
                sell[t] = Math.max(sell[t], buy[t] + price);
            }
        }

        return sell[k];
    }

    private static int unlimitedTransactions(int[] prices) {

        int profit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }

        return profit;
    }

    public static void main(String[] args) {

        int[] prices1 = {2,4,1};
        int[] prices2 = {3,2,6,5,0,3};
        int[] prices3 = {1,2,3,4,5};

        System.out.println("Example 1 → " + maxProfit(2, prices1));
        System.out.println("Example 2 → " + maxProfit(2, prices2));
        System.out.println("Unlimited Case → " + maxProfit(100, prices3));
    }
}