import java.util.*;

public class CoinChange {

    /*
     * LeetCode Problem: 322 - Coin Change
     *
     * Time Complexity  : O(amount * n)
     * Space Complexity : O(amount)
     *
     * n = number of coin types
     *
     * Core Idea:
     * 1. Use DP where dp[i] = minimum coins to make amount i.
     * 2. Initialize dp[0] = 0, others = large value.
     * 3. For each amount, try every coin.
     * 4. If dp[amount] remains large → return -1.
     *
     * Algorithm Pattern: Dynamic Programming (Unbounded Knapsack)
     */

    public static int coinChange(int[] coins, int amount) {

        if (amount < 0) {
            throw new IllegalArgumentException("Amount must be non-negative.");
        }

        if (amount == 0) {
            return 0;
        }

        if (coins == null || coins.length == 0) {
            return -1;
        }

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);

        dp[0] = 0;

        for (int currentAmount = 1; currentAmount <= amount; currentAmount++) {

            for (int coin : coins) {

                if (coin <= currentAmount) {
                    dp[currentAmount] = Math.min(
                            dp[currentAmount],
                            dp[currentAmount - coin] + 1
                    );
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {

        int[] coins1 = {1, 2, 5};
        int amount1 = 11;

        int[] coins2 = {2};
        int amount2 = 3;

        int[] coins3 = {1};
        int amount3 = 0;

        System.out.println("Example 1 → " +
                coinChange(coins1, amount1));

        System.out.println("Example 2 → " +
                coinChange(coins2, amount2));

        System.out.println("Example 3 → " +
                coinChange(coins3, amount3));
    }
}