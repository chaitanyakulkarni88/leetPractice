package leet.binarytreegeneral;

import java.util.Stack;

public class FlattenBinaryTreeToLinkedList {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void flatten(TreeNode root) {
        if (root == null) return;

        Stack<TreeNode> stack = new Stack<>();
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

    public static void printRightChain(TreeNode root) {
        while (root != null) {
            System.out.print(root.val);
            if (root.right != null) System.out.print(" -> ");
            root = root.right;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);

        flatten(root);

        System.out.print("Flattened: ");
        printRightChain(root);
    }
}
