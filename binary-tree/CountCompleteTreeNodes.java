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
import java.util.LinkedList;
import java.util.Queue;

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

    public static int countNodesBFS(TreeNode root) {

        if (root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int count = 0;

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            count++;

            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }

        return count;
    }

    public static void main(String[] args) {

        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(5);
        root1.right.left = new TreeNode(6);

        System.out.println("Test Case 1 (Optimal): " + countNodes(root1));
        System.out.println("Test Case 1 (BFS): " + countNodesBFS(root1));

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);
        root2.left.left = new TreeNode(4);
        root2.left.right = new TreeNode(5);
        root2.right.left = new TreeNode(6);
        root2.right.right = new TreeNode(7);

        System.out.println("Test Case 2 (Optimal): " + countNodes(root2));
        System.out.println("Test Case 2 (BFS): " + countNodesBFS(root2));
    }
}