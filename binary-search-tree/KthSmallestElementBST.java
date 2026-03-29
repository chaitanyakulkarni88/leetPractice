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

    public static void main(String[] args) {

        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(4);
        root1.left.right = new TreeNode(2);

        int k1 = 2;
        System.out.println("Test Case 1 (Expected 2): "
                + kthSmallest(root1, k1));


        TreeNode root2 = new TreeNode(5);
        root2.left = new TreeNode(3);
        root2.right = new TreeNode(6);
        root2.left.left = new TreeNode(2);
        root2.left.right = new TreeNode(4);
        root2.left.left.left = new TreeNode(1);

        int k2 = 3;
        System.out.println("Test Case 2 (Expected 3): "
                + kthSmallest(root2, k2));
    }
}