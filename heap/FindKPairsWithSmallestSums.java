import java.util.*;

public class FindKPairsWithSmallestSums {

    /*
     * LeetCode Problem: 373 - Find K Pairs with Smallest Sums
     *
     * Time Complexity  : O(k log min(n, k))
     * Space Complexity : O(min(n, k))
     *
     * Core Idea:
     * 1. Use a min-heap storing (i, j) indices.
     * 2. Initially push pairs (i, 0) for i in [0..min(n, k)).
     * 3. Extract smallest pair.
     * 4. Push next pair from same row: (i, j + 1).
     * 5. Repeat k times.
     *
     * Algorithm Pattern: Heap / Best-First Search
     */

    static class Pair {
        int index1;
        int index2;

        Pair(int index1, int index2) {
            this.index1 = index1;
            this.index2 = index2;
        }
    }

    public static List<List<Integer>> kSmallestPairs(int[] nums1,
                                                     int[] nums2,
                                                     int k) {

        List<List<Integer>> result = new ArrayList<>();

        if (nums1 == null || nums2 == null ||
                nums1.length == 0 || nums2.length == 0 || k <= 0) {
            return result;
        }

        PriorityQueue<Pair> minHeap =
                new PriorityQueue<>(
                        Comparator.comparingInt(p ->
                                nums1[p.index1] + nums2[p.index2])
                );

        int limit = Math.min(nums1.length, k);

        for (int i = 0; i < limit; i++) {
            minHeap.offer(new Pair(i, 0));
        }

        while (k > 0 && !minHeap.isEmpty()) {

            Pair current = minHeap.poll();

            result.add(Arrays.asList(
                    nums1[current.index1],
                    nums2[current.index2]
            ));

            if (current.index2 + 1 < nums2.length) {
                minHeap.offer(new Pair(
                        current.index1,
                        current.index2 + 1
                ));
            }

            k--;
        }

        return result;
    }

    public static void main(String[] args) {

        int[] nums1 = {1, 7, 11};
        int[] nums2 = {2, 4, 6};
        int k = 3;

        System.out.println("Result: " +
                kSmallestPairs(nums1, nums2, k));

        int[] nums3 = {1, 1, 2};
        int[] nums4 = {1, 2, 3};
        int k2 = 2;

        System.out.println("Result: " +
                kSmallestPairs(nums3, nums4, k2));
    }
}