/**
 * LeetCode Problem: 101. Symmetric Tree
 *
 * Time Complexity: O(n)
 * Space Complexity:
 *   DFS -> O(h)
 *   BFS -> O(n)
 *
 * Core Idea:
 * 1. A tree is symmetric if left subtree is mirror of right subtree.
 * 2. For mirror:
 *      - Values must match.
 *      - Left.left == Right.right
 *      - Left.right == Right.left
 */
import java.util.ArrayDeque;
import java.util.Queue;

public class SymmetricTree {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {

        TreeNode root = buildSymmetricTree();

        System.out.println("Symmetric (DFS): " + isSymmetricDFS(root));
        System.out.println("Symmetric (BFS): " + isSymmetricBFS(root));
    }

    // Recursive DFS
    public static boolean isSymmetricDFS(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isMirror(root.left, root.right);
    }

    private static boolean isMirror(TreeNode t1, TreeNode t2) {

        if (t1 == null && t2 == null) {
            return true;
        }

        if (t1 == null || t2 == null || t1.val != t2.val) {
            return false;
        }

        return isMirror(t1.left, t2.right)
                && isMirror(t1.right, t2.left);
    }

    // Iterative BFS
    public static boolean isSymmetricBFS(TreeNode root) {

        if (root == null) {
            return true;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root.left);
        queue.offer(root.right);

        while (!queue.isEmpty()) {

            TreeNode t1 = queue.poll();
            TreeNode t2 = queue.poll();

            if (t1 == null && t2 == null) {
                continue;
            }

            if (t1 == null || t2 == null || t1.val != t2.val) {
                return false;
            }

            queue.offer(t1.left);
            queue.offer(t2.right);
            queue.offer(t1.right);
            queue.offer(t2.left);
        }

        return true;
    }

    private static TreeNode buildSymmetricTree() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);
        return root;
    }
}