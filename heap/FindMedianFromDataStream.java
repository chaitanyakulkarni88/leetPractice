import java.util.*;

public class FindMedianFromDataStream {

    /*
     * LeetCode Problem: 295 - Find Median from Data Stream
     *
     * Time Complexity  :
     *   addNum()    -> O(log n)
     *   findMedian() -> O(1)
     *
     * Space Complexity : O(n)
     *
     * Core Idea:
     * 1. Maintain two heaps:
     *      - Max-heap for lower half.
     *      - Min-heap for upper half.
     * 2. Keep sizes balanced (difference <= 1).
     * 3. Median:
     *      - If equal size → average of tops.
     *      - Else → top of max-heap.
     *
     * Algorithm Pattern: Two Heaps
     */

    static class MedianFinder {

        private final PriorityQueue<Integer> maxHeap; // lower half
        private final PriorityQueue<Integer> minHeap; // upper half

        public MedianFinder() {
            maxHeap = new PriorityQueue<>(Collections.reverseOrder());
            minHeap = new PriorityQueue<>();
        }

        public void addNum(int num) {

            if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
                maxHeap.offer(num);
            } else {
                minHeap.offer(num);
            }

            balanceHeaps();
        }

        private void balanceHeaps() {

            if (maxHeap.size() > minHeap.size() + 1) {
                minHeap.offer(maxHeap.poll());
            } else if (minHeap.size() > maxHeap.size()) {
                maxHeap.offer(minHeap.poll());
            }
        }

        public double findMedian() {

            if (maxHeap.size() == minHeap.size()) {
                return (maxHeap.peek() + minHeap.peek()) / 2.0;
            }

            return maxHeap.peek();
        }
    }

    public static void main(String[] args) {

        MedianFinder medianFinder = new MedianFinder();

        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println("Median: " + medianFinder.findMedian());

        medianFinder.addNum(3);
        System.out.println("Median: " + medianFinder.findMedian());

        medianFinder.addNum(10);
        medianFinder.addNum(-1);
        System.out.println("Median: " + medianFinder.findMedian());
    }
}