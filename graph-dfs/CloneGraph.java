/**
 * LeetCode Problem: 133. Clone Graph
 *
 * Time Complexity: O(V + E)
 * Space Complexity: O(V)
 *
 * Core Idea:
 * 1. Use BFS/DFS traversal.
 * 2. Maintain map from original node → cloned node.
 * 3. Clone nodes lazily when first seen.
 * 4. Connect cloned neighbors accordingly.
 */
import java.util.*;

public class CloneGraph {

    private static class Node {
        int val;
        List<Node> neighbors;

        Node(int val) {
            this.val = val;
            this.neighbors = new ArrayList<>();
        }
    }

    public static Node cloneGraph(Node node) {

        if (node == null) {
            return null;
        }

        Map<Node, Node> visited = new HashMap<>();
        Queue<Node> queue = new ArrayDeque<>();

        Node clonedRoot = new Node(node.val);
        visited.put(node, clonedRoot);
        queue.offer(node);

        while (!queue.isEmpty()) {

            Node curr = queue.poll();

            for (Node neighbor : curr.neighbors) {

                if (!visited.containsKey(neighbor)) {
                    visited.put(neighbor, new Node(neighbor.val));
                    queue.offer(neighbor);
                }

                visited.get(curr).neighbors.add(visited.get(neighbor));
            }
        }

        return clonedRoot;
    }

    private static void printGraph(Node node) {
        if (node == null) return;

        Set<Node> visited = new HashSet<>();
        Queue<Node> queue = new ArrayDeque<>();

        queue.offer(node);
        visited.add(node);

        while (!queue.isEmpty()) {
            Node curr = queue.poll();

            System.out.print("Node " + curr.val + " -> ");
            for (Node neighbor : curr.neighbors) {
                System.out.print(neighbor.val + " ");
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.offer(neighbor);
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.neighbors.add(node2);
        node1.neighbors.add(node4);

        node2.neighbors.add(node1);
        node2.neighbors.add(node3);

        node3.neighbors.add(node2);
        node3.neighbors.add(node4);

        node4.neighbors.add(node1);
        node4.neighbors.add(node3);

        System.out.println("Original Graph (Test Case 1):");
        printGraph(node1);

        Node cloned1 = cloneGraph(node1);

        System.out.println("Cloned Graph (Test Case 1):");
        printGraph(cloned1);


        Node single = new Node(10);

        System.out.println("Original Graph (Test Case 2):");
        printGraph(single);

        Node cloned2 = cloneGraph(single);

        System.out.println("Cloned Graph (Test Case 2):");
        printGraph(cloned2);
    }
}