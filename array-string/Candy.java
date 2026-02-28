/*
 * LeetCode Problem: #135 - Candy
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 *
 * Core Idea:
 * 1. Every child must have at least one candy.
 * 2. Left to right:
 *    If rating[i] > rating[i-1], give more candies than left neighbor.
 * 3. Right to left:
 *    If rating[i] > rating[i+1], give more candies than right neighbor.
 * 4. Final candies for each child = max(left[i], right[i]).
 * 5. Sum all candies.
 *
 * Pattern: Two-Pass Greedy
 */

public class Candy {

    public int candy(int[] ratings) {

        if (ratings == null || ratings.length == 0) {
            return 0;
        }

        int n = ratings.length;

        if (n == 1) {
            return 1;
        }

        int[] left = new int[n];
        int[] right = new int[n];

        left[0] = 1;
        for (int i = 1; i < n; i++) {
            left[i] = (ratings[i] > ratings[i - 1])
                    ? left[i - 1] + 1
                    : 1;
        }

        right[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            right[i] = (ratings[i] > ratings[i + 1])
                    ? right[i + 1] + 1
                    : 1;
        }

        int totalCandies = 0;

        for (int i = 0; i < n; i++) {
            totalCandies += Math.max(left[i], right[i]);
        }

        return totalCandies;
    }

    public static void main(String[] args) {

        Candy solution = new Candy();

        int[] ratings1 = {1, 0, 2};
        System.out.println("Total Candies: " + solution.candy(ratings1));

        int[] ratings2 = {1, 2, 2};
        System.out.println("Total Candies: " + solution.candy(ratings2));

        int[] ratings3 = {1, 2, 6, 5, 4, 3, 1};
        System.out.println("Total Candies: " + solution.candy(ratings3));
    }
}