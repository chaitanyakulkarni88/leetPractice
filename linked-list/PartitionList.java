/**
 * LeetCode Problem: 86. Partition List
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 * Core Idea:
 * 1. Use two dummy lists:
 *      - One for nodes < x
 *      - One for nodes >= x
 * 2. Append nodes accordingly while preserving order.
 * 3. Connect the two lists at the end.
 */
public class PartitionList {

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {

        ListNode head = buildList(new int[]{1, 4, 3, 2, 5, 2});

        head = partition(head, 3);

        printList(head);
    }

    public static ListNode partition(ListNode head, int x) {

        if (head == null) {
            return null;
        }

        ListNode beforeDummy = new ListNode(0);
        ListNode afterDummy = new ListNode(0);

        ListNode before = beforeDummy;
        ListNode after = afterDummy;

        while (head != null) {

            if (head.val < x) {
                before.next = head;
                before = before.next;
            } else {
                after.next = head;
                after = after.next;
            }

            head = head.next;
        }

        after.next = null; // Prevent cycle
        before.next = afterDummy.next;

        return beforeDummy.next;
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