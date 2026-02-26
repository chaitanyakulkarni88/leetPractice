package leet.binarysearchtree;

import java.util.Stack;

public class ValidateBinarySearchTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static boolean isValidBST(TreeNode root) {

        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        Long prev = null;

        while (curr != null || !stack.isEmpty()) {

            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();

            if (prev != null && curr.val <= prev) {
                return false;
            }

            prev = (long) curr.val;

            curr = curr.right;
        }

        return true;
    }

    public static void main(String[] args) {

        TreeNode validRoot = new TreeNode(2);
        validRoot.left = new TreeNode(1);
        validRoot.right = new TreeNode(3);

        System.out.println("Valid BST: " + isValidBST(validRoot));

        TreeNode invalidRoot = new TreeNode(5);
        invalidRoot.left = new TreeNode(1);
        invalidRoot.right = new TreeNode(4);
        invalidRoot.right.left = new TreeNode(3);
        invalidRoot.right.right = new TreeNode(6);

        System.out.println("Valid BST: " + isValidBST(invalidRoot));
    }
}
