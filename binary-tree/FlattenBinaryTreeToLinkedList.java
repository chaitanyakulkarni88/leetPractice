/**
 * LeetCode Problem: 114. Flatten Binary Tree to Linked List
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 *
 * Core Idea:
 * 1. Perform preorder traversal using stack.
 * 2. Rewire pointers so:
 *      - left becomes null
 *      - right points to next preorder node.
 */
import java.util.ArrayDeque;
import java.util.Deque;

public class FlattenBinaryTreeToLinkedList {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {

        TreeNode root1 = buildSampleTree();

        System.out.print("Before (Preorder): ");
        printPreorder(root1);

        flatten(root1);

        System.out.print("After (Flattened): ");
        printRightChain(root1); // Expected: 1 -> 2 -> 3 -> 4 -> 5 -> 6


        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.left.left = new TreeNode(3);

        System.out.print("\nBefore (Preorder): ");
        printPreorder(root2);

        flatten(root2);

        System.out.print("After (Flattened): ");
        printRightChain(root2); // Expected: 1 -> 2 -> 3
    }

    public static void flatten(TreeNode root) {

        if (root == null) {
            return;
        }

        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);

        TreeNode prev = null;

        while (!stack.isEmpty()) {

            TreeNode curr = stack.pop();

            if (prev != null) {
                prev.left = null;
                prev.right = curr;
            }

            if (curr.right != null) stack.push(curr.right);
            if (curr.left != null) stack.push(curr.left);

            prev = curr;
        }
    }

    private static TreeNode buildSampleTree() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);
        return root;
    }

    private static void printPreorder(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        printPreorder(root.left);
        printPreorder(root.right);
    }

    private static void printRightChain(TreeNode root) {
        while (root != null) {
            System.out.print(root.val);
            if (root.right != null) System.out.print(" -> ");
            root = root.right;
        }
        System.out.println();
    }
}