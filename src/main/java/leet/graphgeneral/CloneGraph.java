package leet.graphgeneral;

import java.util.*;

public class CloneGraph {

    static class Node {
        int val;
        List<Node> neighbors;

        Node(int val) {
            this.val = val;
            this.neighbors = new ArrayList<>();
        }
    }

    public static Node cloneGraph(Node node) {
        if (node == null) return null;

        Map<Node, Node> map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();

        Node clone = new Node(node.val);
        map.put(node, clone);
        queue.offer(node);

        while (!queue.isEmpty()) {
            Node curr = queue.poll();

            for (Node neighbor : curr.neighbors) {

                if (!map.containsKey(neighbor)) {
                    map.put(neighbor, new Node(neighbor.val));
                    queue.offer(neighbor);
                }

                map.get(curr).neighbors.add(map.get(neighbor));
            }
        }

        return clone;
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

        Node cloned = cloneGraph(node1);

        System.out.println("Original node value: " + node1.val);
        System.out.println("Cloned node value: " + cloned.val);
        System.out.println("Cloned neighbors count: " + cloned.neighbors.size());
    }
}
