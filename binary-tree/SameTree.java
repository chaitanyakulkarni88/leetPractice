/**
 * LeetCode Problem: 100. Same Tree
 *
 * Time Complexity: O(n)
 * Space Complexity:
 *   DFS -> O(h)
 *   BFS -> O(n)
 *
 * Core Idea:
 * 1. Trees are same if:
 *    - Both nodes are null.
 *    - Both nodes are non-null AND values equal.
 *    - Left subtrees are same AND right subtrees are same.
 */
import java.util.ArrayDeque;
import java.util.Queue;

public class SameTree {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {

        TreeNode p1 = new TreeNode(1);
        p1.left = new TreeNode(2);
        p1.right = new TreeNode(3);

        TreeNode q1 = new TreeNode(1);
        q1.left = new TreeNode(2);
        q1.right = new TreeNode(3);

        System.out.println("Same (DFS): " + isSameTreeDFS(p1, q1));
        System.out.println("Same (BFS): " + isSameTreeBFS(p1, q1));
    }

    // Recursive DFS
    public static boolean isSameTreeDFS(TreeNode p, TreeNode q) {

        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null || p.val != q.val) {
            return false;
        }

        return isSameTreeDFS(p.left, q.left)
                && isSameTreeDFS(p.right, q.right);
    }

    // Iterative BFS
    public static boolean isSameTreeBFS(TreeNode p, TreeNode q) {

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(p);
        queue.offer(q);

        while (!queue.isEmpty()) {

            TreeNode n1 = queue.poll();
            TreeNode n2 = queue.poll();

            if (n1 == null && n2 == null) {
                continue;
            }

            if (n1 == null || n2 == null || n1.val != n2.val) {
                return false;
            }

            queue.offer(n1.left);
            queue.offer(n2.left);
            queue.offer(n1.right);
            queue.offer(n2.right);
        }

        return true;
    }
}