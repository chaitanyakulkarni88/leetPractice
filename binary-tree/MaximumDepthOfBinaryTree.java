/**
 * LeetCode Problem: 104. Maximum Depth of Binary Tree
 *
 * Time Complexity: O(n)
 * Space Complexity:
 *   DFS -> O(h)
 *   BFS -> O(w)
 *
 * Core Idea:
 * 1. DFS: Depth = 1 + max(leftDepth, rightDepth).
 * 2. BFS: Count levels using queue (level-order traversal).
 */
import java.util.ArrayDeque;
import java.util.Queue;

public class MaximumDepthOfBinaryTree {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println("Max Depth (DFS): " + maxDepthDFS(root));
        System.out.println("Max Depth (BFS): " + maxDepthBFS(root));
    }

    // Recursive DFS
    public static int maxDepthDFS(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = maxDepthDFS(root.left);
        int rightDepth = maxDepthDFS(root.right);

        return 1 + Math.max(leftDepth, rightDepth);
    }

    // Iterative BFS
    public static int maxDepthBFS(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        int depth = 0;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            depth++;

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }

        return depth;
    }
}