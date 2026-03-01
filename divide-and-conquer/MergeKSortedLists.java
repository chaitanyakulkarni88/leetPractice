import java.util.*;

public class MergeKSortedLists {

    /*
     * LeetCode Problem: 23 - Merge k Sorted Lists
     *
     * Time Complexity  : O(n log k)
     * Space Complexity : O(k)
     *
     * n = total number of nodes
     * k = number of lists
     *
     * Core Idea:
     * 1. Insert the head of each list into a min-heap.
     * 2. Extract the smallest node and attach to result.
     * 3. Insert the extracted node's next into heap.
     * 4. Repeat until heap is empty.
     *
     * Algorithm Pattern: Heap / Priority Queue
     */

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int value) {
            this.val = value;
        }
    }

    public static ListNode mergeKLists(ListNode[] lists) {

        if (lists == null || lists.length == 0) {
            return null;
        }

        PriorityQueue<ListNode> minHeap =
                new PriorityQueue<>(Comparator.comparingInt(node -> node.val));

        for (ListNode head : lists) {
            if (head != null) {
                minHeap.offer(head);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (!minHeap.isEmpty()) {

            ListNode smallest = minHeap.poll();
            tail.next = smallest;
            tail = tail.next;

            if (smallest.next != null) {
                minHeap.offer(smallest.next);
            }
        }

        return dummy.next;
    }

    private static void printList(ListNode head) {

        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);

        ListNode[] lists = {l1, l2, l3};

        ListNode merged = mergeKLists(lists);

        System.out.println("Merged List:");
        printList(merged);
    }
}