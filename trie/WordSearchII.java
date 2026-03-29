/**
 * LeetCode Problem: 212. Word Search II
 *
 * Time Complexity:
 *   Build Trie : O(W × L)
 *   DFS Search : O(M × N × 4^L) worst-case (heavily pruned)
 *
 * Space Complexity:
 *   Trie       : O(W × L)
 *   Recursion  : O(L)
 *
 * Core Idea:
 * 1. Build Trie from words.
 * 2. Run DFS from each board cell.
 * 3. Prune search when prefix not in Trie.
 * 4. Mark visited cells in-place.
 */
import java.util.*;

public class WordSearchII {

    private static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word; // non-null when end of word
    }

    private final TrieNode root = new TrieNode();
    private final List<String> result = new ArrayList<>();

    public List<String> findWords(char[][] board, String[] words) {

        if (board == null || board.length == 0 ||
                words == null || words.length == 0) {
            return result;
        }

        for (String word : words) {
            insert(word);
        }

        int rows = board.length;
        int cols = board[0].length;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                dfs(board, r, c, root);
            }
        }

        return result;
    }

    private void insert(String word) {

        TrieNode node = root;

        for (char c : word.toCharArray()) {

            int index = c - 'a';

            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }

            node = node.children[index];
        }

        node.word = word;
    }

    private void dfs(char[][] board, int r, int c, TrieNode node) {

        if (r < 0 || c < 0 ||
                r >= board.length || c >= board[0].length) {
            return;
        }

        char ch = board[r][c];

        if (ch == '#' || node.children[ch - 'a'] == null) {
            return;
        }

        node = node.children[ch - 'a'];

        if (node.word != null) {
            result.add(node.word);
            node.word = null; // prevent duplicates
        }

        board[r][c] = '#';

        dfs(board, r + 1, c, node);
        dfs(board, r - 1, c, node);
        dfs(board, r, c + 1, node);
        dfs(board, r, c - 1, node);

        board[r][c] = ch;
    }

    public static void main(String[] args) {

        char[][] board1 = {
                {'o','a','a','n'},
                {'e','t','a','e'},
                {'i','h','k','r'},
                {'i','f','l','v'}
        };

        String[] words1 = {"oath","pea","eat","rain"};

        WordSearchII solver1 = new WordSearchII();
        System.out.println("Test Case 1 (Expected [oath, eat]): "
                + solver1.findWords(board1, words1));

        char[][] board2 = {
                {'a','b'},
                {'c','d'}
        };

        String[] words2 = {"abcb", "abcd", "acdb"};

        WordSearchII solver2 = new WordSearchII();
        System.out.println("Test Case 2 (Expected [acdb]): "
                + solver2.findWords(board2, words2));
    }
}