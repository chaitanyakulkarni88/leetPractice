package leet;

public class MergeTwoSortedLists {

    // Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    // LeetCode 21 solution
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        // Attach remaining nodes
        current.next = (list1 != null) ? list1 : list2;

        return dummyHead.next;
    }

    // Helper method to print linked list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) {
                System.out.print(" -> ");
            }
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        // ===== Test Case 1 =====
        // list1 = 1 -> 2 -> 4
        // list2 = 1 -> 3 -> 4
        // result = 1 -> 1 -> 2 -> 3 -> 4 -> 4

        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        System.out.print("list1: ");
        printList(list1);

        System.out.print("list2: ");
        printList(list2);

        ListNode merged = mergeTwoLists(list1, list2);

        System.out.print("Merged: ");
        printList(merged);


        // ===== Test Case 2 =====
        // list1 = null
        // list2 = 0

        ListNode list3 = null;
        ListNode list4 = new ListNode(0);

        System.out.print("\nlist1: ");
        printList(list3);

        System.out.print("list2: ");
        printList(list4);

        ListNode merged2 = mergeTwoLists(list3, list4);

        System.out.print("Merged: ");
        printList(merged2);


        // ===== Test Case 3 =====
        // list1 = null
        // list2 = null

        ListNode merged3 = mergeTwoLists(null, null);

        System.out.print("\nMerged (both null): ");
        printList(merged3);
    }
}
