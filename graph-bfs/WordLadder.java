/**
 * LeetCode Problem: 127. Word Ladder
 *
 * Time Complexity: O(N × L × 26)
 * Space Complexity: O(N)
 *
 * Core Idea:
 * 1. Treat each word as a node.
 * 2. Edge exists if one character differs.
 * 3. Use BFS to find shortest transformation sequence.
 */
import java.util.*;

public class WordLadder {

    public static int ladderLength(String beginWord,
                                   String endWord,
                                   List<String> wordList) {

        if (beginWord.equals(endWord)) {
            return 1;
        }

        Set<String> wordSet = new HashSet<>(wordList);

        if (!wordSet.contains(endWord)) {
            return 0;
        }

        Queue<String> queue = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();

        queue.offer(beginWord);
        visited.add(beginWord);

        int level = 1;

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {

                String curr = queue.poll();

                if (curr.equals(endWord)) {
                    return level;
                }

                char[] arr = curr.toCharArray();

                for (int j = 0; j < arr.length; j++) {

                    char original = arr[j];

                    for (char c = 'a'; c <= 'z'; c++) {

                        if (c == original) continue;

                        arr[j] = c;
                        String next = new String(arr);

                        if (!visited.contains(next) && wordSet.contains(next)) {
                            visited.add(next);
                            queue.offer(next);
                        }
                    }

                    arr[j] = original;
                }
            }

            level++;
        }

        return 0;
    }

    public static void main(String[] args) {

        String begin1 = "hit";
        String end1 = "cog";
        List<String> wordList1 = Arrays.asList("hot","dot","dog","lot","log","cog");

        System.out.println("Test Case 1 (Expected 5): "
                + ladderLength(begin1, end1, wordList1));


        String begin2 = "hit";
        String end2 = "cog";
        List<String> wordList2 = Arrays.asList("hot","dot","dog","lot","log");

        System.out.println("Test Case 2 (Expected 0): "
                + ladderLength(begin2, end2, wordList2));
    }
}