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

    public static void main(String[] args) {

        TreeNode root1 = new TreeNode(5);
        root1.left = new TreeNode(4);
        root1.right = new TreeNode(8);
        root1.left.left = new TreeNode(11);
        root1.left.left.left = new TreeNode(7);
        root1.left.left.right = new TreeNode(2);
        root1.right.left = new TreeNode(13);
        root1.right.right = new TreeNode(4);
        root1.right.right.right = new TreeNode(1);

        int target1 = 22;
        System.out.println("Test Case 1 (Expected true): "
                + hasPathSumBFS(root1, target1));


        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);

        int target2 = 5;
        System.out.println("Test Case 2 (Expected false): "
                + hasPathSumBFS(root2, target2));
    }
}