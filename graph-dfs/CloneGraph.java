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
}