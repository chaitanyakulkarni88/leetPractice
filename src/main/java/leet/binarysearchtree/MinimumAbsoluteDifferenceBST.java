package leet.binarysearchtree;

import java.util.Stack;

public class MinimumAbsoluteDifferenceBST {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static int getMinimumDifference(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        Integer prev = null;
        int minDiff = Integer.MAX_VALUE;

        while (curr != null || !stack.isEmpty()) {

            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();

            if (prev != null) {
                minDiff = Math.min(minDiff, curr.val - prev);
            }

            prev = curr.val;

            curr = curr.right;
        }

        return minDiff;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        System.out.println("Minimum Absolute Difference: " + getMinimumDifference(root));
    }
}
