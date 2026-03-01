import java.util.*;

public class IPO {

    /*
     * LeetCode Problem: 502 - IPO
     *
     * Time Complexity  : O(n log n)
     * Space Complexity : O(n)
     *
     * Core Idea:
     * 1. Use a min-heap to track projects by required capital.
     * 2. Use a max-heap to select the most profitable among
     *    projects that can be afforded.
     * 3. Repeat up to k times:
     *      - Add affordable projects to max-heap.
     *      - Pick most profitable project.
     *      - Increase capital.
     *
     * Algorithm Pattern: Greedy + Heap
     */

    static class Project {
        int capitalRequired;
        int profit;

        Project(int capitalRequired, int profit) {
            this.capitalRequired = capitalRequired;
            this.profit = profit;
        }
    }

    public static int findMaximizedCapital(int k,
                                           int initialCapital,
                                           int[] profits,
                                           int[] capital) {

        if (profits == null || capital == null ||
                profits.length != capital.length) {
            throw new IllegalArgumentException("Invalid input.");
        }

        int n = profits.length;

        PriorityQueue<Project> minCapitalHeap =
                new PriorityQueue<>(Comparator.comparingInt(p -> p.capitalRequired));

        PriorityQueue<Project> maxProfitHeap =
                new PriorityQueue<>((a, b) -> b.profit - a.profit);

        for (int i = 0; i < n; i++) {
            minCapitalHeap.offer(new Project(capital[i], profits[i]));
        }

        int availableCapital = initialCapital;

        for (int i = 0; i < k; i++) {

            while (!minCapitalHeap.isEmpty() &&
                    minCapitalHeap.peek().capitalRequired <= availableCapital) {

                maxProfitHeap.offer(minCapitalHeap.poll());
            }

            if (maxProfitHeap.isEmpty()) {
                break;
            }

            availableCapital += maxProfitHeap.poll().profit;
        }

        return availableCapital;
    }

    public static void main(String[] args) {

        int k1 = 2;
        int w1 = 0;
        int[] profits1 = {1, 2, 3};
        int[] capital1 = {0, 1, 1};

        System.out.println("Example 1 Result: " +
                findMaximizedCapital(k1, w1, profits1, capital1));

        int k2 = 3;
        int w2 = 1;
        int[] profits2 = {2, 4, 6};
        int[] capital2 = {0, 1, 2};

        System.out.println("Example 2 Result: " +
                findMaximizedCapital(k2, w2, profits2, capital2));
    }
}