package leet.binarytreegeneral;

import java.util.LinkedList;
import java.util.Queue;

public class SumRootToLeafNumbers {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static int sumNumbers(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> valueQueue = new LinkedList<>();

        nodeQueue.offer(root);
        valueQueue.offer(root.val);

        int totalSum = 0;

        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            int currentNumber = valueQueue.poll();

            if (node.left == null && node.right == null) {
                totalSum += currentNumber;
            }

            if (node.left != null) {
                nodeQueue.offer(node.left);
                valueQueue.offer(currentNumber * 10 + node.left.val);
            }

            if (node.right != null) {
                nodeQueue.offer(node.right);
                valueQueue.offer(currentNumber * 10 + node.right.val);
            }
        }

        return totalSum;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        System.out.println("Sum of root-to-leaf numbers: " + sumNumbers(root));
    }
}
