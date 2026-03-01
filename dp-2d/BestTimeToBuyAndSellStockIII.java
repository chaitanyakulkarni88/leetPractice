import java.util.*;

public class BestTimeToBuyAndSellStockIII {

    /*
     * LeetCode Problem: 123 - Best Time to Buy and Sell Stock III
     *
     * Time Complexity  : O(n)
     * Space Complexity : O(1)
     *
     * Core Idea:
     * 1. We track four states:
     *      - firstBuy
     *      - firstSell
     *      - secondBuy
     *      - secondSell
     * 2. For each price:
     *      firstBuy   = max(firstBuy, -price)
     *      firstSell  = max(firstSell, firstBuy + price)
     *      secondBuy  = max(secondBuy, firstSell - price)
     *      secondSell = max(secondSell, secondBuy + price)
     * 3. Final answer = secondSell
     *
     * Algorithm Pattern: State Machine / DP Optimization
     */

    public static int maxProfit(int[] prices) {

        if (prices == null || prices.length == 0) {
            return 0;
        }

        int firstBuy = Integer.MIN_VALUE;
        int firstSell = 0;

        int secondBuy = Integer.MIN_VALUE;
        int secondSell = 0;

        for (int price : prices) {

            firstBuy = Math.max(firstBuy, -price);
            firstSell = Math.max(firstSell, firstBuy + price);

            secondBuy = Math.max(secondBuy, firstSell - price);
            secondSell = Math.max(secondSell, secondBuy + price);
        }

        return secondSell;
    }

    public static void main(String[] args) {

        int[] prices1 = {3,3,5,0,0,3,1,4};
        int[] prices2 = {1,2,3,4,5};
        int[] prices3 = {7,6,4,3,1};
        int[] prices4 = {1};

        System.out.println("Example 1 → " + maxProfit(prices1));
        System.out.println("Example 2 → " + maxProfit(prices2));
        System.out.println("Example 3 → " + maxProfit(prices3));
        System.out.println("Example 4 → " + maxProfit(prices4));
    }
}