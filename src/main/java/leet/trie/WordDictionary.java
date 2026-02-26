package leet.trie;

public class WordDictionary {

    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd;
    }

    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
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
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int index, TrieNode node) {

        if (node == null) return false;

        if (index == word.length()) {
            return node.isEnd;
        }

        char c = word.charAt(index);

        if (c == '.') {
            for (TrieNode child : node.children) {
                if (dfs(word, index + 1, child)) {
                    return true;
                }
            }
            return false;
        } else {
            int i = c - 'a';
            return dfs(word, index + 1, node.children[i]);
        }
    }

    public static void main(String[] args) {

        WordDictionary dict = new WordDictionary();

        dict.addWord("bad");
        dict.addWord("dad");
        dict.addWord("mad");

        System.out.println(dict.search("pad")); // false
        System.out.println(dict.search("bad")); // true
        System.out.println(dict.search(".ad")); // true
        System.out.println(dict.search("b..")); // true
    }
}
