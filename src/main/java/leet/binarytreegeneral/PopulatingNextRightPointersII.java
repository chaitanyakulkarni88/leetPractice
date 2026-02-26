package leet.binarytreegeneral;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersII {

    static class Node {
        int val;
        Node left;
        Node right;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    public static Node connect(Node root) {
        if (root == null) return null;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            Node prev = null;

            for (int i = 0; i < size; i++) {
                Node curr = queue.poll();

                if (prev != null) {
                    prev.next = curr;
                }
                prev = curr;

                if (curr.left != null) queue.offer(curr.left);
                if (curr.right != null) queue.offer(curr.right);
            }

            prev.next = null;
        }

        return root;
    }

    public static void printByLevel(Node root) {
        Node levelStart = root;

        while (levelStart != null) {
            Node curr = levelStart;
            levelStart = null;

            while (curr != null) {
                System.out.print(curr.val + " -> ");
                if (levelStart == null) {
                    if (curr.left != null) levelStart = curr.left;
                    else if (curr.right != null) levelStart = curr.right;
                }
                curr = curr.next;
            }
            System.out.println("null");
        }
    }

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(7);

        System.out.println("Before connecting:");
        printByLevel(root);

        connect(root);

        System.out.println("\nAfter connecting:");
        printByLevel(root);
    }
}
