import java.util.*;

public class ConvertSortedArrayToBST {

    /*
     * LeetCode Problem: 108 - Convert Sorted Array to Binary Search Tree
     *
     * Time Complexity  : O(n)
     * Space Complexity : O(log n)  (recursion stack)
     *
     * Core Idea:
     * 1. Choose middle element as root to maintain height balance.
     * 2. Recursively build left subtree from left half.
     * 3. Recursively build right subtree from right half.
     *
     * Algorithm Pattern: Divide and Conquer
     */

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int value) {
            this.val = value;
        }
    }

    public static TreeNode sortedArrayToBST(int[] nums) {

        if (nums == null || nums.length == 0) {
            return null;
        }

        return buildBST(nums, 0, nums.length - 1);
    }

    private static TreeNode buildBST(int[] nums, int left, int right) {

        if (left > right) {
            return null;
        }

        int mid = left + (right - left) / 2;

        TreeNode root = new TreeNode(nums[mid]);

        root.left = buildBST(nums, left, mid - 1);
        root.right = buildBST(nums, mid + 1, right);

        return root;
    }

    private static void inorderTraversal(TreeNode root) {

        if (root == null) {
            return;
        }

        inorderTraversal(root.left);
        System.out.print(root.val + " ");
        inorderTraversal(root.right);
    }

    public static void main(String[] args) {

        int[] nums = {-10, -3, 0, 5, 9};

        TreeNode root = sortedArrayToBST(nums);

        System.out.println("Inorder Traversal (Should be sorted):");
        inorderTraversal(root);
    }
}