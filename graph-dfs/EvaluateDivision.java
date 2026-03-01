/**
 * LeetCode Problem: 399. Evaluate Division
 *
 * Time Complexity: O(Q × (V + E))
 * Space Complexity: O(V + E)
 *
 * Core Idea:
 * 1. Build weighted graph from equations.
 * 2. For each query, run BFS/DFS.
 * 3. Multiply edge weights along traversal path.
 */
import java.util.*;

public class EvaluateDivision {

    public static double[] calcEquation(
            List<List<String>> equations,
            double[] values,
            List<List<String>> queries) {

        Map<String, Map<String, Double>> graph = buildGraph(equations, values);
        double[] result = new double[queries.size()];

        for (int i = 0; i < queries.size(); i++) {
            String start = queries.get(i).get(0);
            String end = queries.get(i).get(1);
            result[i] = evaluate(graph, start, end);
        }

        return result;
    }

    private static Map<String, Map<String, Double>> buildGraph(
            List<List<String>> equations,
            double[] values) {

        Map<String, Map<String, Double>> graph = new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            double value = values[i];

            graph.putIfAbsent(a, new HashMap<>());
            graph.putIfAbsent(b, new HashMap<>());

            graph.get(a).put(b, value);
            graph.get(b).put(a, 1.0 / value);
        }

        return graph;
    }

    private static double evaluate(
            Map<String, Map<String, Double>> graph,
            String start,
            String end) {

        if (!graph.containsKey(start) || !graph.containsKey(end)) {
            return -1.0;
        }

        if (start.equals(end)) {
            return 1.0;
        }

        Queue<String> queue = new ArrayDeque<>();
        Queue<Double> values = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();

        queue.offer(start);
        values.offer(1.0);
        visited.add(start);

        while (!queue.isEmpty()) {

            String curr = queue.poll();
            double currValue = values.poll();

            for (Map.Entry<String, Double> entry : graph.get(curr).entrySet()) {

                String neighbor = entry.getKey();
                double weight = entry.getValue();

                if (visited.contains(neighbor)) continue;

                double newValue = currValue * weight;

                if (neighbor.equals(end)) {
                    return newValue;
                }

                visited.add(neighbor);
                queue.offer(neighbor);
                values.offer(newValue);
            }
        }

        return -1.0;
    }
}