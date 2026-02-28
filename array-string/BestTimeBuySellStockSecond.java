/*
 * LeetCode Problem: #122 - Best Time to Buy and Sell Stock II
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 * Core Idea:
 * 1. Multiple transactions allowed.
 * 2. Capture every upward price difference.
 * 3. If today's price > yesterday's, add the difference to profit.
 * 4. Sum all positive differences.
 *
 * Pattern: Greedy / Peak-Valley Simplification
 */

public class BestTimeBuySellStockSecond {

    public int maxProfit(int[] prices) {

        if (prices == null || prices.length <= 1) {
            return 0;
        }

        int totalProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                totalProfit += prices[i] - prices[i - 1];
            }
        }

        return totalProfit;
    }

    public static void main(String[] args) {

        BestTimeBuySellStockSecond solution = new BestTimeBuySellStockSecond();

        int[] prices1 = {7, 1, 5, 3, 6, 4};
        System.out.println("Max Profit: " + solution.maxProfit(prices1));

        int[] prices2 = {1, 2, 3, 4, 5};
        System.out.println("Max Profit: " + solution.maxProfit(prices2));

        int[] prices3 = {7, 6, 4, 3, 1};
        System.out.println("Max Profit: " + solution.maxProfit(prices3));
    }
}