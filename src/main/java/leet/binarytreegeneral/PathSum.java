package leet.binarytreegeneral;

import java.util.LinkedList;
import java.util.Queue;

public class PathSum {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;

        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> sumQueue = new LinkedList<>();

        nodeQueue.offer(root);
        sumQueue.offer(root.val);

        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            int currSum = sumQueue.poll();

            if (node.left == null && node.right == null) {
                if (currSum == targetSum) return true;
            }

            if (node.left != null) {
                nodeQueue.offer(node.left);
                sumQueue.offer(currSum + node.left.val);
            }

            if (node.right != null) {
                nodeQueue.offer(node.right);
                sumQueue.offer(currSum + node.right.val);
            }
        }

        return false;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);

        int targetSum1 = 22;
        int targetSum2 = 26;

        System.out.println("Has path sum 22: " + hasPathSum(root, targetSum1)); // true
        System.out.println("Has path sum 26: " + hasPathSum(root, targetSum2)); // true
    }
}
