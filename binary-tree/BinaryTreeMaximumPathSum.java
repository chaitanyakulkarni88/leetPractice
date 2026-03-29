/**
 * LeetCode Problem: 124. Binary Tree Maximum Path Sum
 *
 * Time Complexity: O(n)
 * Space Complexity: O(h)
 *
 * Core Idea:
 * 1. Post-order traversal.
 * 2. For each node:
 *      - Compute max gain from left and right (ignore negatives).
 *      - Update global maximum using node as highest point.
 *      - Return max single-branch gain to parent.
 */
public class BinaryTreeMaximumPathSum {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    private static int maxSum;

    public static int maxPathSum(TreeNode root) {

        maxSum = Integer.MIN_VALUE;
        maxGain(root);

        return maxSum;
    }

    private static int maxGain(TreeNode node) {

        if (node == null) {
            return 0;
        }

        int leftGain = Math.max(maxGain(node.left), 0);
        int rightGain = Math.max(maxGain(node.right), 0);

        int currentPathSum = node.val + leftGain + rightGain;

        maxSum = Math.max(maxSum, currentPathSum);

        return node.val + Math.max(leftGain, rightGain);
    }

    public static void main(String[] args) {

        TreeNode root1 = new TreeNode(-10);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(20);
        root1.right.left = new TreeNode(15);
        root1.right.right = new TreeNode(7);

        System.out.println("Test Case 1 (Expected 42): " + maxPathSum(root1));

        TreeNode root2 = new TreeNode(2);
        root2.left = new TreeNode(-1);
        root2.right = new TreeNode(3);

        System.out.println("Test Case 2 (Expected 5): " + maxPathSum(root2));
    }
}