import java.util.*;

public class ConstructQuadTree {

    /*
     * LeetCode Problem: 427 - Construct Quad Tree
     *
     * Time Complexity  : O(n^2 log n) worst-case
     * Space Complexity : O(log n) recursion stack
     *
     * Core Idea:
     * 1. Recursively divide the grid into four quadrants.
     * 2. If all values in current region are same → create leaf node.
     * 3. Otherwise, split into 4 sub-grids.
     * 4. Combine results into a parent node.
     *
     * Algorithm Pattern: Divide and Conquer
     */

    static class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;

        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
        }
    }

    public static Node construct(int[][] grid) {

        if (grid == null || grid.length == 0) {
            return null;
        }

        return build(grid, 0, 0, grid.length);
    }

    private static Node build(int[][] grid, int row, int col, int size) {

        if (isUniform(grid, row, col, size)) {
            return new Node(grid[row][col] == 1, true);
        }

        int half = size / 2;

        Node node = new Node(true, false);

        node.topLeft = build(grid, row, col, half);
        node.topRight = build(grid, row, col + half, half);
        node.bottomLeft = build(grid, row + half, col, half);
        node.bottomRight = build(grid, row + half, col + half, half);

        return node;
    }

    private static boolean isUniform(int[][] grid, int row, int col, int size) {

        int value = grid[row][col];

        for (int r = row; r < row + size; r++) {
            for (int c = col; c < col + size; c++) {
                if (grid[r][c] != value) {
                    return false;
                }
            }
        }

        return true;
    }

    private static void printQuadTree(Node node, String indent) {

        if (node == null) {
            return;
        }

        if (node.isLeaf) {
            System.out.println(indent + "Leaf: " + node.val);
        } else {
            System.out.println(indent + "Internal Node");
            printQuadTree(node.topLeft, indent + "  ");
            printQuadTree(node.topRight, indent + "  ");
            printQuadTree(node.bottomLeft, indent + "  ");
            printQuadTree(node.bottomRight, indent + "  ");
        }
    }

    public static void main(String[] args) {

        int[][] grid = {
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {0, 0, 1, 1},
                {0, 0, 1, 1}
        };

        Node root = construct(grid);

        System.out.println("Quad Tree Structure:");
        printQuadTree(root, "");
    }
}