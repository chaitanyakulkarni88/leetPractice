/**
 * LeetCode Problem: 106. Construct Binary Tree from Inorder and Postorder
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 *
 * Core Idea:
 * 1. Postorder's last element is root.
 * 2. Inorder splits left and right subtrees.
 * 3. Build right subtree first (since postorder moves backward).
 * 4. Use HashMap for O(1) inorder index lookup.
 */
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class ConstructTreeFromInorderPostorder {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    private static int postorderIndex;
    private static Map<Integer, Integer> inorderIndexMap;

    public static void main(String[] args) {

        int[] inorder1 = {9, 3, 15, 20, 7};
        int[] postorder1 = {9, 15, 7, 20, 3};

        TreeNode root1 = buildTree(inorder1, postorder1);

        System.out.print("Test Case 1 (Level Order): ");
        printLevelOrder(root1); // Expected: 3 9 20 15 7


        int[] inorder2 = {2, 1, 3};
        int[] postorder2 = {2, 3, 1};

        TreeNode root2 = buildTree(inorder2, postorder2);

        System.out.print("Test Case 2 (Level Order): ");
        printLevelOrder(root2); // Expected: 1 2 3
    }

    public static TreeNode buildTree(int[] inorder, int[] postorder) {

        if (inorder == null || postorder == null
                || inorder.length != postorder.length) {
            return null;
        }

        postorderIndex = postorder.length - 1;
        inorderIndexMap = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }

        return build(postorder, 0, inorder.length - 1);
    }

    private static TreeNode build(int[] postorder, int left, int right) {

        if (left > right) {
            return null;
        }

        int rootVal = postorder[postorderIndex--];
        TreeNode root = new TreeNode(rootVal);

        int inorderIndex = inorderIndexMap.get(rootVal);

        root.right = build(postorder, inorderIndex + 1, right);
        root.left = build(postorder, left, inorderIndex - 1);

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