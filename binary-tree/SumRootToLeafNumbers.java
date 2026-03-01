/**
 * LeetCode Problem: 129. Sum Root to Leaf Numbers
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n) for BFS
 *
 * Core Idea:
 * 1. Traverse tree.
 * 2. Maintain number formed along path.
 * 3. At leaf, add number to total sum.
 */
import java.util.ArrayDeque;
import java.util.Queue;

public class SumRootToLeafNumbers {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static int sumNumbers(TreeNode root) {

        if (root == null) {
            return 0;
        }

        Queue<TreeNode> nodeQueue = new ArrayDeque<>();
        Queue<Integer> valueQueue = new ArrayDeque<>();

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
}