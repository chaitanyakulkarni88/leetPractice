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

    public static void main(String[] args) {

        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(20);
        root1.right.left = new TreeNode(15);
        root1.right.right = new TreeNode(7);

        System.out.println("Test Case 1 (Expected [3.0, 14.5, 11.0]): "
                + averageOfLevels(root1));

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);
        root2.left.left = new TreeNode(4);
        root2.right.right = new TreeNode(5);

        System.out.println("Test Case 2 (Expected [1.0, 2.5, 4.5]): "
                + averageOfLevels(root2));
    }
}