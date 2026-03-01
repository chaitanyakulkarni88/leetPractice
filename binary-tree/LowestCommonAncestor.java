/**
 * LeetCode Problem: 236. Lowest Common Ancestor of a Binary Tree
 *
 * Time Complexity: O(n)
 * Space Complexity: O(h)
 *
 * Core Idea:
 * 1. If root is null or equals p or q → return root.
 * 2. Recursively search left and right.
 * 3. If both sides return non-null → root is LCA.
 * 4. Otherwise, return the non-null side.
 */
public class LowestCommonAncestor {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static TreeNode lowestCommonAncestor(TreeNode root,
                                                TreeNode p,
                                                TreeNode q) {

        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }

        return (left != null) ? left : right;
    }
}