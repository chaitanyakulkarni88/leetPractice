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

    public static void main(String[] args) {

        TreeNode root1 = buildTree();

        TreeNode p1 = root1.left;      // 5
        TreeNode q1 = root1.right;     // 1

        TreeNode lca1 = lowestCommonAncestor(root1, p1, q1);
        System.out.println("Test Case 1 LCA (Expected 3): " + lca1.val);


        TreeNode p2 = root1.left;          // 5
        TreeNode q2 = root1.left.right.right; // 4

        TreeNode lca2 = lowestCommonAncestor(root1, p2, q2);
        System.out.println("Test Case 2 LCA (Expected 5): " + lca2.val);
    }

    private static TreeNode buildTree() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);

        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        return root;
    }
}