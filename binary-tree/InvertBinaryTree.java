/**
 * LeetCode Problem: 226. Invert Binary Tree
 *
 * Time Complexity: O(n)
 * Space Complexity:
 *   DFS -> O(h)
 *   BFS -> O(w)
 *
 * Core Idea:
 * 1. Swap left and right child of every node.
 * 2. Traverse using DFS (recursive) or BFS (iterative).
 */
import java.util.ArrayDeque;
import java.util.Queue;

public class InvertBinaryTree {

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

        System.out.print("Original (Test 1): ");
        printLevelOrder(root1);

        invertTreeDFS(root1);

        System.out.print("Inverted (DFS): ");
        printLevelOrder(root1);

        invertTreeBFS(root1);

        System.out.print("Inverted Back (BFS): ");
        printLevelOrder(root1);


        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.left.left = new TreeNode(3);

        System.out.print("\nOriginal (Test 2): ");
        printLevelOrder(root2);

        invertTreeDFS(root2);

        System.out.print("Inverted (DFS): ");
        printLevelOrder(root2);
    }

    // Recursive DFS
    public static TreeNode invertTreeDFS(TreeNode root) {
        if (root == null) {
            return null;
        }

        // swap
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTreeDFS(root.left);
        invertTreeDFS(root.right);

        return root;
    }

    // Iterative BFS
    public static TreeNode invertTreeBFS(TreeNode root) {
        if (root == null) {
            return null;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            TreeNode node = queue.poll();

            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;

            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }

        return root;
    }

    private static TreeNode buildSampleTree() {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);
        return root;
    }

    private static void printLevelOrder(TreeNode root) {
        if (root == null) {
            System.out.println("empty tree");
            return;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.val + " ");

            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }
        System.out.println();
    }
}