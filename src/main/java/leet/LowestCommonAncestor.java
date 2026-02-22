package leet;

import java.util.*;

public class LowestCommonAncestor {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();

        parentMap.put(root, null);
        queue.offer(root);

        while (!parentMap.containsKey(p) || !parentMap.containsKey(q)) {
            TreeNode node = queue.poll();

            if (node.left != null) {
                parentMap.put(node.left, node);
                queue.offer(node.left);
            }

            if (node.right != null) {
                parentMap.put(node.right, node);
                queue.offer(node.right);
            }
        }

        Set<TreeNode> ancestors = new HashSet<>();
        while (p != null) {
            ancestors.add(p);
            p = parentMap.get(p);
        }

        while (!ancestors.contains(q)) {
            q = parentMap.get(q);
        }

        return q;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        TreeNode p = root.left;
        TreeNode q = root.left.right.right;

        TreeNode lca = lowestCommonAncestor(root, p, q);

        System.out.println("LCA: " + lca.val);
    }
}
