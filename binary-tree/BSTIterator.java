/**
 * LeetCode Problem: 173. Binary Search Tree Iterator
 *
 * Time Complexity:
 *   Constructor -> O(h)
 *   next()      -> Amortized O(1)
 *   hasNext()   -> O(1)
 *
 * Space Complexity: O(h)
 *
 * Core Idea:
 * 1. Simulate in-order traversal using a stack.
 * 2. Always maintain next smallest element at top of stack.
 */
import java.util.ArrayDeque;
import java.util.Deque;

public class BSTIterator {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    private final Deque<TreeNode> stack = new ArrayDeque<>();

    public BSTIterator(TreeNode root) {
        pushLeft(root);
    }

    private void pushLeft(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }

    public int next() {

        TreeNode node = stack.pop();

        if (node.right != null) {
            pushLeft(node.right);
        }

        return node.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }
}