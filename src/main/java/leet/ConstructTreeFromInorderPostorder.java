package leet;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class ConstructTreeFromInorderPostorder {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    private static int postorderIndex;
    private static Map<Integer, Integer> inorderIndexMap;

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        postorderIndex = postorder.length - 1;
        inorderIndexMap = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }

        return build(inorder, postorder, 0, inorder.length - 1);
    }

    private static TreeNode build(int[] inorder, int[] postorder, int left, int right) {
        if (left > right) return null;

        int rootVal = postorder[postorderIndex--];
        TreeNode root = new TreeNode(rootVal);

        int inorderIndex = inorderIndexMap.get(rootVal);

        root.right = build(inorder, postorder, inorderIndex + 1, right);
        root.left = build(inorder, postorder, left, inorderIndex - 1);

        return root;
    }

    public static void printLevelOrder(TreeNode root) {
        if (root == null) {
            System.out.println("empty tree");
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.val + " ");

            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }
        System.out.println();
    }

    public static void main(String[] args) {

        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};

        TreeNode root = buildTree(inorder, postorder);

        System.out.print("Level order: ");
        printLevelOrder(root);
    }
}
