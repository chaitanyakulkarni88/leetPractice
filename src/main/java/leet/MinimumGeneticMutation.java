package leet;

import java.util.*;

public class MinimumGeneticMutation {

    public static int minMutation(String start, String end, String[] bank) {

        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));

        if (!bankSet.contains(end)) return -1;

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.offer(start);
        visited.add(start);

        char[] genes = {'A', 'C', 'G', 'T'};
        int mutations = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String curr = queue.poll();

                if (curr.equals(end)) return mutations;

                char[] arr = curr.toCharArray();

                for (int j = 0; j < arr.length; j++) {
                    char old = arr[j];

                    for (char gene : genes) {
                        arr[j] = gene;
                        String next = new String(arr);

                        if (!visited.contains(next) && bankSet.contains(next)) {
                            visited.add(next);
                            queue.offer(next);
                        }
                    }

                    arr[j] = old;
                }
            }

            mutations++;
        }

        return -1;
    }

    public static void main(String[] args) {

        String start = "AACCGGTT";
        String end = "AAACGGTA";
        String[] bank = {
                "AACCGGTA",
                "AACCGCTA",
                "AAACGGTA"
        };

        System.out.println("Minimum mutations: " +
                minMutation(start, end, bank));
    }
}
