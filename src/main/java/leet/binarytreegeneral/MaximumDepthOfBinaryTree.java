package leet.binarytreegeneral;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumDepthOfBinaryTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static int maxDepthDFS(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(maxDepthDFS(root.left), maxDepthDFS(root.right));
    }

    public static int maxDepthBFS(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            depth++;

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }
        return depth;
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
}
