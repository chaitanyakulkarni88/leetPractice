package leet.graphBFS;

import java.util.*;

public class WordLadder {

    public static int ladderLength(String beginWord,
                                   String endWord,
                                   List<String> wordList) {

        Set<String> wordSet = new HashSet<>(wordList);

        if (!wordSet.contains(endWord)) return 0;

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.offer(beginWord);
        visited.add(beginWord);

        int level = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String curr = queue.poll();

                if (curr.equals(endWord)) return level;

                char[] arr = curr.toCharArray();

                for (int j = 0; j < arr.length; j++) {
                    char old = arr[j];

                    for (char c = 'a'; c <= 'z'; c++) {
                        arr[j] = c;
                        String next = new String(arr);

                        if (!visited.contains(next) && wordSet.contains(next)) {
                            visited.add(next);
                            queue.offer(next);
                        }
                    }

                    arr[j] = old;
                }
            }

            level++;
        }

        return 0;
    }

    public static void main(String[] args) {

        String beginWord = "hit";
        String endWord = "cog";

        List<String> wordList = Arrays.asList(
                "hot", "dot", "dog", "lot", "log", "cog"
        );

        System.out.println("Shortest transformation length: " +
                ladderLength(beginWord, endWord, wordList));
    }
}
