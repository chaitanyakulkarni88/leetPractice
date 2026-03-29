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

    public static void main(String[] args) {

        TreeNode root1 = new TreeNode(7);
        root1.left = new TreeNode(3);
        root1.right = new TreeNode(15);
        root1.right.left = new TreeNode(9);
        root1.right.right = new TreeNode(20);

        BSTIterator iterator1 = new BSTIterator(root1);

        System.out.print("Test Case 1 (Inorder): ");
        while (iterator1.hasNext()) {
            System.out.print(iterator1.next() + " ");
        }
        System.out.println(); // Expected: 3 7 9 15 20

        TreeNode root2 = new TreeNode(2);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(3);

        BSTIterator iterator2 = new BSTIterator(root2);

        System.out.print("Test Case 2 (Inorder): ");
        while (iterator2.hasNext()) {
            System.out.print(iterator2.next() + " ");
        }
        System.out.println(); // Expected: 1 2 3
    }
}