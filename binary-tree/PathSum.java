/**
 * LeetCode Problem: 112. Path Sum
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n) for BFS
 *
 * Core Idea:
 * 1. Traverse tree level-by-level.
 * 2. Maintain running sum for each path.
 * 3. If leaf node and sum equals target → return true.
 */
import java.util.ArrayDeque;
import java.util.Queue;

public class PathSum {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static boolean hasPathSumBFS(TreeNode root, int targetSum) {

        if (root == null) {
            return false;
        }

        Queue<TreeNode> nodeQueue = new ArrayDeque<>();
        Queue<Integer> sumQueue = new ArrayDeque<>();

        nodeQueue.offer(root);
        sumQueue.offer(root.val);

        while (!nodeQueue.isEmpty()) {

            TreeNode node = nodeQueue.poll();
            int currSum = sumQueue.poll();

            if (node.left == null && node.right == null) {
                if (currSum == targetSum) {
                    return true;
                }
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
}