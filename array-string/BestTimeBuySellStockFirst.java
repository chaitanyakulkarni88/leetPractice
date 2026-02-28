/*
 * LeetCode Problem: #121 - Best Time to Buy and Sell Stock
 *
 * Time Complexity:
 *   - Brute Force: O(n^2)
 *   - Optimal: O(n)
 *
 * Space Complexity: O(1)
 *
 * Core Idea:
 * 1. Track the minimum price seen so far.
 * 2. For each day, compute potential profit.
 * 3. Update maximum profit if higher.
 * 4. Return maximum profit.
 *
 * Pattern: Greedy / One Pass Min Tracking
 */

public class BestTimeBuySellStockFirst {

    // Optimal Greedy Approach
    public static int maxProfit(int[] prices) {

        if (prices == null || prices.length <= 1) {
            return 0;
        }

        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {

            if (price < minPrice) {
                minPrice = price;
            } else {
                maxProfit = Math.max(maxProfit, price - minPrice);
            }
        }

        return maxProfit;
    }

    // Brute Force (for comparison)
    public static int maxProfitBruteForce(int[] prices) {

        int maxProfit = 0;

        for (int buy = 0; buy < prices.length; buy++) {
            for (int sell = buy + 1; sell < prices.length; sell++) {
                maxProfit = Math.max(maxProfit, prices[sell] - prices[buy]);
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {

        int[] prices1 = {7, 1, 5, 3, 6, 4};
        System.out.println("Max Profit: " + maxProfit(prices1));

        int[] prices2 = {7, 6, 4, 3, 1};
        System.out.println("Max Profit: " + maxProfit(prices2));

        int[] prices3 = {1, 2};
        System.out.println("Max Profit: " + maxProfit(prices3));
    }
}