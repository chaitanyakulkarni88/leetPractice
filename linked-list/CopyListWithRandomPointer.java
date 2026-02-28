/**
 * LeetCode Problem: 138. Copy List with Random Pointer
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 * Core Idea:
 * 1. Interleave copied nodes with original nodes.
 * 2. Assign random pointers using original node references.
 * 3. Separate the two lists.
 */
public class CopyListWithRandomPointer {

    private static class Node {
        int val;
        Node next;
        Node random;

        Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {

        Node n1 = new Node(7);
        Node n2 = new Node(13);
        Node n3 = new Node(11);
        Node n4 = new Node(10);
        Node n5 = new Node(1);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        n2.random = n1;
        n3.random = n5;
        n4.random = n3;
        n5.random = n1;

        Node copied = copyRandomList(n1);
    }

    public static Node copyRandomList(Node head) {

        if (head == null) {
            return null;
        }

        // Step 1: Interleave copied nodes
        Node current = head;

        while (current != null) {
            Node copy = new Node(current.val);
            copy.next = current.next;
            current.next = copy;
            current = copy.next;
        }

        // Step 2: Assign random pointers
        current = head;

        while (current != null) {
            if (current.random != null) {
                current.next.random = current.random.next;
            }
            current = current.next.next;
        }

        // Step 3: Separate original and copied lists
        current = head;
        Node dummy = new Node(0);
        Node copyCurrent = dummy;

        while (current != null) {
            Node copiedNode = current.next;

            copyCurrent.next = copiedNode;
            copyCurrent = copyCurrent.next;

            current.next = copiedNode.next;
            current = current.next;
        }

        return dummy.next;
    }
}