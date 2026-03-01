/**
 * LeetCode Problem: 98. Validate Binary Search Tree
 *
 * Time Complexity: O(n)
 * Space Complexity: O(h)
 *
 * Core Idea:
 * 1. In-order traversal of BST must produce strictly increasing sequence.
 * 2. Track previous value during traversal.
 * 3. If current value <= previous → invalid.
 */
import java.util.ArrayDeque;
import java.util.Deque;

public class ValidateBinarySearchTree {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static boolean isValidBST(TreeNode root) {

        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode curr = root;

        Long prev = null;

        while (curr != null || !stack.isEmpty()) {

            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();

            if (prev != null && curr.val <= prev) {
                return false;
            }

            prev = (long) curr.val;

            curr = curr.right;
        }

        return true;
    }
}