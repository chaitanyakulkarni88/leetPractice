package leet.binarytreegeneral;

import java.util.LinkedList;
import java.util.Queue;

public class SameTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;

        if (p == null || q == null || p.val != q.val) return false;

        return isSameTree(p.left, q.left) &&
                isSameTree(p.right, q.right);
    }

    public static boolean isSameTreeBFS(TreeNode p, TreeNode q) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(p);
        queue.offer(q);

        while (!queue.isEmpty()) {
            TreeNode n1 = queue.poll();
            TreeNode n2 = queue.poll();

            if (n1 == null && n2 == null) continue;
            if (n1 == null || n2 == null || n1.val != n2.val) return false;

            queue.offer(n1.left);
            queue.offer(n2.left);
            queue.offer(n1.right);
            queue.offer(n2.right);
        }
        return true;
    }

    public static void main(String[] args) {

        TreeNode p1 = new TreeNode(1);
        p1.left = new TreeNode(2);
        p1.right = new TreeNode(3);

        TreeNode q1 = new TreeNode(1);
        q1.left = new TreeNode(2);
        q1.right = new TreeNode(3);

        System.out.println("Same (DFS): " + isSameTree(p1, q1));
        System.out.println("Same (BFS): " + isSameTreeBFS(p1, q1));

        TreeNode p2 = new TreeNode(1);
        p2.left = new TreeNode(2);

        TreeNode q2 = new TreeNode(1);
        q2.right = new TreeNode(2);

        System.out.println("\nSame (DFS): " + isSameTree(p2, q2));
        System.out.println("Same (BFS): " + isSameTreeBFS(p2, q2));
    }
}
