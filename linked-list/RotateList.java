/**
 * LeetCode Problem: 61. Rotate List
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 * Core Idea:
 * 1. Compute list length and find tail.
 * 2. Connect tail to head to form circular list.
 * 3. Find new tail at position (length - k % length - 1).
 * 4. Break circle and return new head.
 */
public class RotateList {

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {

        ListNode head = buildList(new int[]{1, 2, 3, 4, 5});

        head = rotateRight(head, 2);

        printList(head);
    }

    public static ListNode rotateRight(ListNode head, int k) {

        if (head == null || head.next == null || k == 0) {
            return head;
        }

        ListNode tail = head;
        int length = 1;

        while (tail.next != null) {
            tail = tail.next;
            length++;
        }

        k %= length;

        if (k == 0) {
            return head;
        }

        tail.next = head; // Make circular

        ListNode newTail = head;

        for (int i = 0; i < length - k - 1; i++) {
            newTail = newTail.next;
        }

        ListNode newHead = newTail.next;
        newTail.next = null; // Break circle

        return newHead;
    }

    private static ListNode buildList(int[] values) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        for (int val : values) {
            current.next = new ListNode(val);
            current = current.next;
        }

        return dummy.next;
    }

    private static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) System.out.print(" -> ");
            head = head.next;
        }
        System.out.println();
    }
}