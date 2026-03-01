/**
 * LeetCode Problem: 530. Minimum Absolute Difference in BST
 *
 * Time Complexity: O(n)
 * Space Complexity: O(h)
 *
 * Core Idea:
 * 1. In-order traversal of BST gives sorted values.
 * 2. Minimum difference must be between adjacent nodes.
 * 3. Track previous value during traversal.
 */
import java.util.ArrayDeque;
import java.util.Deque;

public class MinimumAbsoluteDifferenceBST {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static int getMinimumDifference(TreeNode root) {

        if (root == null) {
            return 0;
        }

        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode curr = root;

        Integer prev = null;
        int minDiff = Integer.MAX_VALUE;

        while (curr != null || !stack.isEmpty()) {

            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();

            if (prev != null) {
                minDiff = Math.min(minDiff, curr.val - prev);
            }

            prev = curr.val;

            curr = curr.right;
        }

        return minDiff;
    }
}