/**
 * LeetCode Problem: 637. Average of Levels in Binary Tree
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 *
 * Core Idea:
 * 1. Perform level-order traversal.
 * 2. For each level, compute sum of node values.
 * 3. Add (sum / levelSize) to result.
 */
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class AverageOfLevels {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static List<Double> averageOfLevels(TreeNode root) {

        List<Double> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            int levelSize = queue.size();
            long sum = 0;

            for (int i = 0; i < levelSize; i++) {

                TreeNode node = queue.poll();
                sum += node.val;

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            result.add((double) sum / levelSize);
        }

        return result;
    }
}