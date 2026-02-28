/*
 * LeetCode Problem: #274 - H-Index
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 *
 * Core Idea:
 * 1. H-index is the maximum h such that at least h papers
 *    have ≥ h citations.
 * 2. Create buckets of size n+1.
 * 3. Count citations:
 *    - If citation > n, put it in bucket[n].
 *    - Else increment bucket[citation].
 * 4. Traverse buckets from high to low,
 *    accumulating counts until total >= index.
 *
 * Pattern: Counting / Bucket Sort Optimization
 */

public class HIndex {

    public int hIndex(int[] citations) {

        if (citations == null || citations.length == 0) {
            return 0;
        }

        int n = citations.length;
        int[] buckets = new int[n + 1];

        for (int citation : citations) {
            if (citation >= n) {
                buckets[n]++;
            } else {
                buckets[citation]++;
            }
        }

        int totalPapers = 0;

        for (int i = n; i >= 0; i--) {
            totalPapers += buckets[i];
            if (totalPapers >= i) {
                return i;
            }
        }

        return 0;
    }

    public static void main(String[] args) {

        HIndex solution = new HIndex();

        int[] citations1 = {3, 0, 6, 1, 5};
        System.out.println("H-Index: " + solution.hIndex(citations1));

        int[] citations2 = {1, 3, 1};
        System.out.println("H-Index: " + solution.hIndex(citations2));

        int[] citations3 = {11, 15};
        System.out.println("H-Index: " + solution.hIndex(citations3));
    }
}