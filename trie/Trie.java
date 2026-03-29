/**
 * LeetCode Problem: 208. Implement Trie (Prefix Tree)
 *
 * Time Complexity:
 *   Insert  : O(L)
 *   Search  : O(L)
 *   Prefix  : O(L)
 *
 * Space Complexity: O(26 × N × L) worst-case
 *
 * Core Idea:
 * 1. Each node contains 26 child pointers.
 * 2. Traverse character by character.
 * 3. Mark end-of-word using boolean flag.
 */
public class Trie {

    private static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd;
    }

    private final TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {

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

        TrieNode node = traverse(word);
        return node != null && node.isEnd;
    }

    public boolean startsWith(String prefix) {

        if (prefix == null) return false;

        return traverse(prefix) != null;
    }

    private TrieNode traverse(String word) {

        TrieNode node = root;

        for (char c : word.toCharArray()) {

            int index = c - 'a';

            if (node.children[index] == null) {
                return null;
            }

            node = node.children[index];
        }

        return node;
    }

    public static void main(String[] args) {

        Trie trie = new Trie();

        trie.insert("apple");

        System.out.println("search(\"apple\") Expected true: " + trie.search("apple"));
        System.out.println("search(\"app\") Expected false: " + trie.search("app"));
        System.out.println("startsWith(\"app\") Expected true: " + trie.startsWith("app"));

        trie.insert("app");

        System.out.println("search(\"app\") Expected true: " + trie.search("app"));

        trie.insert("bat");
        trie.insert("ball");

        System.out.println("search(\"bat\") Expected true: " + trie.search("bat"));
        System.out.println("search(\"ba\") Expected false: " + trie.search("ba"));
        System.out.println("startsWith(\"ba\") Expected true: " + trie.startsWith("ba"));
        System.out.println("search(\"bad\") Expected false: " + trie.search("bad"));
    }
}