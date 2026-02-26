package leet.linkedlist;

public class PartitionList {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public static ListNode partition(ListNode head, int x) {
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

        after.next = null;

        before.next = afterDummy.next;

        return beforeDummy.next;
    }

    public static void main(String[] args) {

        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(4);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(2);
        head1.next.next.next.next = new ListNode(5);
        head1.next.next.next.next.next = new ListNode(2);

        ListNode result = partition(head1, 3);
    }
}
