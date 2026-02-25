package leet;

import java.util.*;

public class EvaluateDivision {

    public static double[] calcEquation(
            List<List<String>> equations,
            double[] values,
            List<List<String>> queries) {

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

        double[] result = new double[queries.size()];

        for (int i = 0; i < queries.size(); i++) {
            String start = queries.get(i).get(0);
            String end = queries.get(i).get(1);

            result[i] = bfs(graph, start, end);
        }

        return result;
    }

    private static double bfs(
            Map<String, Map<String, Double>> graph,
            String start,
            String end) {

        if (!graph.containsKey(start) || !graph.containsKey(end))
            return -1.0;

        if (start.equals(end))
            return 1.0;

        Queue<String> queue = new LinkedList<>();
        Queue<Double> values = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.offer(start);
        values.offer(1.0);
        visited.add(start);

        while (!queue.isEmpty()) {
            String curr = queue.poll();
            double currValue = values.poll();

            for (String neighbor : graph.get(curr).keySet()) {
                if (visited.contains(neighbor)) continue;

                double newValue = currValue * graph.get(curr).get(neighbor);

                if (neighbor.equals(end))
                    return newValue;

                visited.add(neighbor);
                queue.offer(neighbor);
                values.offer(newValue);
            }
        }

        return -1.0;
    }

    public static void main(String[] args) {

        List<List<String>> equations = Arrays.asList(
                Arrays.asList("a", "b"),
                Arrays.asList("b", "c")
        );

        double[] values = {2.0, 3.0};

        List<List<String>> queries = Arrays.asList(
                Arrays.asList("a", "c"),
                Arrays.asList("b", "a"),
                Arrays.asList("a", "e"),
                Arrays.asList("a", "a"),
                Arrays.asList("x", "x")
        );

        double[] result = calcEquation(equations, values, queries);

        System.out.println("Results:");
        for (double r : result) {
            System.out.println(r);
        }
    }
}
