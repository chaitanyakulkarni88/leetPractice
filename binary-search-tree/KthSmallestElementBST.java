/**
 * LeetCode Problem: 230. Kth Smallest Element in a BST
 *
 * Time Complexity: O(h + k) worst-case O(n)
 * Space Complexity: O(h)
 *
 * Core Idea:
 * 1. In-order traversal of BST yields sorted order.
 * 2. Stop when the kth node is visited.
 */
import java.util.ArrayDeque;
import java.util.Deque;

public class KthSmallestElementBST {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static int kthSmallest(TreeNode root, int k) {

        if (root == null || k <= 0) {
            return -1;
        }

        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) {

            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            k--;

            if (k == 0) {
                return curr.val;
            }

            curr = curr.right;
        }

        return -1;
    }
}