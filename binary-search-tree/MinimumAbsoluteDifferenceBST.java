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

    public static void main(String[] args) {

        TreeNode root1 = new TreeNode(4);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(6);
        root1.left.left = new TreeNode(1);
        root1.left.right = new TreeNode(3);

        System.out.println("Test Case 1 (Expected 1): "
                + getMinimumDifference(root1));

        TreeNode root2 = new TreeNode(1);
        root2.right = new TreeNode(3);
        root2.right.left = new TreeNode(2);

        System.out.println("Test Case 2 (Expected 1): "
                + getMinimumDifference(root2));
    }
}