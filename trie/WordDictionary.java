/**
 * LeetCode Problem: 211. Design Add and Search Words Data Structure
 *
 * Time Complexity:
 *   addWord : O(L)
 *   search  : O(26^L) worst-case (wildcards)
 *
 * Space Complexity: O(N × L)
 *
 * Core Idea:
 * 1. Use Trie structure.
 * 2. For normal characters, traverse normally.
 * 3. For '.', branch to all possible children (DFS).
 */
public class WordDictionary {

    private static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd;
    }

    private final TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {

        if (word == null || word.isEmpty()) return;

        TrieNode node = root;

        for (char c : word.toCharArray()) {

            int index = c - 'a';

            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }

            node = node.children[index];
        }

        node.isEnd = true;
    }

    public boolean search(String word) {

        if (word == null) return false;

        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int index, TrieNode node) {

        if (node == null) {
            return false;
        }

        if (index == word.length()) {
            return node.isEnd;
        }

        char c = word.charAt(index);

        if (c == '.') {

            for (TrieNode child : node.children) {
                if (child != null && dfs(word, index + 1, child)) {
                    return true;
                }
            }

            return false;

        } else {

            int childIndex = c - 'a';
            return dfs(word, index + 1, node.children[childIndex]);
        }
    }
}