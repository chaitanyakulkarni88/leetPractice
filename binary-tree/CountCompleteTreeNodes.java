/**
 * LeetCode Problem: 222. Count Complete Tree Nodes
 *
 * Time Complexity: O((log n)^2)
 * Space Complexity: O(log n)
 *
 * Core Idea:
 * 1. Compute leftmost height and rightmost height.
 * 2. If equal → tree is perfect → use formula (2^h - 1).
 * 3. Otherwise recursively count left and right.
 */
public class CountCompleteTreeNodes {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static int countNodes(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int leftHeight = getLeftHeight(root);
        int rightHeight = getRightHeight(root);

        if (leftHeight == rightHeight) {
            return (1 << leftHeight) - 1;
        }

        return 1 + countNodes(root.left)
                + countNodes(root.right);
    }

    private static int getLeftHeight(TreeNode node) {
        int height = 0;
        while (node != null) {
            height++;
            node = node.left;
        }
        return height;
    }

    private static int getRightHeight(TreeNode node) {
        int height = 0;
        while (node != null) {
            height++;
            node = node.right;
        }
        return height;
    }
}