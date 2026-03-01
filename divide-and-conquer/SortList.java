import java.util.*;

public class SortList {

    /*
     * LeetCode Problem: 148 - Sort List
     *
     * Time Complexity  : O(n log n)
     * Space Complexity : O(log n) (recursion stack)
     *
     * Core Idea:
     * 1. Use merge sort since linked list lacks random access.
     * 2. Split list using slow/fast pointers.
     * 3. Recursively sort both halves.
     * 4. Merge two sorted lists.
     *
     * Algorithm Pattern: Merge Sort (Linked List)
     */

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int value) {
            this.val = value;
        }
    }

    public static ListNode sortList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode mid = getMiddle(head);
        ListNode rightHead = mid.next;
        mid.next = null;

        ListNode leftSorted = sortList(head);
        ListNode rightSorted = sortList(rightHead);

        return merge(leftSorted, rightSorted);
    }

    private static ListNode getMiddle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    private static ListNode merge(ListNode left, ListNode right) {

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (left != null && right != null) {

            if (left.val <= right.val) {
                tail.next = left;
                left = left.next;
            } else {
                tail.next = right;
                right = right.next;
            }

            tail = tail.next;
        }

        tail.next = (left != null) ? left : right;

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

        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);

        System.out.println("Original List:");
        printList(head);

        ListNode sortedHead = sortList(head);

        System.out.println("Sorted List:");
        printList(sortedHead);
    }
}