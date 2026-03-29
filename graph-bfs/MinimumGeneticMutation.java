/**
 * LeetCode Problem: 433. Minimum Genetic Mutation
 *
 * Time Complexity: O(n × L × 4)
 * Space Complexity: O(n)
 *
 * Core Idea:
 * 1. Treat each gene string as a node.
 * 2. Edge exists if one mutation away and in bank.
 * 3. Use BFS to find shortest mutation sequence.
 */
import java.util.*;

public class MinimumGeneticMutation {

    private static final char[] GENES = {'A', 'C', 'G', 'T'};

    public static int minMutation(String start, String end, String[] bank) {

        if (start.equals(end)) {
            return 0;
        }

        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));

        if (!bankSet.contains(end)) {
            return -1;
        }

        Queue<String> queue = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();

        queue.offer(start);
        visited.add(start);

        int mutations = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {

                String curr = queue.poll();

                if (curr.equals(end)) {
                    return mutations;
                }

                char[] arr = curr.toCharArray();

                for (int j = 0; j < arr.length; j++) {

                    char original = arr[j];

                    for (char gene : GENES) {

                        if (gene == original) continue;

                        arr[j] = gene;
                        String next = new String(arr);

                        if (!visited.contains(next) && bankSet.contains(next)) {
                            visited.add(next);
                            queue.offer(next);
                        }
                    }

                    arr[j] = original;
                }
            }

            mutations++;
        }

        return -1;
    }

    public static void main(String[] args) {

        String start1 = "AACCGGTT";
        String end1 = "AACCGGTA";
        String[] bank1 = {"AACCGGTA"};

        System.out.println("Test Case 1 (Expected 1): "
                + minMutation(start1, end1, bank1));


        String start2 = "AACCGGTT";
        String end2 = "AAACGGTA";
        String[] bank2 = {"AACCGGTA", "AACCGCTA", "AAACGGTA"};

        System.out.println("Test Case 2 (Expected 2): "
                + minMutation(start2, end2, bank2));
    }
}