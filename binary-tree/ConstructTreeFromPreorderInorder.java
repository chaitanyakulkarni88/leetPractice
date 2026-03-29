/**
 * LeetCode Problem: 105. Construct Binary Tree from Preorder and Inorder
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 *
 * Core Idea:
 * 1. Preorder gives root first.
 * 2. Inorder splits left and right subtrees.
 * 3. Use HashMap for O(1) index lookup.
 * 4. Recursively build left and right subtrees.
 */
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class ConstructTreeFromPreorderInorder {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    private static int preorderIndex;
    private static Map<Integer, Integer> inorderIndexMap;

    public static void main(String[] args) {

        int[] preorder1 = {3, 9, 20, 15, 7};
        int[] inorder1 = {9, 3, 15, 20, 7};

        TreeNode root1 = buildTree(preorder1, inorder1);

        System.out.print("Test Case 1 (Level Order): ");
        printLevelOrder(root1); // Expected: 3 9 20 15 7


        int[] preorder2 = {1, 2, 4, 5, 3};
        int[] inorder2 = {4, 2, 5, 1, 3};

        TreeNode root2 = buildTree(preorder2, inorder2);

        System.out.print("Test Case 2 (Level Order): ");
        printLevelOrder(root2); // Expected: 1 2 3 4 5
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {

        if (preorder == null || inorder == null
                || preorder.length != inorder.length) {
            return null;
        }

        preorderIndex = 0;
        inorderIndexMap = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }

        return build(preorder, 0, inorder.length - 1);
    }

    private static TreeNode build(int[] preorder, int left, int right) {

        if (left > right) {
            return null;
        }

        int rootVal = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootVal);

        int inorderIndex = inorderIndexMap.get(rootVal);

        root.left = build(preorder, left, inorderIndex - 1);
        root.right = build(preorder, inorderIndex + 1, right);

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