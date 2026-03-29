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

    public static void main(String[] args) {

        TreeNode root1 = new TreeNode(2);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(3);

        System.out.println("Test Case 1 (Expected true): "
                + isValidBST(root1));

        TreeNode root2 = new TreeNode(5);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(4);
        root2.right.left = new TreeNode(3);
        root2.right.right = new TreeNode(6);

        System.out.println("Test Case 2 (Expected false): "
                + isValidBST(root2));
    }
}