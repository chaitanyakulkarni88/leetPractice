/**
 * LeetCode Problem: 19. Remove Nth Node From End of List
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 * Core Idea:
 * 1. Use two pointers with gap of n nodes.
 * 2. Move both until fast reaches end.
 * 3. Slow will be at node before target.
 * 4. Remove target node.
 */
public class RemoveNthNodeFromEnd {

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {

        ListNode head = buildList(new int[]{1, 2, 3, 4, 5});

        head = removeNthFromEnd(head, 2);

        printList(head);
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {

        if (head == null || n <= 0) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode fast = dummy;
        ListNode slow = dummy;

        // Move fast n+1 steps ahead
        for (int i = 0; i <= n; i++) {
            if (fast == null) {
                throw new IllegalArgumentException("n is larger than list length.");
            }
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return dummy.next;
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