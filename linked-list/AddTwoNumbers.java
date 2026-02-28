/**
 * LeetCode Problem: 2. Add Two Numbers
 *
 * Time Complexity: O(max(m, n))
 * Space Complexity: O(max(m, n))
 *
 * Core Idea:
 * 1. Traverse both linked lists simultaneously.
 * 2. Add corresponding digits along with carry.
 * 3. Create new node for (sum % 10).
 * 4. Maintain carry = sum / 10.
 * 5. Use dummy head to simplify list construction.
 */
public class AddTwoNumbers {

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        AddTwoNumbers solution = new AddTwoNumbers();

        ListNode l1 = buildList(new int[]{2, 4, 3});
        ListNode l2 = buildList(new int[]{5, 6, 4});

        ListNode result = solution.addTwoNumbers(l1, l2);

        printList(result);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;

        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {

            int sum = carry;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            carry = sum / 10;

            current.next = new ListNode(sum % 10);
            current = current.next;
        }

        return dummyHead.next;
    }

    private static ListNode buildList(int[] values) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        for (int value : values) {
            current.next = new ListNode(value);
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